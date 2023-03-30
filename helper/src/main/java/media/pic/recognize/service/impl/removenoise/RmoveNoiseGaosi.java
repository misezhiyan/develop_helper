package media.pic.recognize.service.impl.removenoise;

import media.pic.recognize.service.Convolution;
import media.pic.recognize.service.RemoveNoise;
import media.pic.recognize.service.impl.convolution.ConvolutionBlock;
import media.pic.recognize.service.impl.convolution.convowindow.GaosiConvoWindow;
import media.pic.recognize.service.impl.convolution.entity.ConvoWindowEntity;

/**
 * @description: 高斯模糊去噪
 * @author: liyq
 * @createtime: 2023-03-28 19:06
 */
public class RmoveNoiseGaosi implements RemoveNoise {

    @Override
    public int[][] removeNoise(int[][] square) {

        GaosiConvoWindow gaosiConvoWindow = new GaosiConvoWindow();

        Convolution convolution = new ConvolutionBlock();

        // 高斯模糊矩阵
        ConvoWindowEntity convoWindow = gaosiConvoWindow.convoWindow(1);

        return convolution.convolution(square, convoWindow);
    }

}
