package util;

import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

public class StringUtil {

    /**
     * @description: 空判断
     * @author: liyq
     * @createtime: 2023-03-30 09:06:07
     * @param: str
     * @return boolean
     */
    public static boolean isEmpty(String str) {
        return null == str || str.length() == 0;
    }

    /**
     * @description: 拼接字符串
     * @author: liyq
     * @createtime: 2023-03-30 09:09:02
     * @return String
     */
    public static String combine(String... arr) {
        return Arrays.stream(arr).collect(Collectors.joining());
    }

    public static String leftPad(String src, int toLength, String pad) {

        if (src.length() > toLength) {
            throw new RuntimeException("原长度大于目标长度");
        }

        String dst = src;
        while (dst.length() < toLength) {
            dst = pad + dst;
        }

        return dst;
    }

    /**
     * @description: 首字母大写
     * @author: liyq
     * @createtime: 2023-04-06 12:48:40
     * @param: str
     * @return String
     */
    public static String headUppercase(String str) {

        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    /**
     * @description: 首字母小写
     * @author: liyq
     * @createtime: 2023-04-06 13:28:24
     * @param: className
     * @return String
     */
    public static String headLowercase(String str) {
        return str.substring(0, 1).toLowerCase(Locale.ROOT) + str.substring(1);
    }

    /**
     * @description: 去掉尾缀
     * @author: liyq
     * @createtime: 2023-04-06 16:39:35
     * @param: importArea
     * @param: s
     * @return String
     */
    public static String removeEnd(String str, String suffix) {
        while (str.endsWith(suffix)) {
            str = str.substring(0, str.length() - suffix.length());
        }
        return str;
    }
}
