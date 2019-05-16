package pers.hai.util.commons.nums;

import java.util.HashMap;
import java.util.Map;

import pers.hai.util.commons.str.StringUtils;
import pers.hai.util.commons.consts.MemoryUnit;
import pers.hai.util.commons.excep.CannotInstanceException;

/**
 * <p>
 * 单位转化工具
 * </p>
 * Create Date: 2015年12月1日
 * Last Modify: 2016年5月26日
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class UnitConversion {

    // 禁止实例化
    private UnitConversion() throws CannotInstanceException {
        throw new CannotInstanceException("请不要试图实例化我");
    }

    // TODO ------------------------------------------- 内部类标识分隔线 ----------------------------------------------------------
    
    /**
     * 时间单位转化工具
     * 2015年12月1日
     * 
     * @author Q-WHai
     * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
     */
    public static class TimeUtils {
        
        /**
         * 将时间秒数转化成HH:MM:SS的格式
         * 
         * @param second
         *      时间(秒数)
         * @return
         *      格式时间
         */
        public static String second2HHMMSS(String second) {

            int h = (int) (Double.parseDouble(second) / 60 / 60);
            int m = (int) (Double.parseDouble(second) / 60) % 60;
            int s = (int) (Double.parseDouble(second)) % 60;

            if (h == 0 && m == 0 && s == 0) {
                return "-";
            }
            return (String.format("%1$,02d", h) + ":"
                    + String.format("%1$,02d", m) + ":"
                    + String.format("%1$,02d", s));
        }

        /**
         * 将时间秒数转化成MM:SS的格式
         * 
         * @param second
         *      时间(秒数)
         * @return
         *      格式时间
         */
        public static String second2MMSS(String second) {
            if (StringUtils.isEmpty(second)) {
                return null;
            }
            int h = (int) (Double.parseDouble(second) / 60 / 60);
            int m = (int) (Double.parseDouble(second) / 60) % 60;
            int s = (int) (Double.parseDouble(second)) % 60;

            if (h == 0 && m == 0 && s == 0) {
                return "-";
            }
            return (String.format("%1$,02d", h) + ":"
                    + String.format("%1$,02d", m));
        }
    }
    
    // TODO ------------------------------------------- 内部类标识分隔线 ----------------------------------------------------------

    /**
     * 网络单位(比如流量)转化工具
     * 2015年12月1日
     * 
     * @author Q-WHai
     * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
     */
    public static class Network {

        public static final int BYTE = 1;
        public static final int KB = 2;
        public static final int MB = 3;
        public static final int GB = 4;
        public static final int TB = 5;

        public static final int KBIT = 6;
        public static final int MBIT = 7;

        public String networkTranslate(int unit, double b) {

            if (b == 0 || b == -1) {
                return "-";
            }

            String networkUnit = "";
            int unitLevel = unit;
            // 网络单位智能转化
            while ((b / 1024) >= 1) {
                if (unitLevel >= TB) {
                    break;
                }
                unitLevel++;
                b /= 1024;
            }
            networkUnit = StringUtils.formatDoubleString(b, "#0.0")
                    + getNetworkUnit(unitLevel);

            return networkUnit;
        }

        public String networkTranslateForBite(int unit, double b) {

            if (b == 0) {
                return "-";
            }

            String networkUnit = "";
            int unitLevel = unit;
            // 网络单位智能转化
            while ((b / 1024) >= 1) {
                if (unitLevel >= MBIT) {
                    break;
                }
                unitLevel++;
                b /= 1024;
            }

            networkUnit = StringUtils.formatDoubleString(b, "#0.0")
                    + getNetworkBiteUnit(unitLevel);
            return networkUnit;
        }

        public double Byte2KB(double b) {
            if (b > 0) {
                return b / 1024;
            }

            return 0;
        }

        public double Byte2MB(double b) {
            if (b > 0) {
                return b / 1024 / 1024;
            }

            return 0;
        }

        public double Byte2GB(double b) {
            if (b > 0) {
                return b / 1024 / 1024 / 1024;
            }

            return 0;
        }

        public double KB2MB(double b) {
            if (b > 0) {
                return b / 1024;
            }

            return 0;
        }

        public double kb2mb(double b) {
            if (b > 0) {
                return b / 1024;
            }

            return 0;
        }

        public double KB2GB(double b) {
            if (b > 0) {
                return b / 1024 / 1024;
            }

            return 0;
        }

        public double MB2GB(double b) {
            if (b > 0) {
                return b / 1024;
            }

            return 0;
        }

        public double GB2MB(double b) {
            if (b > 0) {
                return b * 1024;
            }

            return 0;
        }

        public double GB2KB(double b) {
            if (b > 0) {
                return b * 1024 * 1024;
            }

            return 0;
        }

        public double MB2KB(double b) {
            if (b > 0) {
                return b * 1024;
            }

            return 0;
        }

        private String getNetworkUnit(int unit) {
            switch (unit) {
            case UnitConversion.Network.BYTE:
                return "B";
            case UnitConversion.Network.KB:
                return "KB";
            case UnitConversion.Network.MB:
                return "MB";
            case UnitConversion.Network.GB:
                return "GB";
            case UnitConversion.Network.TB:
                return "TB";

            default:
                break;
            }

            return null;
        }

        private String getNetworkBiteUnit(int unit) {
            switch (unit) {
            case UnitConversion.Network.KBIT:
                // return "kbps";
                return "KBps";
            case UnitConversion.Network.MBIT:
                // return "mbps";
                return "MBps";

            default:
                break;
            }

            return null;
        }
    }

    // TODO ------------------------------------------- 内部类标识分隔线 ----------------------------------------------------------
    
    /**
     * 频率单位转化工具
     * 2015年12月1日
     * 
     * @author Q-WHai
     * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
     */
    public static class Frequency {
        public static final int KHz = 1;
        public static final int MHz = 2;
        public static final int GHz = 3;

        public static String frequencyTranslate(int unit, double frequency) {
            if (frequency == 0 || frequency == -1) {
                return "-";
            }

            String frequencyUnit = "";
            int unitLevel = unit;
            // 网络单位智能转化
            while ((frequency / 1024) >= 1) {
                if (unitLevel >= GHz) {
                    break;
                }
                unitLevel++;
                frequency /= 1024;
            }
            frequencyUnit = StringUtils.formatDoubleString(frequency, "#0.0")
                    + getCPUFrequencyUnit(unitLevel);
            return frequencyUnit;
        }

        private static String getCPUFrequencyUnit(int unit) {
            switch (unit) {
            case UnitConversion.Frequency.KHz:
                return "KHz";
            case UnitConversion.Frequency.MHz:
                return "MHz";
            case UnitConversion.Frequency.GHz:
                return "GHz";

            default:
                break;
            }

            return null;
        }
    }
    
    // TODO ------------------------------------------- 内部类标识分隔线 ----------------------------------------------------------

    /**
     * 存储(比如内存)单位转化工具
     * 2015年12月1日
     * 
     * @author Q-WHai
     * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
     */
    public static class Memory {
        
        /**
         * 将当前的存储智能转化为一个合适的单位
         * 
         * @param unit
         *      当前存储的单位
         * @param memory
         *      当前存储量
         * @return
         *      合适的表示
         */
        public static String biggerUnitTranslate(MemoryUnit unit, double memory) {
            
            double resultMemory = memory;
            MemoryUnit resultUnit = unit;
            
            while (!isMaxUnit(resultUnit) && resultMemory >= 1024) {
                resultMemory /= 1024;
                resultUnit = nextBiggerUnit(resultUnit);
            }
            
            return StringUtils.formatDoubleString(resultMemory, "#0.00") + resultUnit.toString();
        }
        
        /*
         * 获得比当前单位还要大的单位
         * 
         * @param unit
         *      当前的存储单位
         * @return
         *      更大的存储单位
         */
        private static MemoryUnit nextBiggerUnit(MemoryUnit unit) {
            if (unit == null) {
                throw new NullPointerException();
            }
            
            Map<MemoryUnit, MemoryUnit> nextMap = new HashMap<>();
            nextMap.put(MemoryUnit.Bit, MemoryUnit.Byte);
            nextMap.put(MemoryUnit.Byte, MemoryUnit.KB);
            nextMap.put(MemoryUnit.KB, MemoryUnit.MB);
            nextMap.put(MemoryUnit.MB, MemoryUnit.GB);
            nextMap.put(MemoryUnit.GB, MemoryUnit.TB);
            nextMap.put(MemoryUnit.TB, MemoryUnit.PB);
            nextMap.put(MemoryUnit.PB, MemoryUnit.EB);
            nextMap.put(MemoryUnit.EB, MemoryUnit.ZB);
            nextMap.put(MemoryUnit.ZB, MemoryUnit.YB);
            nextMap.put(MemoryUnit.YB, MemoryUnit.NB);
            nextMap.put(MemoryUnit.NB, MemoryUnit.DB);
            
            return nextMap.get(unit);
        }
        
        /*
         * 是否是最大的存储单位
         * 
         * @param unit
         *      当前的存储单位
         * @return
         *      结果
         */
        private static boolean isMaxUnit(MemoryUnit unit) {
            return unit == MemoryUnit.DB;
        }
    }
}
