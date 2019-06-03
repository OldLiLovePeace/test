package cn.asiainfo.test.sorttest;

import java.util.Arrays;

public class InsertionSort {
	public void insertionSort(int array[]) {
        int i, j, t = 0;
        for (i = 1; i < array.length; i++) {
        	System.out.println("i=" + i + "的时候");
            t = array[i];
            for (j = i - 1; j >= 0 && t < array[j]; j--) {
            	array[j + 1] = array[j];
            	System.out.println("------------------------ " + Arrays.toString(array));
            }
            array[j + 1] = t;
            
            System.out.println("-----" + Arrays.toString(array));
        }
    }	
}
