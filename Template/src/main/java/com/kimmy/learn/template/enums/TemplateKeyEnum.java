package com.kimmy.learn.template.enums;

public enum TemplateKeyEnum {

    COMMAND_PRE("#", "命令引领符", true),
    PARAM_PRE("$", "动态参数引领符", true),
    CONDITION_START("(", "条件语句开始", true),
    CONDITION_END(")", "条件语句结束", true),
    BODY_START("{", "执行语句开始", true),
    BODY_END("}", "执行语句结束", true),
    NOT("!", "boolean取反操作", true),
    TRANS("\\", "转移字符", true),
    QUOT("\"", "引号", true),

    IF("IF", "判断语句开始", false),
    ELSEIF("ELSEIF", "判断语句条件分支", false),
    ELSE("ELSE", "判断语句分支", false),
    ENDIF("ENDIF", "判断语句结束", false),

    FOR("FOR", "循环语句", false),
    IN("IN", "FOR循环取数", false),
    ;

    private String symbol;
    private String symbolName;
    private Boolean isSymbol;


    TemplateKeyEnum(String symbol, String symbolName, Boolean isSymbol) {
        this.symbol = symbol;
        this.symbolName = symbolName;
        this.isSymbol = isSymbol;
    }

    public static boolean isCommandPre(String commandStr) {
        return COMMAND_PRE.symbol.equalsIgnoreCase(commandStr);
    }
}
