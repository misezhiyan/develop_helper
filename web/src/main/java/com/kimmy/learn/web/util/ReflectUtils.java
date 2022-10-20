package com.kimmy.learn.web.util;

import java.util.Locale;

public class ReflectUtils extends org.springframework.util.StringUtils {

    public static String toHumpCase(String str) {
        if (isEmpty(str)) {
            return "";
        }

        if (!str.contains("_")) {
            return str;
        }

        while (str.contains("_")) {
            int i = str.indexOf("_");
            if (i < str.length() - 1) {
                str = str.substring(0, i) + str.substring(i + 1, i + 2).toUpperCase(Locale.ROOT) + str.substring(i + 2);
            } else {
                str = str.substring(0, i);
            }
        }

        return str;
    }

}
