package cn.asiainfo.test;

public class JinzitaTest {
	public static void main(String[] args) {
		for (int i = 1; i < 8; i++) { // 控制行数
			for (int j = 0; j < 8 - i; j++) { // 每行要打印的空格数
				System.out.print(" ");
			}
			for (int k = 0; k < 2 * i - 1; k++) { // 每行要打印的符号的个数（相对于前一行多两个）
				System.out.print("*");
			}
			System.out.print("\n"); // 换行打印
		}

	}

}
