package cn.limy.test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
* 类说明：
* @author Administrator
* @date 2017年12月14日 下午9:03:48
*/
public class FileTest {
	public static void main(String[] args) throws IOException {
		
		
		SimpleDateFormat yyyymmddhhmmss = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateString = yyyymmddhhmmss.format(new Date());
		
		File file = new File("f:/testFile");
		if(!file.exists()) {
			file.mkdir();
		}
		file = new File("f:/testFile/myfile_" +dateString +".txt");
		file.createNewFile();
		System.out.println(file.getName());
	}
}
