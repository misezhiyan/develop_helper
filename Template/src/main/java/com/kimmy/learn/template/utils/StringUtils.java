package com.kimmy.learn.template.utils;

public class StringUtils extends org.springframework.util.StringUtils {

    public static CharSequence nullToEmptyStr(String str) {
        return null == str ? "" : str;
    }
}
