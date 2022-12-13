package com.kimmy.learn.template.runner;

import com.alibaba.fastjson.JSONObject;
import com.kimmy.learn.template.analyzer.Analyzer;
import com.kimmy.learn.template.formatter.Formatter;
import com.kimmy.learn.template.formatter.LevelCounter;
import com.kimmy.learn.template.utils.StringUtils;

import java.util.List;

public class TemplateRunner {

    // 1、文本内容解析成块
    // 2、适配器执行块与数据匹配

    /**
     * 模板内容匹配结果
     * @param templateContent
     * @param paramJson
     * @return
     */
    public static String parseTemplateToString(String templateContent, JSONObject paramJson) {

        // 去掉换行
        templateContent = Formatter.removeChangeLine(templateContent);
        // 去掉重复空格
        templateContent = Formatter.formmatRepeatSpace(templateContent);

        return templateContent;
    }

    public static String matchSimpleTemplate(String templateContent, List<String> keyList, JSONObject paramJson) {
        for (int i = 0; i < keyList.size(); i++) {
            String key = keyList.get(i);
            templateContent = templateContent.replace("$" + key, StringUtils.isEmpty(StringUtils.nullToEmptyStr(paramJson.getString(key))) ? key : "$" + StringUtils.nullToEmptyStr(paramJson.getString(key)));
        }
        return templateContent;
    }

    public static void analyzeSimpleTemplate(String templateContent) {

        // 1、解析，遇到层级下降，新建执行块；遇到层级上升，内容追加到已建执行块。
        // 2、条件执行框，遇到条件开始，层级下降，遇到条件结束，层级上升
        // 3、双引号为字符串，遇到开始，层级下降，遇到结束，层级上升，双引号内层级不变更
        // 4、执行块框，遇到执行开始，层级下降，遇到执行结束，层级上升
        // 5、\不能单独存在，后不能为空，与后方符号共同组成后方符号，为转义符

        Analyzer analyzer = new Analyzer();
        analyzer.analyzeToMudules(templateContent);


    }
}
