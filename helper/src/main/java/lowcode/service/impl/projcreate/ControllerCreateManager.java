package lowcode.service.impl.projcreate;

import lowcode.CreateConfig;
import lowcode.entity.table.Table;
import template.TemplateMatchRunner;
import util.FileUtil;
import util.PathUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @discription entity 模板配置
 * @author kimmy
 * @date 2018年10月8日 上午10:28:34
 */
public class ControllerCreateManager {

    private static String controllerVmPath = "static/template/lowcode/controller.vm";

    public static void createFile(Table table) throws Exception {

        Map<String, Object> map = new HashMap<>();
        map.put("table", table);
        map.put("proj", new CreateConfig());
        String result = TemplateMatchRunner.matchTemplate(controllerVmPath, map);

        FileUtil.writeIntoFileWithDirNoCover(PathUtil.filePath(table.getClassName() + "Controller.java", CreateConfig.getControllerFullDir()), result);
    }
}
