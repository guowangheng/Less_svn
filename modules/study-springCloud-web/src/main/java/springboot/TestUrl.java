package springboot;

import java.io.*;


public class TestUrl {

    public static void main(String[] args) throws Exception {
        Runtime runtime = Runtime.getRuntime();
        String [] cmd={"cmd","/C","git log --author=guo.wangheng --since='2018/8/10' --before='2018/8/14' --name-status"};
        Process exec = runtime.exec(cmd,null,new File("D:\\HaiKangMes\\HikvisionMes"));
        InputStream stderr = exec.getInputStream();
        InputStreamReader isr = new InputStreamReader(stderr);
        BufferedReader br = new BufferedReader(isr);
        String line = null;
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("E:\\gitLog.txt")));
        while ( (line = br.readLine()) != null) {
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        br.close();
        int i = exec.waitFor();
        System.out.print(i);
    }

}
