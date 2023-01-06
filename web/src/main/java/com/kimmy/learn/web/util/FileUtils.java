package com.kimmy.learn.web.util;

import java.io.*;

public class FileUtils {

    public static final String POINT = ".";

    public static void main(String[] args) throws IOException {
        String filePath = "D:\\workspaces\\workspace_spring\\develop_helper\\Template\\src\\main\\resources\\mapperXml.template";
        String fileContent = readFileAsString(filePath);
    }

    private static String readFileAsString(String filePath) throws IOException {
        InputStream inputStream = new FileInputStream(filePath);

        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);

        String result = new String(bytes);
        System.out.println(result);
        return result;
    }

    private static void saveContentToFile(String content, File file) throws IOException {
        File parentPackage = file.getParentFile();
        if (!parentPackage.exists()) {
            parentPackage.mkdirs();
        }
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(content);
        fileWriter.flush();
        fileWriter.close();
    }

    private static void appendContentToFile(String content, File file) throws IOException {
        File parentPackage = file.getParentFile();
        if (!parentPackage.exists()) {
            parentPackage.mkdirs();
        }
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file, true);
        fileWriter.append(content);
        fileWriter.flush();
        fileWriter.close();
    }

    public static boolean isJavaFile(String fileSuffix) {
        return "JAVA".equals(fileSuffix.toUpperCase());
    }
}
