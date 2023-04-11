package wincommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @description: cmd执行命令
 * @author: liyq
 * @createtime: 2023-04-08 22:12
 */
public class WinRunner {

    public static void runCmd(String command) throws IOException, InterruptedException {

        System.out.println("执行cmd命令: ");
        System.out.println(command);

        Process process = Runtime.getRuntime().exec("cmd /c " + command);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = bufferedReader.readLine()) != null)
            System.out.println(line);

        process.waitFor();
    }
}
