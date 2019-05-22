package pers.hai.util.commons.scan;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * 类名扫描器
 *
 * Create Time: 2019-05-22 14:04
 * Last Modify: 2019-05-22
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class ClassScanner {

    private final Logger logger = Logger.getLogger(ClassScanner.class);

    /**
     *
     * 获取包名下的所有类名
     *
     * @param   pack
     *          包名
     *
     * @param   recursive
     *          是否循环迭代
     *
     * @return   类列表
     */
    public Set<Class<?>> getClasses(String pack, boolean recursive) {
        Set<Class<?>> classes = new LinkedHashSet<>();

        String packageName = pack; // 获取包的名字 并进行替换
        String packageDirName = packageName.replace('.', '/');
        Enumeration<URL> dirs; // 定义一个枚举的集合 并进行循环来处理这个目录下的things
        try {
            dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);
            while (dirs.hasMoreElements()) {
                URL url = dirs.nextElement();
                String protocol = url.getProtocol();
                if ("file".equals(protocol)) {
                    String filePath = URLDecoder.decode(url.getFile(), StandardCharsets.UTF_8); // 获取包的物理路径
                    findAndAddClassesInPackageByFile(packageName, filePath, recursive, classes);
                } else if ("jar".equals(protocol)) {
                    System.err.println("jar类型的扫描");
                    JarFile jar;
                    try {
                        jar = ((JarURLConnection) url.openConnection()).getJarFile();
                        // 从此jar包 得到一个枚举类
                        Enumeration<JarEntry> entries = jar.entries();
                        while (entries.hasMoreElements()) {
                            // 获取jar里的一个实体 可以是目录 和一些jar包里的其他文件 如META-INF等文件
                            JarEntry entry = entries.nextElement();
                            String name = entry.getName();
                            if (name.charAt(0) == '/')
                                name = name.substring(1);
                            if (name.startsWith(packageDirName)) {
                                int idx = name.lastIndexOf('/');
                                if (idx != -1)
                                    packageName = name.substring(0, idx).replace('/', '.');
                                if ((idx != -1) || recursive) {
                                    if (name.endsWith(".class") && !entry.isDirectory()) {
                                        String className = name.substring(packageName.length() + 1, name.length() - 6);
                                        try {
                                            classes.add(Class.forName(String.format("%s.%s", packageName, className)));
                                        } catch (ClassNotFoundException ex) {
                                            logger.error(ex.getMessage());
                                        }
                                    }
                                }
                            }
                        }
                    } catch (IOException ex) {
                        logger.error(ex.getMessage());
                    }
                }
            }
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }

        return classes;
    }

    // ------------------------------------------------- 内部方法分隔线 --------------------------------------------------

    private void findAndAddClassesInPackageByFile(String packageName,
                                                 String packagePath,
                                                 final boolean recursive,
                                                 Set<Class<?>> classes) {
        File dir = new File(packagePath);
        if (!dir.exists() || !dir.isDirectory())
            return;

        File[] dirfiles = dir.listFiles(new FileFilter() {
            // 自定义过滤规则 如果可以循环(包含子目录) 或则是以.class结尾的文件(编译好的java类文件)
            public boolean accept(File file) {
                return (recursive && file.isDirectory())
                        || (file.getName().endsWith(".class"));
            }
        });
        if (null == dirfiles) return;

        for (File file : dirfiles) {
            if (file.isDirectory()) {
                findAndAddClassesInPackageByFile(
                        String.format("%s.%s", packageName, file.getName()),
                        file.getAbsolutePath(),
                        recursive,
                        classes);
            } else {
                String className = file.getName().substring(0, file.getName().length() - 6);
                try {
                    classes.add(Thread.currentThread().getContextClassLoader().loadClass(String.format("%s.%s", packageName, className)));
                } catch (ClassNotFoundException ex) {
                    logger.error(ex.getMessage());
                }
            }
        }
    }
}
