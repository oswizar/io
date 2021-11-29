/**
 *====================================================
 * 文件名称: StringUtils.java
 * 修订记录：
 * No    日期				作者(操作:具体内容)
 * 1.    2015年9月26日			chenxy(创建:创建文件)
 *====================================================
 * 类描述：(说明未实现或其它不应生成javadoc的内容)
 */
package com.oswizar.util;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: StringUtils
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author
 * @date 2015年9月26日 上午9:53:57
 */
public class StringUtils {

	/**
	 * 获取验证码
	 * @return 验证码
	 */
	public static String getIdentifyingCode() {
		int[] array = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Random rand = new Random();
		for (int i = 10; i > 1; i--) {
			int index = rand.nextInt(i);
			int tmp = array[index];
			array[index] = array[i - 1];
			array[i - 1] = tmp;
		}
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < 6; i++) {
			result.append(array[i]);
		}
		return result.toString();
	}

	public static boolean isBlank(String value) {
		return value == null || value.trim().length() == 0;
	}

	public static boolean validateMobile(String mobile) {
		if (isBlank(mobile)) {
			return false;
		}
		if (mobile.length() != 11) {
			return false;
		}
		return true;
	}

	public static String parseMoney(String pattern,BigDecimal bd){
		DecimalFormat df=new DecimalFormat(pattern);
	    return df.format(bd);
	}


	public static BigDecimal getBigDecimalforString(String param){
		BigDecimal val = null;
		if(isBlank(param)){
			val = new BigDecimal(0);
		}else{
			if(param.matches("-?[0-9]+.*[0-9]*")){
				val = new BigDecimal(param);
			}else{
				val = new BigDecimal(0);
			}
		}
		return val;
	}

	/**
	 * Unicode转 汉字字符串
	 *
	 * @param str
	 *            \u6728
	 * @return '木' 26408
	 */
	public static String unicodeToString(String str) {

		Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
		Matcher matcher = pattern.matcher(str);
		char ch;
		while (matcher.find()) {
			// group 6728
			String group = matcher.group(2);
			// ch:'木' 26408
			ch = (char) Integer.parseInt(group, 16);
			// group1 \u6728
			String group1 = matcher.group(1);
			str = str.replace(group1, ch + "");
		}
		return str;
	}

	/**
	 * 获取字符串的unicode编码 汉字“木”的Unicode 码点为Ox6728
	 *
	 * @param s
	 *            木
	 * @return \ufeff\u6728 \ufeff控制字符 用来表示「字节次序标记（Byte Order Mark）」不占用宽度
	 *         在java中一个char是采用unicode存储的 占用2个字节 比如 汉字木 就是 Ox6728
	 *         4bit+4bit+4bit+4bit=2字节
	 */
	public static String stringToUnicode(String s) {
		try {
			StringBuffer out = new StringBuffer("");
			// 直接获取字符串的unicode二进制
			byte[] bytes = s.getBytes("unicode");
			// 然后将其byte转换成对应的16进制表示即可
			for (int i = 0; i < bytes.length - 1; i += 2) {
				out.append("\\u");
				String str = Integer.toHexString(bytes[i + 1] & 0xff);
				for (int j = str.length(); j < 2; j++) {
					out.append("0");
				}
				String str1 = Integer.toHexString(bytes[i] & 0xff);
				out.append(str1);
				out.append(str);
			}
			return out.toString();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}
}
