package log;

import util.FileUtil;

import java.io.File;

public class Log {

	private String debug = "";
	private String logFilePath = "C:\\Users\\kimmy\\Desktop\\图像识别\\debug.log";

	public void debug(Object log) {
		if (log.getClass() == String.class) {
			debug += (String) log + "\r\n";
			System.out.println(log);
		} else {
			debug += log.toString() + "\r\n";
		}
	}

	public void debugOut() {
		System.out.println(debug);
	}

	public void debugOutFile() {

		File logFile = new File(logFilePath);
		if (!logFile.exists()) {
			logFile.getParentFile().mkdirs();
			try {
				logFile.createNewFile();
			} catch (Exception e) {
				System.out.println("日志文件创建失败");
				e.printStackTrace();
				return;
			}
		}

		try {
			FileUtil.appendToFile(logFilePath, debug);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("日志文件写入失败");
		}
	}

}
