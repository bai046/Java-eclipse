package tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Tools {
	// 时间格式化
	public static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	// 这是一个输入
	public static Scanner scanner = new Scanner(System.in);
	
	/**
	 * 时间的格式化
	 * @param string
	 * @return
	 */
	public static Date getDate(String string){
		try {
			return format.parse(string);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Date();
	}
	
	/**
	 * 将字符串转为整型数，如果输入的字符串不是整型数，则返回参数中的int数
	 * 
	 * @param numStr
	 *            要转换的字符串
	 * @param deInt
	 *            默认的整型数
	 * @return 返回转换的结果
	 */
	public static int getInteger(String numStr, int deInt) {
		int num=0;
		try {
			num=Integer.parseInt(numStr);
		} catch (Exception e) {
			num=deInt;
		}
		return num;
	}

	/**
	 * 输入用户的性别编码，输出用户的性别字符
	 * 
	 * @param sex
	 *            用户的性别的编码
	 * @return 用户的性别的字符
	 */
	public static String getSex(int sex) {
		if (sex == 0) {
			return "女";
		} else if (sex == 1) {
			return "男";
		} else {
			return "不详";
		}
	}

	/**
	 * 将一个数字转为double，如果格式错误，就转为默认的数
	 * 
	 * @param numStr
	 *            要转的数字
	 * @param num
	 *            默认的数字
	 * @return 转换的结果
	 */
	public static double getDouble(String numStr, double num) {
		double num2 = 0;
		try {
			num2 = Double.parseDouble(numStr);
		} catch (NumberFormatException e) {
			System.out.println("你输入的数字的格式错误，已经存为默认的数");
			num2 = num;

		}
		return num2;
	}

}

