package pers.hai.util.commons.web;

import java.net.InetAddress;
import java.net.UnknownHostException;

import pers.hai.util.commons.excep.CannotInstanceException;

/**
 * 这是一个与网络有关的工具类，处理一些网络上的操作
 *
 * Create Date: 2015‎年‎11‎月‎25日
 * Last Modify: 2016年5月26日
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class InternetUtils {

    // 禁止实例化
    private InternetUtils() throws CannotInstanceException {
        throw new CannotInstanceException("不要试图实例化我");
    }

    // TODO ------------------------------------------- 内部类标识分隔线 ----------------------------------------------------------
    
    /**
     * 与IP地址有关
     * 2015年11月25日
     * 
     * @author Q-WHai
     * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
     */
    public static class IpUtils {
        
        private IpUtils() throws CannotInstanceException {
            throw new CannotInstanceException("不要试图实例化我");
        }

        /**
         * 将127.0.0.1形式的IP地址转换成十进制整数，这里没有进行任何错误处理
         * 
         * @param strIp
         *          127.0.0.1形式的IP地址
         * @return
         *          127.0.0.1形式的IP地址所对应的整型IP
         */
        public static long ipToLong(String strIp){
            long[] ip = new long[4];
            
            //先找到IP地址字符串中.的位置
            int position1 = strIp.indexOf(".");
            int position2 = strIp.indexOf(".", position1 + 1);
            int position3 = strIp.indexOf(".", position2 + 1);
            
            //将每个.之间的字符串转换成整型
            ip[0] = Long.parseLong(strIp.substring(0, position1));
            ip[1] = Long.parseLong(strIp.substring(position1+1, position2));
            ip[2] = Long.parseLong(strIp.substring(position2+1, position3));
            ip[3] = Long.parseLong(strIp.substring(position3+1));
            
            return (ip[0] << 24) + (ip[1] << 16) + (ip[2] << 8) + ip[3];
        }
       
        /**
         * 将十进制整数形式转换成127.0.0.1形式的ip地址
         * 
         * @param longIp
         *          整型IP
         * @return
         *          整型IP所对应的127.0.0.1形式的IP地址
         */
        public static String longToIP(long longIp){
            StringBuffer sb = new StringBuffer("");
            
            //直接右移24位
            sb.append(String.valueOf((longIp >>> 24)));
            sb.append(".");
            
            //将高8位置0，然后右移16位
            sb.append(String.valueOf((longIp & 0x00FFFFFF) >>> 16));
            sb.append(".");
            
            //将高16位置0，然后右移8位
            sb.append(String.valueOf((longIp & 0x0000FFFF) >>> 8));
            sb.append(".");
            
            //将高24位置0
            sb.append(String.valueOf((longIp & 0x000000FF)));
            
            return sb.toString();
        }
        
        /**
         * 根据域名获得对应的IP地址
         * 
         * @param domainName
         *          域名地址
         * @return
         *          域名所对应的IP地址
         */
        public static String getIP(String domainName) {
            InetAddress iAddress;
            try {
                iAddress = InetAddress.getByName(domainName);
                return iAddress.getHostAddress();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
            
            return null;
        }
    }
}
