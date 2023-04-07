package template;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.tools.ToolManager;
import org.apache.velocity.tools.config.FactoryConfiguration;
import org.apache.velocity.tools.config.ToolConfiguration;
import org.apache.velocity.tools.config.ToolboxConfiguration;
import org.apache.velocity.tools.generic.MathTool;
import org.apache.velocity.tools.generic.NumberTool;

import java.io.StringWriter;
import java.util.Map;
import java.util.Properties;

/**
 * @description: 模板匹配数据
 * @author: liyq
 * @createtime: 2023-04-03 17:07
 */
public class TemplateMatchRunner {

    // 初始化
    static {
        Properties prop = new Properties();
        prop.put("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        // prop.put("math", "org.apache.velocity.tools.generic.NumberTool");
        // prop.put("math", new MathTool());
        // prop.put("$math", new MathTool());
        Velocity.init(prop);
    }

    /**
     * @description: 生成匹配模板内容
     * @author: liyq
     * @createtime: 2023-04-03 17:09:14
     * @param: testTemplate
     * @param: map
     * @return String
     */
    public static String matchTemplate(String templateFullPath, Map map) {
        VelocityContext context = new VelocityContext(map);
        return matchTemplate(templateFullPath, context);

    }

    /**
     * @description: 生成匹配模板内容
     * @author: liyq
     * @createtime: 2023-04-06 16:55:38
     * @param: templateFullPath
 * @param: context
     * @return String
     */
    public static String matchTemplate(String templateFullPath, VelocityContext context){
        //渲染模板
        StringWriter sw = new StringWriter();
        Template tpl = Velocity.getTemplate(templateFullPath, "UTF-8");
        tpl.merge(context, sw);
        return sw.toString();
    }
}
