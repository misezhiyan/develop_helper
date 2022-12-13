import javax.print.*;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.MediaSize;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.Sides;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Print {

    public static void main(String[] args) {

        String filePackage = "C:\\Users\\kimmy\\Desktop\\发票";

        File basePackage = new File(filePackage);

        printPdfPackage(basePackage);

        // printPdf2();

    }

    // private static void printPdf2() {
    //     PrintPDF.main(new String[]{
    //             "-silentPrint",//静默打印
    //             "-password","abcde",//pdf打开密码
    //             "-printerName","hp Laserjet 1020" ,//指定打印机名
    //             "-orientation","auto|landscape|portrait",//打印方向，三种可选
    //             "pdfFilePath"//打印PDF文档的路径
    //     });
    // }

    private static void printPdfPackage(File basePackage) {

        File[] files = basePackage.listFiles();

        for (int i = 0; i < files.length; i++) {

            if (i != 2) {
                continue;
            }

            File file = files[i];
            System.out.println(file.getName());
            if (file.isFile()) {
                printPdf(file);
            }
        }
    }

    private static void printPdf(File file) {

        //1.得到一个文件的输入流
        FileInputStream fiStream = null;
        try {
            fiStream = new FileInputStream(file.getAbsolutePath());
        } catch (FileNotFoundException ffne) {
            ffne.printStackTrace();
        }
        if (fiStream == null) {
            return;
        }

        //这是要打印文件的格式，如果是PDF文档要设为自动识别
        // DocFlavor fileFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
        DocFlavor fileFormat = DocFlavor.INPUT_STREAM.JPEG;

        //2.得到要打印的文档类DOC
        Doc myDoc = new SimpleDoc(fiStream, fileFormat, null);

        //3.生成一个打印属性设置对象
        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
        // aset.add(MediaSize.A4);//A4纸张
        // aset.add(MediaSizeName.ISO_A4);//A4纸张
        // aset.add(new Copies(5));//Copies-打印份数5份
        // aset.add(Sides.ONE_SIDED);//双面打印

        // PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);
        // for (int i = 0; i < printServices.length; i++) {
        //     System.out.println(printServices[i].getName());
        // }
        // if (1 < 2)
        //     return;

        //4.关键一步，得到当前机器上所有已经安装的打印机
        //传入的参数是文档格式跟打印属性，只有支持这个格式与属性的打印机才会被找到
        PrintService printService;
        // PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
        PrintService[] services = PrintServiceLookup.lookupPrintServices(fileFormat, aset);
        if (services.length > 0) {
            printService = Arrays.stream(services).filter(printServiceTmp -> printServiceTmp.getName().equals("FX DocuCentre-V C5575 PCL 6")).collect(Collectors.toList()).get(0);
        } else {
            printService = PrintServiceLookup.lookupDefaultPrintService();
            System.out.println("格式未匹配到");
            return;
        }

        if (null == printService) {
            System.out.println("未获取到打印机服务");
            return;
        }
        System.out.println("打印机名称：" + printService.getName());
        //5.用打印服务生成一个文档打印任务，这里用的是第一个服务
        //也可以进行筛选，services[i].getName()可以得到打印机名称，可用名称进行比较得到自己想要的打印机
        DocPrintJob job = printService.createPrintJob();
        try {
            //6.最后一步，执行打印文档任务，传入的参数是Doc文档类，与属性(5份，双面,A4)
            job.print(myDoc, aset);//成功后电脑会提示已有文档添加到打印队列
        } catch (PrintException pe) {
            pe.printStackTrace();
        }
    }
}
