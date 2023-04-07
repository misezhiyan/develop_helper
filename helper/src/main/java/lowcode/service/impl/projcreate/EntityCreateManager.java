package lowcode.service.impl.projcreate;

import lowcode.CreateConfig;
import lowcode.entity.table.Table;
import template.TemplateMatchRunner;
import util.FileUtil;
import util.PathUtil;

import java.util.*;

/**
 * @discription entity 模板配置
 * @author kimmy
 * @date 2018年10月8日 上午10:28:34
 */
public class EntityCreateManager {

    private static String entityVmPath = "static/template/lowcode/entity.vm";

    public static void createFile(Table table) throws Exception {

        Map<String, Object> map = new HashMap<>();
        map.put("table", table);
        map.put("proj", new CreateConfig());
        String result = TemplateMatchRunner.matchTemplate(entityVmPath, map);

        FileUtil.writeIntoFileWithDirNoCover(PathUtil.filePath(table.getClassName() + ".java", CreateConfig.getEntityFullDir()), result);
    }
}
