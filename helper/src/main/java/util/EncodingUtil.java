package util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class EncodingUtil {

	/**
	 * @description: 获取文件编码
	 * @author: liyq
	 * @createtime: 2023-04-03 16:34:41
	 * @param: file_real_path
	 * @return String
	 */
	public static String getFileEncodingType(String fileFullPath) throws IOException {
		
		BufferedInputStream bin = new BufferedInputStream(new FileInputStream(fileFullPath));
		int p = (bin.read() << 8) + bin.read();  
		String code = null;  
		
		bin.close();
		
		switch (p) {  
		    case 0xefbb:  
		        code = "UTF-8";  
		    break;  
		case 0xfffe:  
		    code = "Unicode";  
		    break;  
		case 0xfeff:  
		    code = "UTF-16BE";  
		    break;  
		default:  
		    code = "GBK";  
		}  
		  
		return code;  
	}
}
