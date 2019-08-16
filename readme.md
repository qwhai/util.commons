## commons-core
> Description: 工具库 [持续更新]

![](https://img.shields.io/badge/java-1.8-brightgreen.svg)
![](https://img.shields.io/badge/maven-3.6.1-orangered.svg)
![](https://img.shields.io/badge/ide-IntelliJ%20IDEA-rosybrown.svg)
![](https://img.shields.io/badge/junit-4.11-darksalmon.svg)
![](https://img.shields.io/badge/version-2.1.4-cornflowerblue.svg)

----------------------------------------------

### 内容目录

- StringUtils
    - 通用字符操作工具
    - 正则表达式工具
    - 字符串编辑距离的算法实现
    - 拼音转换工具
- 数字处理
    - [NumberUtils: 数字通用工具](src/main/java/pers/hai/util/commons/nums/NumberUtils.java)
    - [HexUtils: 进制转化工具](src/main/java/pers/hai/util/commons/nums/HexUtils.java)
    - [PrimeUtils: 素数处理工具](src/main/java/pers/hai/util/commons/nums/PrimeUtils.java)
    - [RandomCore: 随机数生成器工具](src/main/java/pers/hai/util/commons/nums/RandomCore.java)
- MathUtils
    - 基于精度的四则混合运算工具
    - 几何工具类
    - 大数运算
- Containers
    - [ArrayUtils](src/main/java/pers/hai/util/commons/containers/ArrayUtils.java)
    - ListUtils
    - MapUtils
- IO
    - [FileIO](src/main/java/pers/hai/util/commons/io/FileIO.java)
- SerializationUtils
- ThreadUtils
- 常量类
    - 季节枚举
    - 星期枚举
- 网络
  - 网络工具类
  - Html解析工具
- [BloomFilter](src/main/java/pers/hai/util/commons/filter/BloomFilter.java)
- 日期时间工具
    - [DateUtils](src/main/java/pers/hai/util/commons/datetime/DateUtils.java)
    - [TimeUtils](src/main/java/pers/hai/util/commons/datetime/TimeUtils.java)
    - [CalendarUtils](src/main/java/pers/hai/util/commons/datetime/CalendarUtils.java)
- 图片工具
    - [ImageUtils](src/main/java/pers/hai/util/commons/image/ImageUtils.java)
        - 灰度化一张图片
        - 二值化一张图片
- 排序算法
    - 冒泡排序
    - 堆排序
    - 插入排序
    - 归并排序
    - 快速排序
    - 选择排序
    - Shell排序
- 加密算法
    - [Base64](src/main/java/pers/hai/util/commons/encrypt/Base64.java)
    - [MD5](src/main/java/pers/hai/util/commons/encrypt/MD5.java)
    - [SHA1](src/main/java/pers/hai/util/commons/encrypt/SHA1.java)
    - [SHA256](src/main/java/pers/hai/util/commons/encrypt/SHA256.java)
    - [DES](src/main/java/pers/hai/util/commons/encrypt/DES.java)
    - [DESded](src/main/java/pers/hai/util/commons/encrypt/DESede.java)
    - [AES](src/main/java/pers/hai/util/commons/encrypt/AES.java)
    - [RC4](src/main/java/pers/hai/util/commons/encrypt/RC4.java)
    - [SMS4](src/main/java/pers/hai/util/commons/encrypt/SMS4.java)
    - [IDEA](src/main/java/pers/hai/util/commons/encrypt/IDEA.java)
    - [PBE](src/main/java/pers/hai/util/commons/encrypt/PBE.java)
    - [Rabbit](src/main/java/pers/hai/util/commons/encrypt/Rabbit.java)
- 纯粹好玩
    - IdentityCardVerification
    - InversePolandExpression
- 屏幕
    - 截图工具 * 2
- 异常
    - CannotInstanceException(实例化异常)
    - FileNameNotExistsException(文件不存在)
    - LengthZeroException(长度为0)
    - ObjectEmptyException(空对象，已过时)
- 其他
    - [CharUtils](src/main/java/pers/hai/util/commons/CharUtils.java)
    - [ClassScanner](src/main/java/pers/hai/util/commons/scan/ClassScanner.java)


-----

© Hickey Qian 2014 - 2019

----------------------------------------------

- [Blog<sup>csdn</sup>](https://qwhai.blog.csdn.net/)
- [Github](https://github.com/qwhaib)
