package cn.asiainfo.test.sorttest;

public class SelectSort {
	public void selectSort(int array[]) {
		for(int i=0; i<array.length-1; i++) {
			int index=i;
			for(int j=i+1; j<array.length; j++) {
				if(array[index] > array[j]) {
					index=j;
				}
			}
			
			if(index != i) {
				array[i] = array[i]^array[index];
				array[index] = array[i]^array[index];
				array[i] = array[i]^array[index];
			}
		}
	}
}
