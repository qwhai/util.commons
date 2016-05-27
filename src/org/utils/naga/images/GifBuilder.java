package org.utils.naga.images;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.utils.naga.files.FileSearchUtils;
import org.utils.naga.files.FileUtils;
import org.utils.naga.images.interf.ImageInterface;
import org.utils.naga.images.libs.AnimatedGifEncoder;

/**
 * <p>
 * GIF图片生成工具
 * </p>
 * Create Date: 2015年12月31日
 * Last Modify: 2016年5月26日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public class GifBuilder implements ImageInterface {

    private static GifBuilder instance = null;
    
    private AnimatedGifEncoder animatedGifEncoder = null;
    
    private GifBuilder() {
        initEvent();
    }
    
    private void initEvent() {
        if (animatedGifEncoder == null) {
            animatedGifEncoder = new AnimatedGifEncoder();
        }
    }
    
    /**
     * 单例模式构建对象
     * 
     * @return
     *      工具对象
     */
    public static GifBuilder newInstance() {
        if (instance == null) {
            instance = new GifBuilder();
        }
        
        return instance;
    }
    
    /**
     * 创建GIF图片
     * 
     * @param sourceFolder
     *      待合成的GIF片段
     * @param targetPath
     *      目标保存GIF图片路径
     * @throws IOException
     *      读写异常
     */
    public void create(String sourceFolder, String targetPath) throws IOException {
        create(sourceFolder, targetPath, 500);
    }
    
    /**
     * 创建GIF图片
     * 
     * @param sourceFolder
     *      待合成的GIF片段
     * @param targetPath
     *      目标保存GIF图片路径
     * @param delay
     *      画帧动画之间迟延
     * @throws IOException
     *      读写异常
     */
    public void create(String sourceFolder, String targetPath, int delay) throws IOException {
        String[] imgPaths = FileSearchUtils.getAllFileFullName(sourceFolder);
        FileUtils.copyFileByBuffer(imgPaths[1], targetPath);
        
        animatedGifEncoder.start(targetPath);
        BufferedImage buffer = null;
        for (int i = 0; i < imgPaths.length; i++) {
            animatedGifEncoder.setDelay(delay);
            buffer = ImageIO.read(new File(imgPaths[i]));
            animatedGifEncoder.addFrame(buffer);
        }
        animatedGifEncoder.finish();
    }
    
    @Override
    public String getTag() {
        return getClass().getName();
    }

    @Override
    public void description() {
        System.out.println("GIF图片生成工具");
    }

    
}
