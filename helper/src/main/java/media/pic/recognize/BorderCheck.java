package media.pic.recognize;

/**
 * @description: TODO
 * @author: liyq
 * @createtime: 2023-03-27 19:52
 */
public class BorderCheck {

    public static void main(String[] args) {
        // 定义原始图像矩阵
        // int[][] image = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        int[][] image = {{1, 0, 0, 0, 0}, {0, 1, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 1, 0}, {0, 0, 0, 0, 1}};

        houghChange(image);

    }

    /**
     * @description: 霍夫变换
     * @author: liyq
     * @createtime: 2023-03-28 09:32:06
     * @param: image
     */
    public static void houghChange(int[][] image) {

        int[][] sobelX = {{-1, 0, 1}, {-2, 0, 2}, {-1, 0, 1}};
        int[][] sobelY = {{1, 2, 1}, {0, 0, 0}, {-1, -2, -1}};
        // 定义结果矩阵
        int[][] result = new int[image.length][image[0].length];
        // 对每个像素进行 Sobel 边缘检测
        for (int i = 1; i < image.length - 1; i++) {
            for (int j = 1; j < image[0].length - 1; j++) {
                // 计算 Sobel 算子卷积结果
                int gx = 0, gy = 0;
                for (int k = -1; k <= 1; k++) {
                    for (int l = -1; l <= 1; l++) {
                        gx += sobelX[k + 1][l + 1] * image[i + k][j + l];
                        gy += sobelY[k + 1][l + 1] * image[i + k][j + l];
                    }
                }
                // 计算像素点的梯度值
                int gradient = (int) Math.sqrt(gx * gx + gy * gy);
                // 将梯度值保存到结果矩阵中
                result[i][j] = gradient;
            }
        }
        // 输出结果矩阵
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                if (result[i][j] != 0)
                    System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}


