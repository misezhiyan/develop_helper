package office;

import java.nio.file.Paths;

import com.aspose.pdf.Document;
import com.aspose.pdf.SaveFormat;
import com.aspose.pdf.devices.PngDevice;
import com.aspose.pdf.devices.Resolution;

import java.io.*;

public class PdfToOffice {

    public static void main(String[] args) {
        // pdf2ppt("C:\\Users\\kimmy\\Desktop\\pdf转换\\拼钢网系统架构方案2022.7.25.pdf");
        // pdf2image("C:\\Users\\kimmy\\Desktop\\pdf\\海康p1.86.pdf");
        pdf2word("C:\\Users\\kimmy\\Desktop\\邮件\\李玉清简历.pdf");
    }

    // 转word
    public static void pdf2word(String pdfpath) {
        long old = System.currentTimeMillis();
        try {
            String wordpath = pdfpath.substring(0, pdfpath.lastIndexOf(".")) + ".docx";
            FileOutputStream os = new FileOutputStream(wordpath);
            Document doc = new Document(pdfpath);
            doc.save(os, SaveFormat.DocX);
            os.close();
            long now = System.currentTimeMillis();
            System.out.println("pdf 转 word 共耗时：" + ((now - old) / 1000.0) + "秒");
        } catch (Exception e) {
            System.out.println("pdf 转 word 失败...");
            e.printStackTrace();
        }
    }

    // 转ppt 时间长一些
    public static void pdf2ppt(String pdfpath) {
        long old = System.currentTimeMillis();
        try {
            String wordpath = pdfpath.substring(0, pdfpath.lastIndexOf(".")) + ".ppt";
            FileOutputStream os = new FileOutputStream(wordpath);
            Document doc = new Document(pdfpath);
            doc.save(os, SaveFormat.Pptx);
            os.close();
            long now = System.currentTimeMillis();
            System.out.println("pdf 转 ppt 共耗时：" + ((now - old) / 1000.0) + "秒");
        } catch (Exception e) {
            System.out.println("pdf 转 ppt 失败...");
            e.printStackTrace();
        }
    }

    // 转excel 样式差别会有点大
    public static void pdf2excel(String pdfpath) {
        long old = System.currentTimeMillis();
        try {
            String wordpath = pdfpath.substring(0, pdfpath.lastIndexOf(".")) + ".xlsx";
            FileOutputStream os = new FileOutputStream(wordpath);
            Document doc = new Document(pdfpath);
            doc.save(os, SaveFormat.Excel);
            os.close();
            long now = System.currentTimeMillis();
            System.out.println("pdf 转 excel 共耗时：" + ((now - old) / 1000.0) + "秒");
        } catch (Exception e) {
            System.out.println("pdf 转 excel 失败...");
            e.printStackTrace();
        }
    }

    // 转html
    public static void pdf2html(String pdfpath) {
        long old = System.currentTimeMillis();
        try {
            String htmlpath = pdfpath.substring(0, pdfpath.lastIndexOf(".")) + ".html";
            Document doc = new Document(pdfpath);
            doc.save(htmlpath, SaveFormat.Html);
            long now = System.currentTimeMillis();
            System.out.println("pdf 转 html 共耗时：" + ((now - old) / 1000.0) + "秒");
        } catch (Exception e) {
            System.out.println("pdf 转 html 失败...");
            e.printStackTrace();
        }
    }

    // 转图片
    public static void pdf2image(String pdfpath) {
        long old = System.currentTimeMillis();
        try {
            Resolution resolution = new Resolution(300);
            String datadir = pdfpath.substring(0, pdfpath.lastIndexOf("."));
            File imagedir = new File(datadir + "_images");
            imagedir.mkdirs();
            Document doc = new Document(pdfpath);
            PngDevice pngdevice = new PngDevice(resolution);
            for (int pagecount = 1; pagecount <= doc.getPages().size(); pagecount++) {
                OutputStream imagestream = new FileOutputStream(imagedir + "/" + pagecount + ".png");
                pngdevice.process(doc.getPages().get_Item(pagecount), imagestream);
                imagestream.close();
            }
            long now = System.currentTimeMillis();
            System.out.println("pdf 转 png 共耗时：" + ((now - old) / 1000.0) + "秒");
        } catch (Exception e) {
            System.out.println("pdf 转 png 失败...");
            e.printStackTrace();
        }
    }

}
