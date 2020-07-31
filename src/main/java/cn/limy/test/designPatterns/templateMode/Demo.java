package cn.limy.test.designPatterns.templateMode;

public class Demo {
	public static void main(String[] args) {
		SmallCake smallCake = new SmallCake();
		smallCake.setFlag(true);
		smallCake.setFlag(false);
		smallCake.run();
	}
}
