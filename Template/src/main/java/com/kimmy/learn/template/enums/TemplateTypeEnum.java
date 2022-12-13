package com.kimmy.learn.template.enums;

public enum TemplateTypeEnum {

    TAG("TAG", "标签类"),
    FUN("FUN", "方法类"),
    ;

    private String type;
    private String typeName;

    TemplateTypeEnum(String type, String typeName) {
        this.type = type;
        this.typeName = typeName;
    }
}
