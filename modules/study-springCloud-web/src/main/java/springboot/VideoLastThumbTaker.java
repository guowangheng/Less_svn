package springboot;

import java.io.*;

/**
 * 得到最后一秒（也是最后一帧）图片
 */

public class VideoLastThumbTaker extends VideoThumbTaker
{
    public VideoLastThumbTaker(String ffmpegApp)
    {
        super(ffmpegApp);
    }

    public static void main(String[] args) {
        VideoLastThumbTaker w = new VideoLastThumbTaker("E:\\软件下载\\ffmpeg-20180803-476fd6b-win64-static\\bin\\ffmpeg.exe");
        try {
            w.getThumb("E:\\test.mp4", "D:\\test.mp4",    1440, 900);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void getThumb(String videoFilename, String thumbFilename, int width,
                         int height) throws IOException, InterruptedException
    {
        VideoInfo videoInfo = new VideoInfo(ffmpegApp);
        videoInfo.getInfo(videoFilename);
        super.getThumb(videoFilename, thumbFilename, width, height,
                videoInfo.getHours(), videoInfo.getMinutes(), 0);
        System.out.println("结束................................");
    }
}
