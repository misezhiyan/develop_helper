package media.pic.recognize;

import media.pic.util.PicUtil;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.imageio.ImageIO;

/**
 * @description: 透视算法
 * @author: liyq
 * @createtime: 2023-03-28 11:37
 */
public class Perspective {

    public static void main(String[] args) throws IOException {


        String fileName = "C:\\Users\\kimmy\\Desktop\\图像识别\\纠偏.jpg";
        String outFileName = "C:\\Users\\kimmy\\Desktop\\图像识别\\透视\\" + new SimpleDateFormat("yyyyMMddHHmmsss").format(Calendar.getInstance().getTime()) + ".jpg";

        // 读取待纠偏的图像
        File input = new File(fileName);
        BufferedImage image = ImageIO.read(input);

        // 进行透视变换
        BufferedImage result = perspectiveTransform(image);
        PicUtil.saveImgToFile(result, outFileName);

    }


    /**
     * 进行透视变换
     */
    public static BufferedImage perspectiveTransform(BufferedImage image) throws IOException {

        // 定义透视变换矩阵
        double[][] matrix = {{1, 0, 0}, {0, 1, 0}, {-0.001, 0, 1}};
        // 定义变换对象
        AffineTransform transform = new AffineTransform(matrix[0][0], matrix[1][0], matrix[0][1], matrix[1][1], matrix[0][2], matrix[1][2]);
        // 定义变换操作对象
        AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);
        // 进行变换操作
        BufferedImage result = op.filter(image, null);

        return result;
    }
}
