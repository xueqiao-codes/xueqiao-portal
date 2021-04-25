package com.longsheng.xueqiao.admin.util;

import java.util.HashMap;

/**
 * Created by ljq on 01/25/2018.
 * */

public class ChineseNumUtil {
	private static String[] chnNumChar = { "零", "一", "二", "三", "四", "五", "六", "七", "八", "九" };
	private static char[] chnNumChinese = { '零', '一', '二', '三', '四', '五', '六', '七', '八', '九' };

	private static String[] chnUnitSection = { "", "万", "亿", "万亿" };

	private static String[] chnUnitChar = { "", "十", "百", "千" };
	private static HashMap intList = new HashMap();

	static {
		for (int i = 0; i < chnNumChar.length; i++) {
			intList.put(chnNumChinese[i], i);
		}

		intList.put('十', 10);
		intList.put('百', 100);
		intList.put('千', 1000);
	}

	public static String numberToChinese(int num) {// 转化一个阿拉伯数字为中文字符串
		if (num == 0) {
			return "零";
		}
		int unitPos = 0;// 节权位标识
		String All = new String();
		String chineseNum = new String();// 中文数字字符串
		boolean needZero = false;// 下一小结是否须要补零
		String strIns = new String();
		while (num > 0) {
			int section = num % 10000;// 取最后面的那一个小节
			if (needZero) {// 推断上一小节千位是否为零。为零就要加上零
				All = chnNumChar[0] + All;
			}
			chineseNum = sectionTOChinese(section, chineseNum);// 处理当前小节的数字,然后用chineseNum记录当前小节数字
			if (section != 0) {// 此处用if else 选择语句来运行加节权位
				strIns = chnUnitSection[unitPos];// 当小节不为0。就加上节权位
				chineseNum = chineseNum + strIns;
			} else {
				strIns = chnUnitSection[0];// 否则不用加
				chineseNum = strIns + chineseNum;
			}
			All = chineseNum + All;
			chineseNum = "";
			needZero = (section < 1000) && (section > 0);
			num = num / 10000;
			unitPos++;
		}
		return All;
	}

	private static String sectionTOChinese(int section, String chineseNum) {
		String setionChinese = new String();// 小节部分用独立函数操作
		int unitPos = 0;// 小节内部的权值计数器
		boolean zero = true;// 小节内部的制零推断。每一个小节内仅仅能出现一个零
		while (section > 0) {
			int v = section % 10;// 取当前最末位的值
			if (v == 0) {
				if (!zero) {
					zero = true;// 须要补零的操作。确保对连续多个零仅仅是输出一个
					chineseNum = chnNumChar[0] + chineseNum;
				}
			} else {
				zero = false;// 有非零的数字。就把制零开关打开
				setionChinese = chnNumChar[v];// 相应中文数字位
				setionChinese = setionChinese + chnUnitChar[unitPos];// 相应中文权位
				chineseNum = setionChinese + chineseNum;
			}
			unitPos++;
			section = section / 10;
		}

		return chineseNum;
	}

}
