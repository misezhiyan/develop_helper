package basic;

public class 进制转换 {

	public static void main(String[] args) throws Exception {
		int a = 123;
		// 2进制
		int a_2 = 0123;
		// 16进制
		int a_16 = 0x123;
		System.out.println(a);
		System.out.println(a_2);
		System.out.println(a_16);
		// 进制转换();
	}

	public static void 进制转换() {

		int a = 10;

		// 十进制 -> 二进制
		String str = Integer.toBinaryString(a);
		while (str.length() < 32) {
			str = 0 + str;
		}
		System.out.println("10 -> 2：" + str);

		// 十进制 -> 八进制
		str = Integer.toOctalString(a);
		System.out.println("10 -> 8：" + str);

		// 十进制 -> 十六进制
		str = Integer.toHexString(a);
		System.out.println("10 -> 16：" + str);

		// 十进制 -> 特定进制
		int random = (int) (Math.random() * 10);
		str = Integer.toString(a, random);
		System.out.println("10 -> " + random + "：" + str);

		// 二进制 -> 十进制
		str = "1010"; // 补0
		a = Integer.parseInt(str, 2);
		System.out.println("2 -> 10：" + a);

		// 八进制 -> 十进制
		str = "12";
		str = "4";
		a = Integer.parseInt(str, 8); // str转为int后的值必须大于8
		System.out.println("8 -> 10：" + a);

		// 十六进制 -> 十进制
		str = "a";
		a = Integer.parseInt(str, 16);
		System.out.println("16 -> 10：" + a);
	}

}
