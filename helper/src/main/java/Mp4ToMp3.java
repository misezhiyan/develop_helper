import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.FFmpegFrameRecorder;
import org.bytedeco.javacv.Frame;

import java.io.File;

public class Mp4ToMp3 {

    public static void main(String[] args) {
        String sourceFilePath = "C:\\Users\\kimmy\\Desktop\\mp4转mp3\\133f8b911674567319d9d2cf7fb5143a.mp4";

        File file = new File(sourceFilePath);

        FFmpegFrameGrabber frameGrabber1 = new FFmpegFrameGrabber(sourceFilePath);
        Frame frame;
        FFmpegFrameRecorder recorder;
        String fileName = null;

        try {
            frameGrabber1.start();
            fileName = file.getAbsolutePath() + "test.mp3";
            recorder = new FFmpegFrameRecorder(fileName, frameGrabber1.getAudioChannels());
            recorder.setFormat("mp3");
            recorder.setSampleRate(frameGrabber1.getSampleRate());
            recorder.setTimestamp(frameGrabber1.getTimestamp());
            recorder.setAudioQuality(0);
            recorder.start();

            int index = 0;
            while (true) {
                // frameGrabber1.
                frame = frameGrabber1.grab();
                if (frame == null) {
                    System.out.println("结束");
                    break;
                }
                if (frame.samples != null && index > 300) {
                    recorder.recordSamples(frame.sampleRate, frame.audioChannels, frame.samples);
                }
                System.out.println("帧" + index++);
            }
            recorder.stop();
            recorder.release();
            frameGrabber1.stop();
        } catch (FFmpegFrameGrabber.Exception | FFmpegFrameRecorder.Exception e) {
            e.printStackTrace();
        }

    }
}
