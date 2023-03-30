package util;

import java.util.Arrays;
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
    public static String combine(String ... arr) {
        return Arrays.stream(arr).collect(Collectors.joining());
    }
}
