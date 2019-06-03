package cn.asiainfo.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 字典序列化
 * @author 李明阳-java-4年半
 *
 */
public class DictionarySerializationDemo {
	public static void main(String[] args) {
		String myarr[][] = { { "aa", "bb", "cc" }, { "dd", "ee", "ff" }, { "gg", "hh", "ii" } };
		String text = store(myarr);
		System.out.println(text);
		String a[][] = load(text);
		System.out.println(Arrays.toString(a));
	}
	
//	加载方法
	private static String[][] load(String text) {
//		二维数组索引集合
		ArrayList<Integer> secendLevelIndexList = new ArrayList<Integer>();
//		一维数组元素集合
		ArrayList<List<String>> frstLevelArrayList = new ArrayList<List<String>>();
		
		char[] charArray = text.toCharArray();
		
		for (int i = 0; i < charArray.length; i++) {
//			遇到等号和分号将索引保存
			if (Character.toString(charArray[i]).equals("=") || Character.toString(charArray[i]).equals(";")) {
				secendLevelIndexList.add(i);
			}
//			遇到/r或者数组最后一个元素时，对二维数组的元素进行提取
			if (Character.toString(charArray[i]).equals("\r") || i == charArray.length - 1) {
				if (i == charArray.length - 1) {
					secendLevelIndexList.add(charArray.length);
				} else {
					secendLevelIndexList.add(i);
				}
				ArrayList<String> secondArrayList = new ArrayList<String>();
//				对二维数组的元素进行提取
				for (int j = 0; j < secendLevelIndexList.size(); j = j + 2) {
					if (secendLevelIndexList.get(j + 1) == charArray.length - 1) {
						secondArrayList.add(text.substring(charArray.length - secendLevelIndexList.get(j) + 1));
					}
//					提取关键：=和；之间的char元素
					secondArrayList.add(text.substring(secendLevelIndexList.get(j) + 1, secendLevelIndexList.get(j + 1)));
				}
				frstLevelArrayList.add(secondArrayList);
//				每次需要清空
				secendLevelIndexList.clear();
			}
		}
		
//		集合转为数组
		String[][] a = new String[frstLevelArrayList.size()][];
		for (int k = 0; k < frstLevelArrayList.size(); k++) {
			List<String> list = frstLevelArrayList.get(k);
			String[] str = new String[list.size()];
			a[k] = list.toArray(str);
		}
		return a;
	}

//	保存方法
	private static String store(String[][] myarr) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < myarr.length; i++) {
			for (int j = 0; j < myarr[i].length; j++) {
				builder.append(j + "=").append(myarr[i][j] + "");
				if (j != myarr[i].length - 1) {
					builder.append(";");
				}
			}
			if (i != myarr.length - 1) {
				builder.append("\r\n");
			}
		}
		return builder.toString();
	}
}
