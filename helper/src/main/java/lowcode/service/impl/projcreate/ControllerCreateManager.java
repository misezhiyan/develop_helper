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
    private static String requestVmPath = "static/template/lowcode/request.vm";
    private static String responseVmPath = "static/template/lowcode/response.vm";

    public static void createFile(Table table) throws Exception {

        Map<String, Object> map = new HashMap<>();
        map.put("table", table);
        map.put("proj", new CreateConfig());
        String controller = TemplateMatchRunner.matchTemplate(controllerVmPath, map);
        FileUtil.writeIntoFileWithDirNoCover(PathUtil.filePath(table.getClassName() + "Controller.java", CreateConfig.getControllerFullDir()), controller);

        map.put("optType", "Add");
        String addRequest = TemplateMatchRunner.matchTemplate(requestVmPath, map);
        FileUtil.writeIntoFileWithDirNoCover(PathUtil.filePath(table.getClassName() + map.get("optType") + "Request.java", CreateConfig.getRequestFullDir()), addRequest);
        String addResponse = TemplateMatchRunner.matchTemplate(responseVmPath, map);
        FileUtil.writeIntoFileWithDirNoCover(PathUtil.filePath(table.getClassName() + map.get("optType") + "Response.java", CreateConfig.getResponseFullDir()), addResponse);

        map.put("optType", "List");
        String listRequest = TemplateMatchRunner.matchTemplate(requestVmPath, map);
        FileUtil.writeIntoFileWithDirNoCover(PathUtil.filePath(table.getClassName() + map.get("optType") + "Request.java", CreateConfig.getRequestFullDir()), listRequest);
        String listResponse = TemplateMatchRunner.matchTemplate(responseVmPath, map);
        FileUtil.writeIntoFileWithDirNoCover(PathUtil.filePath(table.getClassName() + map.get("optType") + "Response.java", CreateConfig.getResponseFullDir()), listResponse);

        map.put("optType", "Del");
        String delRequest = TemplateMatchRunner.matchTemplate(requestVmPath, map);
        FileUtil.writeIntoFileWithDirNoCover(PathUtil.filePath(table.getClassName() + map.get("optType") + "Request.java", CreateConfig.getRequestFullDir()), delRequest);
        String delResponse = TemplateMatchRunner.matchTemplate(responseVmPath, map);
        FileUtil.writeIntoFileWithDirNoCover(PathUtil.filePath(table.getClassName() + map.get("optType") + "Response.java", CreateConfig.getResponseFullDir()), delResponse);
    }
}
