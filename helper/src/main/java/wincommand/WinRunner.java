package wincommand;

import util.FileUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @description: TODO
 * @author: liyq
 * @createtime: 2023-04-08 22:12
 */
public class WinRunner {

    public static void runCmd(String command) throws IOException, InterruptedException {
        Process process = Runtime.getRuntime().exec("cmd /c " + command);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = bufferedReader.readLine()) != null)
            System.out.println(line);

        process.waitFor();
    }
}
