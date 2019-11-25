/**
 *====================================================
 * 文件名称: StringUtils.java
 * 修订记录：
 * No    日期				作者(操作:具体内容)
 * 1.    2015年9月26日			chenxy(创建:创建文件)
 *====================================================
 * 类描述：(说明未实现或其它不应生成javadoc的内容)
 */
package com.xiexing.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Random;

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
}
