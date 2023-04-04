package media.pic.recognize.service.impl.dealarea.fature;

import media.pic.recognize.entity.Color;
import media.pic.recognize.service.impl.dealarea.entity.Point;
import media.pic.recognize.service.impl.dealarea.entity.PointCarCardFlag;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: 定点特征
 * @author: liyq
 * @createtime: 2023-03-30 16:17
 */
public class FeaturePoint {

    // 左下
    // row: 427/453  high: 363/453
    // 左上
    // row: 26/453  high: 363/1507
    // 中
    // row: 222/453  high: 468/1507
    // 右下
    // row: 24/453  high: 600 + 914/1507
    // 右上
    // row: 428/453  high: 600 + 914/1507

    static List<PointCarCardFlag> list = new ArrayList<>();

    static {
        // list.add(PointCarCardFlag.build("左上点", 1, new BigDecimal(363).divide(new BigDecimal(1507), 10, BigDecimal.ROUND_HALF_UP), new BigDecimal(26).divide(new BigDecimal(453), 10, BigDecimal.ROUND_HALF_UP)));
        // list.add(PointCarCardFlag.build("左下点", 2, new BigDecimal(363).divide(new BigDecimal(1507), 10, BigDecimal.ROUND_HALF_UP), new BigDecimal(427).divide(new BigDecimal(453), 10, BigDecimal.ROUND_HALF_UP)));
        // list.add(PointCarCardFlag.build("中间点", 3, new BigDecimal(468).divide(new BigDecimal(1507), 10, BigDecimal.ROUND_HALF_UP), new BigDecimal(222).divide(new BigDecimal(453), 10, BigDecimal.ROUND_HALF_UP)));
        // list.add(PointCarCardFlag.build("右上点", 5, new BigDecimal(1155).divide(new BigDecimal(1507), 10, BigDecimal.ROUND_HALF_UP), new BigDecimal(25).divide(new BigDecimal(453), 10, BigDecimal.ROUND_HALF_UP)));
        // list.add(PointCarCardFlag.build("右下点", 4, new BigDecimal(1155).divide(new BigDecimal(1507), 10, BigDecimal.ROUND_HALF_UP), new BigDecimal(428).divide(new BigDecimal(453), 10, BigDecimal.ROUND_HALF_UP)));

        list.add(PointCarCardFlag.build("左上点", 1, new BigDecimal(0.2404046686), new BigDecimal(0.0525009556)));
        list.add(PointCarCardFlag.build("左下点", 2, new BigDecimal(0.2404299293), new BigDecimal(0.9428881531)));
        list.add(PointCarCardFlag.build("中间点", 3, new BigDecimal(0.3079216884), new BigDecimal(0.4873164897)));
        list.add(PointCarCardFlag.build("右上点", 4, new BigDecimal(0.7635067963), new BigDecimal(0.0520407684)));
        list.add(PointCarCardFlag.build("右下点", 4, new BigDecimal(0.7636733157), new BigDecimal(0.9424762815)));
    }

    public static int[][] matchFeatureArea(int[][] square) {

        int width = square.length;
        int height = square[0].length;

        int[][] dst = new int[width][height];

        List<Point> featurePointList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            PointCarCardFlag carCardFlag = list.get(i);
            BigDecimal pointRateX = carCardFlag.getPointRateX();
            BigDecimal pointRateY = carCardFlag.getPointRateY();
            int x = pointRateX.multiply(new BigDecimal(width)).intValue();
            int y = pointRateY.multiply(new BigDecimal(height)).intValue();
            int rgb = square[x][y];
            if (rgb != Color.white) {
                System.out.println(carCardFlag.getFlag() + "特征点不是白色");
                continue;
            }
            // 填充色块颜色
            List<Point> pointList = fillColorPart(square, dst, rgb, new Point(x, y));
            featurePointList.addAll(pointList);
        }

        // 四角点填充
        // List<Point> ldList = fillColorPart(square, dst, Color.white.getRGB(), new Point(0, 0));
        // List<Point> luList = fillColorPart(square, dst, Color.white.getRGB(), new Point(0, height-1));
        // List<Point> rdList = fillColorPart(square, dst, Color.white.getRGB(), new Point(width-1, 0));
        // List<Point> ruList = fillColorPart(square, dst, Color.white.getRGB(), new Point(width-1, height-1));

        List<Point> ldList = fillColorPart(square, dst, Color.white, new Point(0, 1));
        List<Point> luList = fillColorPart(square, dst, Color.white, new Point(0, height - 1));
        List<Point> rdList = fillColorPart(square, dst, Color.white, new Point(width - 1, 1));
        List<Point> ruList = fillColorPart(square, dst, Color.white, new Point(width - 1, height - 1));

        featurePointList.addAll(ldList);
        featurePointList.addAll(luList);
        featurePointList.addAll(rdList);
        featurePointList.addAll(ruList);

        for (int i = 0; i < dst.length; i++) {
            for (int j = 0; j < dst[i].length; j++) {
                if (featurePointList.contains(new Point(i, j))) {
                    dst[i][j] = Color.black;
                } else {
                    dst[i][j] = square[i][j];
                }
            }
        }

        return dst;
    }

    private static List<Point> fillColorPart(int[][] square, int[][] dst, int rgb, Point point) {

        // 根据点获取到的颜色块
        List<Point> allPointList = new ArrayList<>();
        allPointList.add(point);
        outerMatched(allPointList, square, rgb);

        // 计算特征点所在图比例
        // int sumX = allPointList.stream().mapToInt(p -> p.getX()).sum();
        // int sumY = allPointList.stream().mapToInt(p -> p.getY()).sum();
        // System.out.println(new BigDecimal(sumX).divide(new BigDecimal(allPointList.size()), 10, BigDecimal.ROUND_HALF_UP).divide(new BigDecimal(dst.length), 10, BigDecimal.ROUND_HALF_UP));
        // System.out.println(new BigDecimal(sumY).divide(new BigDecimal(allPointList.size()), 10, BigDecimal.ROUND_HALF_UP).divide(new BigDecimal(dst[0].length), 10, BigDecimal.ROUND_HALF_UP));

        allPointList.stream().forEach(colorPoint -> dst[colorPoint.getX()][colorPoint.getY()] = rgb);
        return allPointList;
    }

    /**
     * @description:
     * @author: liyq
     * @createtime: 2023-03-30 17:54:25
     * @param: pointList
     * @param: square
     * @param: rgb
     * @param: x
     * @param: y
     * @return Point>
     */
    private static void outerMatched(List<Point> allPointList, int[][] square, int rgb) {

        int width = square.length;
        int height = square[0].length;

        // 外圈的点
        int count = 1;
        List<Point> outerPointList = outerPoint(allPointList, width, height);
        List<Point> circlePoint;
        while (null != outerPointList && outerPointList.size() > 0) {

            // 如果外圈的点符合rgb，加入到色块所有点中
            circlePoint = outerPointList.stream().filter(outerPoint -> square[outerPoint.getX()][outerPoint.getY()] == rgb).collect(Collectors.toList());

            // System.out.println("第" + count++ + "次循环");
            // System.out.println("外围点数量" + outerPointList.size());
            // System.out.println("匹配中数量" + circlePoint.size());

            if (circlePoint.size() > 0) {
                allPointList.addAll(circlePoint);
                outerPointList = outerPoint(allPointList, width, height);
            } else {
                outerPointList = null;
            }
            // System.out.println();
        }
    }

    /**
     * @description: 获取色块的外围点
     * @author: liyq
     * @createtime: 2023-03-31 15:08:43
     * @param: allPointList
     * @param: width
     * @param: height
     * @return Point>
     */
    private static List<Point> outerPoint(List<Point> allPointList, int width, int height) {

        List<Point> outerPoint = new ArrayList<>();
        for (int i = 0; i < allPointList.size(); i++) {
            Point point = allPointList.get(i);
            // 左边点
            if (point.getX() - 1 >= 0) {
                Point left = new Point(point.getX() - 1, point.getY());
                if (!allPointList.contains(left) && !outerPoint.contains(left)) {
                    outerPoint.add(left);
                }
            }
            // 下边点
            if (point.getY() - 1 >= 0) {
                Point down = new Point(point.getX(), point.getY() - 1);
                if (!allPointList.contains(down) && !outerPoint.contains(down)) {
                    outerPoint.add(down);
                }
            }
            // 右边点
            if (point.getX() + 1 < width) {
                Point right = new Point(point.getX() + 1, point.getY());
                if (!allPointList.contains(right) && !outerPoint.contains(right)) {
                    outerPoint.add(right);
                }
            }
            // 上边点
            if (point.getY() + 1 < height) {
                Point top = new Point(point.getX(), point.getY() + 1);
                if (!allPointList.contains(top) && !outerPoint.contains(top)) {
                    outerPoint.add(top);
                }
            }
        }
        return outerPoint;
    }

    private static boolean matchedRgb(Point point, int[][] square, int rgb) {
        return square[point.getX()][point.getY()] == rgb;
    }
}
