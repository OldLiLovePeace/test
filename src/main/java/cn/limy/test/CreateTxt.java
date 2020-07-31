package cn.limy.test;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;

/**
* 类说明：
* @author Administrator
* @date 2017年12月4日 下午3:38:21
*/
public class CreateTxt {
	public static void main(String[] args) {
		
		System.out.println(new Date().toString());
	        try {
	        	File file = new File("F:\\txttest.txt");
	        	if(!file.exists()) {
	        		file.createNewFile();
	        	}
	            PrintWriter pw = new PrintWriter(new FileWriter(file));
	            pw.println("abc ");
	            pw.println("def ");
	            pw.println("hef ");
	            pw.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
}
