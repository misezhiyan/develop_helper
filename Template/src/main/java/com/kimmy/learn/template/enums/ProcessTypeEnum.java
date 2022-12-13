package com.kimmy.learn.template.enums;

public enum ProcessTypeEnum {

    IF("IF", "判断分支流程"),
    FOR("FOR", "循环流程"),
    LOOP("LOOP", "循环流程"),
    ;

    private String processCode;
    private String processName;

    ProcessTypeEnum(String processCode, String processName) {
        this.processCode = processCode;
        this.processName = processName;
    }
}
