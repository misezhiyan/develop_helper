package media.pic.recognize;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.PerspectiveTransform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
// import javafx.scene.transform.PerspectiveTransform;
import javafx.stage.Stage;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @description: TODO
 * @author: liyq
 * @createtime: 2023-03-28 16:18
 */
public class Perspective2 extends Application {

    String fileName = "C:\\Users\\kimmy\\Desktop\\图像识别\\纠偏.jpg";
    String outFileName = "C:\\Users\\kimmy\\Desktop\\图像识别\\透视\\" + new SimpleDateFormat("yyyyMMddHHmmsss").format(Calendar.getInstance().getTime()) + ".jpg";

    // 透视算法纠偏是一种常见的图像处理技术，JDK8中可以使用JavaFX提供的PerspectiveTransform类实现透视变换。
    // 以下是一个简单的示例代码，演示如何使用PerspectiveTransform类实现透视变换：

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        // 加载图片
        Image image = new Image(new File(fileName).toURI().toString());
        ImageView imageView = new ImageView(image);

        // 创建透视变换对象
        PerspectiveTransform perspectiveTransform = new PerspectiveTransform();

        // 设置透视变换参数
        perspectiveTransform.setUlx(100);
        perspectiveTransform.setUly(100);
        perspectiveTransform.setUrx(400);
        perspectiveTransform.setUry(150);

        perspectiveTransform.setLrx(400);
        perspectiveTransform.setLry(350);
        perspectiveTransform.setLlx(100);
        perspectiveTransform.setLly(300);

        // 应用透视变换
        imageView.setEffect(perspectiveTransform);

        // 创建场景
        Group root = new Group(imageView);
        Scene scene = new Scene(root, 500, 500);

        // 显示场景
        stage.setScene(scene);
        stage.show();
    }

}
