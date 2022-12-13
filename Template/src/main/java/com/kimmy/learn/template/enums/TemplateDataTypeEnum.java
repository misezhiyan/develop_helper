package com.kimmy.learn.template.enums;

public enum TemplateDataTypeEnum {

    STRING("STRING", "字符串"),
    NUMBERIC("NUMBERIC", "数字"),
    JSON("JSON", "json格式数据"),
    LIST("LIST", "列表格式数据"),
    ;

    private String type;
    private String typeName;

    TemplateDataTypeEnum(String type, String typeName) {
        this.type = type;
        this.typeName = typeName;
    }
}
