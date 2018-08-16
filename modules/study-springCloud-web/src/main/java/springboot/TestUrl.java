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

        /*debugger;
            var objShell
            var objShell= new ActiveXObject("WScript.Shell")
            var iReturnCode=objShell.Run("cmd /k start javac",0,true)
            alert(iReturnCode);
            //iReturnCode=objShell.Run("cmd.exe /c copy d:/!*.text mytest",0,true)*/



        bufferedWriter.flush();
        bufferedWriter.close();
        br.close();
        int i = exec.waitFor();
        System.out.print(i);
    }

}
