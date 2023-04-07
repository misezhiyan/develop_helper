package lowcode.service.impl.projcreate;

import lowcode.CreateConfig;
import lowcode.entity.table.Table;
import template.TemplateMatchRunner;
import util.FileUtil;
import util.PathUtil;

import java.util.*;

/**
 * @discription
 * @author kimmy
 * @date 2018年10月8日 上午10:28:34
 */
public class ServiceCreateManager {

    private static String serviceVmPath = "static/template/lowcode/service.vm";
    private static String serviceimplVmPath = "static/template/lowcode/serviceimpl.vm";

    public static void createFile(Table table) throws Exception {
        createService(table);
        createServiceImpl(table);
    }

    private static void createServiceImpl(Table table) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("table", table);
        map.put("proj", new CreateConfig());
        String result = TemplateMatchRunner.matchTemplate(serviceimplVmPath, map);
        FileUtil.writeIntoFileWithDirNoCover(PathUtil.filePath(table.getClassName() + "ServiceImpl.java", CreateConfig.getServiceImplFullDir()), result);
    }

    private static void createService(Table table) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("table", table);
        map.put("proj", new CreateConfig());
        String result = TemplateMatchRunner.matchTemplate(serviceVmPath, map);

        FileUtil.writeIntoFileWithDirNoCover(PathUtil.filePath(table.getClassName() + "Service.java", CreateConfig.getServiceFullDir()), result);
    }

}
