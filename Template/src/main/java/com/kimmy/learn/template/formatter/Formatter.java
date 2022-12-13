package com.kimmy.learn.template.formatter;

public class Formatter {

    public static final String SPACE = " ";
    static final String TAB = " ";
    static final String RETURN = "\r";
    static final String CHANGELINE = "\n";

    // 一、在Windows中
    // \r：表示回车，回到当前行的行首，而不会换到下一行，如果接着输出的话，本行以前的内容会被逐一覆盖（光标在该行的头部）
    // \r\n：表示换行，换到当前位置的下一行（光标在下一行的头部）
    // 二、在Unix/Linux系统中
    // \n：表示换行
    // 三、在Mac中
    // \r：表示换行

    public static String formmatRepeatSpace(String templateContent) {
        if (templateContent.contains(TAB))
            templateContent = templateContent.replace(TAB, SPACE);
        while (templateContent.contains(doubleSpace())) {
            templateContent = replaceDoubleSpace(templateContent, SPACE);
        }
        return templateContent.trim();
    }

    private static String replaceDoubleSpace(String templateContent, String spaceStr) {

        return templateContent.replace(doubleSpace(), spaceStr);
    }

    private static String doubleSpace() {
        return SPACE + SPACE;
    }

    public static String removeChangeLine(String templateContent) {
        return templateContent.replace(RETURN, SPACE).replace(CHANGELINE, SPACE);
    }
}
