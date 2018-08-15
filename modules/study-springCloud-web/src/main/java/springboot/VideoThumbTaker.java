package springboot;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

/**
 * @author reyo
 * FFMPEG homepage http://ffmpeg.org/about.html
 * By Google Get first and last thumb of a video using Java and FFMpeg
 * From http://www.codereye.com/2010/05/get-first-and-last-thumb-of-video-using.html
 */

public class VideoThumbTaker
{
    protected String ffmpegApp;

    public VideoThumbTaker(String ffmpegApp)
    {
        this.ffmpegApp = ffmpegApp;
    }

    @SuppressWarnings("unused")
    /****
     * 获取指定时间内的图片
     * @param videoFilename:视频路径
     * @param thumbFilename:图片保存路径
     * @param width:图片长
     * @param height:图片宽
     * @param hour:指定时
     * @param min:指定分
     * @param sec:指定秒
     * @throws IOException
     * @throws InterruptedException
     */
    public void getThumb(String videoFilename, String thumbFilename, int width,
                         int height, int hour, int min, float sec) throws IOException
    {
        InputStream stderr = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try{
            String command =ffmpegApp + " -noautorotate  -i "+ videoFilename + "   -vcodec h264 -c:a copy  "+ thumbFilename;
        ProcessBuilder processBuilder = new ProcessBuilder(command);

        Process process = processBuilder.start();
        stderr = process.getErrorStream();
        isr = new InputStreamReader(stderr);
        br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null)
                ;
            process.waitFor();

            if(br != null)
                br.close();
            if(isr != null)
                isr.close();
            if(stderr != null)
                stderr.close();
        }catch (Exception e){
        }
    }

    public static void main(String[] args)
    {
        VideoThumbTaker videoThumbTaker = new VideoThumbTaker("E:\\软件下载\\ffmpeg-20180803-476fd6b-win64-static\\bin\\ffmpeg.exe");
        try
        {
            videoThumbTaker.getThumb("E:\\baidu\\BaiduNetdisk\\download\\springcloud教程\\springboot实战项目类\\2017年-传智播客SpringBoot视频教程\\视频\\01-Spring的发展.avi", "D:\\thumbTest.png",    1440, 900, 0, 0, 9);
            System.out.println("over");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
