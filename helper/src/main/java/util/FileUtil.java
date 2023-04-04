package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public static void main(String[] args) throws Exception {
        fileListInDir("C:\\Users\\misez\\Desktop\\翻译\\文件");
    }

    /**
     * @description: 读取文件夹下文件列表
     * @author: liyq
     * @createtime: 2023-04-03 16:28:45
     * @param: dirPath
     * @return File>
     */
    public static List<File> fileListInDir(String dirPath) throws Exception {

        List<File> filePathList = new ArrayList<File>();

        File dir = new File(dirPath);
        if (!dir.exists()) {
            throw new Exception("文件夹不存在");
        }
        if (!dir.isDirectory()) {
            throw new Exception("选中文件不是文件夹");
        }

        File[] listFiles = dir.listFiles();

        for (int i = 0; i < listFiles.length; i++) {
            File file = listFiles[i];
            if (file.isFile()) {
                filePathList.add(file);
            }
        }

        return filePathList;
    }

    /**
     * @description: 读取文件夹下文件路径列表
     * @author: liyq
     * @createtime: 2023-04-03 16:28:56
     * @param: dirPath
     * @return String>
     */
    public static List<String> filePathListInDir(String dirPath) throws Exception {

        List<String> filePathList = new ArrayList<String>();

        File dir = new File(dirPath);
        if (!dir.exists()) {
            throw new Exception("文件夹不存在");
        }
        if (!dir.isDirectory()) {
            throw new Exception("选中文件不是文件夹");
        }

        File[] listFiles = dir.listFiles();

        for (int i = 0; i < listFiles.length; i++) {
            File file = listFiles[i];
            if (file.isFile()) {
                String path = file.getPath();
                filePathList.add(path);
            }
        }

        return filePathList;
    }

    /**
     * @description: 创建文件
     * @author: liyq
     * @createtime: 2023-04-03 16:29:12
     * @param: fileRealPath
     * @param: content
     */
    public static void writeIntoFileWithDir(String fileRealPath, String content) throws Exception {
        File file = new File(fileRealPath);
        File file_package = file.getParentFile();
        if (!file_package.exists())
            file_package.mkdirs();
        writeIntoFileByPath(fileRealPath, content);
    }

    /**
     * @description: 追加到文件
     * @author: liyq
     * @createtime: 2023-04-03 16:29:32
     * @param: fileRealPath
     * @param: content
     */
    public static void appendToFile(String fileRealPath, String content) throws Exception {

        String file_content = fileReadToString(fileRealPath);

        // file_content += "\r\n";
        // file_content += "\r\n";

        if (null == file_content)
            file_content = content;
        else
            file_content += content;

        writeIntoFileByPath(fileRealPath, file_content);
    }

    /**
     * @description: 读取文件内容
     * @author: liyq
     * @createtime: 2023-04-03 16:30:09
     * @param: filePath
     * @return String
     */
    public static String fileReadToString(String fileFullName) throws Exception {

        return fileReadToString(new File(fileFullName));
    }

    /**
     * @description: 读取文件内容
     * @author: liyq
     * @createtime: 2023-04-03 16:30:41
     * @param: file
     * @return String
     */
    public static String fileReadToString(File file) throws Exception {

        if (!file.exists())
            throw new Exception("文件不存在");

        Long filelength = file.length();
        byte[] filecontent = new byte[filelength.intValue()];
        FileInputStream in = null;
        try {
            in = new FileInputStream(file);
            in.read(filecontent);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            in.close();
        }

        String encoding = util.EncodingUtil.getFileEncodingType(file.getAbsolutePath());
        String result = new String(filecontent, encoding);

        return result;
    }

    /**
     * @description: 写入文件
     * @author: liyq
     * @createtime: 2023-04-03 16:32:40
     * @param: filePath
     * @param: fileName
     * @param: fileType
     * @param: content
     * @return boolean
     */
    public static boolean writeIntoFile(String filePath, String fileName, String fileType, String content) throws Exception {

        if (StringUtil.isEmpty(filePath) || StringUtil.isEmpty(fileName) || StringUtil.isEmpty(fileType))
            throw new Exception("can not be null");

        String fileFullName = fileName.trim() + "." + fileType.trim();
        return writeIntoFile(filePath, fileFullName, content);
    }

    /**
     * @description: 写入文件
     * @author: liyq
     * @createtime: 2023-04-03 16:32:57
     * @param: filePath
     * @param: fileFullName
     * @param: content
     * @return boolean
     */
    private static boolean writeIntoFile(String filePath, String fileFullName, String content) throws Exception {

        if (StringUtil.isEmpty(filePath) || StringUtil.isEmpty(fileFullName))
            throw new Exception("can not be null");
        String fileRealPath = filePath.trim() + fileFullName.trim();
        File file_package = new File(filePath);
        if (!file_package.exists())
            file_package.mkdirs();

        return writeIntoFileByPath(fileRealPath, content);
    }

    /*
     * @description: 写入文件
     * @author: liyq
     * @createtime: 2023-04-03 16:33:18
     * @param: fileRealPath
     * @param: content
     * @return boolean
     */
    private static boolean writeIntoFileByPath(String fileRealPath, String content) throws Exception {
        if (StringUtil.isEmpty(fileRealPath))
            throw new Exception("can not be null");

        File file = new File(fileRealPath);
        if (!file.exists()) {
            File pkg = file.getParentFile();
            pkg.mkdirs();
            file.createNewFile();
        }

        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(fileRealPath), "UTF-8");
        out.write(content);
        out.flush();
        out.close();

        return true;
    }

    /**
     * @description: 写入文件
     * @author: liyq
     * @createtime: 2023-04-03 16:33:31
     * @param: file
     * @param: content
     * @return boolean
     */
    public static boolean writeIntoFile(File file, String content) throws Exception {

        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(file.getPath()), "UTF-8");
        out.write(content);
        out.flush();
        out.close();

        return true;
    }

}
