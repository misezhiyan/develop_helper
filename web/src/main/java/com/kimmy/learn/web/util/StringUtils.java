package com.kimmy.learn.web.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class StringUtils extends org.springframework.util.StringUtils {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> codeList = new ArrayList<>();
        String line = null;
        while (!"end".equals(line)) {
            line = scanner.nextLine();
            if ("end".equals(line))
                continue;
            String[] split = line.split("\t");

            codeList.add(toHumpCase(split[2].toLowerCase()));
        }

        for (int i = 0; i < codeList.size(); i++) {
            System.out.println(codeList.get(i));
        }
    }

    public static String toHumpCase(String str) {

        if ("NOT_ASSGRO".equals(str)) {
            System.out.println();
        }

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
