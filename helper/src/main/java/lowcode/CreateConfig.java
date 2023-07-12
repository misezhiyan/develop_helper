package lowcode;

import util.PathUtil;

/**
 * @description: 文件生成配置
 * @author: liyq
 * @createtime: 2023-04-06 13:45
 */
public class CreateConfig {

    private static final String author = "kimmy";

    // private static final  String projBaseDir = "D:\\workspaces\\workspace_spring\\develop_helper\\helper";
    private static final String projBaseDir = "D:\\workspaces\\workspace_spring\\develop_helper\\daydayup";
    private static final String javaDir = "src.main.java";
    private static final String resourcesDir = "src.main.resources";

    // private static final  String entityDir = "media.pic.recognize.train.entity";
    // private static final  String mapperDir = "media.pic.recognize.train.mapper";
    // private static final  String mapperxmlDir = "mapper.recognize";
    // private static final  String serviceDir = "media.pic.recognize.train.service";
    // private static final  String serviceimplDir = "media.pic.recognize.train.service.impl";
    // private static final  String controllerDir = "media.pic.recognize.train.controller";
    private static final String entityDir = "com.daydayup.entity";
    private static final String mapperDir = "com.daydayup.mapper";
    private static final String mapperxmlDir = "com.daydayup.mapper";
    private static final String serviceDir = "com.daydayup.service";
    private static final String serviceimplDir = "com.daydayup.service.impl";
    private static final String controllerDir = "com.daydayup.controller";
    private static final String voDir = "com.daydayup.vo";
    private static final String requestDir = voDir + ".request";
    private static final String responseDir = voDir + ".response";

    private static final String entityFullDir = PathUtil.combineLinePath(projBaseDir, javaDir, entityDir);
    private static final String mapperFullDir = PathUtil.combineLinePath(projBaseDir, javaDir, mapperDir);
    private static final String mapperxmlFullDir = PathUtil.combineLinePath(projBaseDir, resourcesDir, mapperxmlDir);
    private static final String serviceFullDir = PathUtil.combineLinePath(projBaseDir, javaDir, serviceDir);
    private static final String serviceImplFullDir = PathUtil.combineLinePath(projBaseDir, javaDir, serviceimplDir);
    private static final String controllerFullDir = PathUtil.combineLinePath(projBaseDir, javaDir, controllerDir);
    private static final String requestFullDir = PathUtil.combineLinePath(projBaseDir, javaDir, requestDir);
    private static final String responseFullDir = PathUtil.combineLinePath(projBaseDir, javaDir, responseDir);

    public static String getProjBaseDir() {
        return projBaseDir;
    }

    public static String getJavaDir() {
        return javaDir;
    }

    public static String getResourcesDir() {
        return resourcesDir;
    }

    public static String getEntityDir() {
        return entityDir;
    }

    public static String getMapperDir() {
        return mapperDir;
    }

    public static String getMapperxmlDir() {
        return mapperxmlDir;
    }

    public static String getServiceDir() {
        return serviceDir;
    }

    public static String getServiceimplDir() {
        return serviceimplDir;
    }

    public static String getEntityFullDir() {
        return entityFullDir;
    }

    public static String getMapperFullDir() {
        return mapperFullDir;
    }

    public static String getMapperxmlFullDir() {
        return mapperxmlFullDir;
    }

    public static String getServiceFullDir() {
        return serviceFullDir;
    }

    public static String getServiceImplFullDir() {
        return serviceImplFullDir;
    }

    public static String getControllerDir() {
        return controllerDir;
    }

    public static String getControllerFullDir() {
        return controllerFullDir;
    }

    public static String getAuthor() {
        return author;
    }

    public static String getVoDir() {
        return voDir;
    }

    public static String getRequestDir() {
        return requestDir;
    }

    public static String getResponseDir() {
        return responseDir;
    }

    public static String getRequestFullDir() {
        return requestFullDir;
    }

    public static String getResponseFullDir() {
        return responseFullDir;
    }
}
