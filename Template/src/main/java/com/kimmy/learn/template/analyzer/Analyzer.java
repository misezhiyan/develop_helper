package com.kimmy.learn.template.analyzer;

/**
 * 解析器
 */
public class Analyzer {

    int pointer = 0;
    int level = 0;
    String templateContent_source;

    public void analyzeToMudules(String templateContent) {

        // 1、解析，遇到层级下降，新建执行块；遇到层级上升，内容追加到已建执行块。
        // 2、条件执行框，遇到条件开始，层级下降，遇到条件结束，层级上升
        // 3、双引号为字符串，遇到开始，层级下降，遇到结束，层级上升，双引号内层级不变更
        // 4、执行块框，遇到执行开始，层级下降，遇到执行结束，层级上升
        // 5、\不能单独存在，后不能为空，与后方符号共同组成后方符号，为转义符

        this.templateContent_source = templateContent;

        templateContent_source = templateContent_source.trim();

    }

}
