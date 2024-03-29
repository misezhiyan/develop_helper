package basic;

public class ByteUtil {

	/*
	 * 16进制字符串转字符串
	 */
	public static String hex2String(String hex) throws Exception {
		String r = bytes2String(hexString2Bytes(hex));
		return r;
	}

	/*
	 * 字节数组转字符串
	 */
	public static String bytes2String(byte[] b) throws Exception {
		String r = new String(b, "UTF-8");
		return r;
	}

	/*
	 * 16进制字符串转字节数组
	 */
	public static byte[] hexString2Bytes(String hex) {

		if ((hex == null) || (hex.equals(""))) {
			return null;
		} else if (hex.length() % 2 != 0) {
			return null;
		} else {
			hex = hex.toUpperCase();
			int len = hex.length() / 2;
			byte[] b = new byte[len];
			char[] hc = hex.toCharArray();
			for (int i = 0; i < len; i++) {
				int p = 2 * i;
				b[i] = (byte) (charToByte(hc[p]) << 4 | charToByte(hc[p + 1]));
			}
			return b;
		}

	}

	/*
	 * 字符转换为字节
	 */
	private static byte charToByte(char c) {
		return (byte) "0123456789ABCDEF".indexOf(c);
	}

	/**
	 * @description: unicode 转 字符串
	 * @author: liyq
	 * @createtime: 2023-04-03 15:46:48
	 * @param: unicode
	 * @return String
	 */
	public static String unicodeToChar(String unicode) {
		if (unicode == null || unicode.isEmpty()) {
			return unicode;
		}
		StringBuffer str = new StringBuffer();
		String[] hex = unicode.split("\\\\u");
		for (int index = 1; index < hex.length; index++) {
			int data = Integer.parseInt(hex[index], 16);
			str.append((char) data);
		}
		return str.toString();
	}


	private static String charToUnicode(String str) {
		if (str == null || str.isEmpty()) {
			return str;
		}
		StringBuffer unicode = new StringBuffer();
		for (int index = 0; index < str.length(); index++) {
			char c = str.charAt(index);
			unicode.append("\\u").append(Integer.toHexString(c));
		}
		return unicode.toString();
	}
}
