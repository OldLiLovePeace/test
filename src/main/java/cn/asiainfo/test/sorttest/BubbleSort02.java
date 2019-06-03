package cn.asiainfo.test.sorttest;

public class BubbleSort02 {
	
	public void bubbuleSort(int array[]) {
//		int a;
		for(int i=0; i<array.length-1; i++) {
			for(int j=0; j<array.length-i-1; j++) {
				if(array[j] > array[j+1]) {
//					a = array[j];
//					array[j] = array[j+1];
//					array[j+1] = a;
					
					array[j] = array[j]^array[j+1];
					array[j+1] = array[j]^array[j+1];
					array[j] = array[j]^array[j+1];
				}
			}
		}
	}
}
