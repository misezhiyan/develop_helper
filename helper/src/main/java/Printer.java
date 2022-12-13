import org.apache.pdfbox.io.IOUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPrintable;
import org.apache.pdfbox.printing.Scaling;

import javax.print.*;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.Sides;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Printer {

    public static void main(String[] args) {

        File file = new File("C:\\Users\\kimmy\\Desktop\\发票\\53_1666087502223.pdf");
        print(file, lookupPrinter("FX DocuCentre-V C5575 PCL 6"), getPrintRequestAttributeSet(1));

    }

    private static PrintService lookupPrinter(String printerName) {
        PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);
        return Arrays.stream(printServices).filter(printTmp -> printTmp.getName().equals(printerName)).collect(Collectors.toList()).get(0);
    }

    private static void print(File file, PrintService printService, PrintRequestAttributeSet aset) {
        PDDocument document = null;
        try {
            document = PDDocument.load(file);
            PrinterJob printerJob = PrinterJob.getPrinterJob();
            printerJob.setJobName(file.getName());
            printerJob.setPrintService(printService);

            PDFPrintable pdfPrintable = new PDFPrintable(document, Scaling.ACTUAL_SIZE);
            Book book = new Book();

            PageFormat pageFormat = new PageFormat();
            pageFormat.setOrientation(PageFormat.PORTRAIT);
            // pageFormat.setPaper(getPager());
            pageFormat.setPaper(getPager());

            book.append(pdfPrintable, pageFormat, document.getNumberOfPages());

            printerJob.setPageable(book);

            printerJob.print(aset);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(document);
        }
    }

    private static Paper getPager() {
        Paper paper = new Paper();

        int width = 595;
        int height = 842;

        int marginLeft = 10;
        int marginRight = 0;
        int marginTop = 0;
        int marginBottom = 0;

        paper.setSize(width, height);
        paper.setImageableArea(marginLeft, marginRight, width - (marginLeft + marginRight), height - (marginTop + marginBottom));

        return paper;
    }

    private static PrintRequestAttributeSet getPrintRequestAttributeSet(int copies) {
        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
        aset.add(new Copies(copies));
        aset.add(MediaSizeName.ISO_A4);
        aset.add(Sides.ONE_SIDED);
        return aset;
    }
}
