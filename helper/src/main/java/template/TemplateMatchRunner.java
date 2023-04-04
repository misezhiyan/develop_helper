package template;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.io.StringWriter;
import java.util.Map;
import java.util.Properties;

/**
 * @description: 模板匹配数据
 * @author: liyq
 * @createtime: 2023-04-03 17:07
 */
public class TemplateMatchRunner {

    /**
     * @description: 生成匹配模板内容
     * @author: liyq
     * @createtime: 2023-04-03 17:09:14
     * @param: testTemplate
     * @param: map
     * @return String
     */
    public static String matchTemplate(String testTemplate, Map map) {

        // 初始化
        Properties prop = new Properties();
        prop.put("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        Velocity.init(prop);

        VelocityContext context = new VelocityContext(map);

        //渲染模板
        StringWriter sw = new StringWriter();
        Template tpl = Velocity.getTemplate(testTemplate, "UTF-8");
        tpl.merge(context, sw);

        return sw.toString();
    }
}
