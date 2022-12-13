package com.kimmy.learn.template.utils;

import java.io.*;

public class FileUtils {

    public static String readFileAsString(String filePath) throws IOException {
        InputStream inputStream = new FileInputStream(filePath);

        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);

        String result = new String (bytes);
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
}
