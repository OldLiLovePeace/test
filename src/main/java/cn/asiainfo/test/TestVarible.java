package cn.asiainfo.test;

	class Varialbe {
		//成员变量
		//int num = 10;
		int num; //0
		
		public void show() {
			//int num2 = 20; //局部变量
			//可能尚未初始化变量num2
			//int num2; //没有默认值
			int num2 = 20;
			System.out.println(num2);
			
			//int num = 100;
			System.out.println(num);
		}
	}


	class VariableDemo {
		public static void main(String[] args) {
			Varialbe v = new Varialbe();
			
			System.out.println(v.num); //访问成员变量
			
			v.show();	
				
		}
	}
