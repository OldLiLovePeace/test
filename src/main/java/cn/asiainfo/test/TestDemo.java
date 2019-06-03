package cn.asiainfo.test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestDemo {
	public static void main(String[] args) {
		
		
		NumberFormat numberFormat = NumberFormat.getInstance();
		// 设置精确到小数点后0位
		numberFormat.setMaximumFractionDigits(0);
		Animal dog = new Dog();
//		System.out.println(dog.age);
		
		Dog dog2 = new Dog();
//		System.out.println(dog2.dogsAge);
		
	        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(new Date());

	        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
	        if (w < 0)
	            w = 0;
	        System.out.println(weekDays[w]);
	        
	        System.out.println("==========================");
	        
	        Date date=new Date();
	        String format2 = null;
	        SimpleDateFormat dateFm = new SimpleDateFormat("EEEE");
	        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");	
	        try {
	        	format2 = dateFm.format(format.parse("2017-12-16"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        System.out.println(format2);
	        System.out.println((int)(13000 * Math.random()));
	        
	       
	}
}
