package springboot;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Test {

    public static void main(String[] args) throws Exception{

        File file = new File("E:\\baidu\\BaiduNetdisk\\download\\springcloud教程\\springboot实战项目类\\2017年-传智播客SpringBoot视频教程\\视频\\01-Spring的发展.avi");
        FileInputStream fileInputStream = new FileInputStream(file);

        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\gwh1994\\Desktop\\test.avi");
        int lengthFile = (int) file.length();
        byte[] arr = new byte[lengthFile];
        byte[] arrs;
        while (fileInputStream.read(arr) != -1){
            arrs = new byte[lengthFile];
            int m = 0;
            for (int i = arr.length-1; i>= 0; i--) {
                arrs[m++] = arr[i];
            }
            fileOutputStream.write(arrs,0,arrs.length);
        }
        fileOutputStream.flush();
        fileInputStream.close();
        fileOutputStream.close();
    }
}
