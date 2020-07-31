package cn.limy.test.extend;


	//基类
	class A{
	    D d=new D("A");
	    static{
	        System.out.println("load A");
	    }
	    public A(){
	        System.out.println("Create A");
	    }
	}
	//B是A的子类
	class B extends A{
	    //字段，用于查看字段的初始化时间
	    D d=new D("B");
	    static{
	        System.out.println("load B");
	    }
	    public B(){
	        System.out.println("Create B");
	    }
	}
	class C extends B{
	    D d=new D("C");
	    static{
	        System.out.println("load C");
	    }
	    public C(){
	        System.out.println("Create C");
	    }
	}
	class D{
	    static{
	        System.out.println("load D");
	    }
	    D(String str){
	        System.out.println("D在类"+str+"中初始化");
	    }
	}
	public class TestExtZ{
	    public static void main(String[] args) {
	        new C();//实例化了对象C 
	    }
	}

