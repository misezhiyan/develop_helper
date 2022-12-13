package com.kimmy.learn.web.util;

import java.util.Locale;

public class StringUtils extends org.springframework.util.StringUtils {

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

    public static String toClassName(String _name) {
        String className = toHumpCase(_name);
        className = className.substring(0, 1).toUpperCase() + className.substring(1);
        return className;
    }
}
