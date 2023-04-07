package template;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 模板生成
 * @author: liyq
 * @createtime: 2023-04-03 16:48
 */
public class TemplateMain {

    // static String templatePath = "D:\\workspaces\\workspace_spring\\develop_helper\\helper\\src\\main\\resources\\static\\template";
    static String templatePath = "static\\template";

    public static void main(String[] args) {
        String testTemplate = templatePath + "\\template.vm";


        // 写参数
        Map map = new HashMap<>();
        map.put("test","随便生成什么内容");

        String result = TemplateMatchRunner.matchTemplate(testTemplate, map);

        System.out.println(result);
    }

}
