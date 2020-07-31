package cn.limy.test.sorttest;

import java.util.Arrays;

public class SortDemo {
	public static void main(String[] args) {
		int array[] = { 3, 1, 7, 6, 2, 8, 4, 5 };
		System.out.println(Arrays.toString(array));
		// new BubbleSort02().bubbuleSort(array);
//		new SelectSort().selectSort(array);
		new InsertionSort().insertionSort(array);
		System.out.println(Arrays.toString(array));
	}
}
