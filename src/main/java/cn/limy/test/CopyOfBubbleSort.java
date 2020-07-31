package cn.limy.test;

public class CopyOfBubbleSort {
	public static void main(String[] args) {
		int score[] ={67, 69, 75, 100, 87, 89, 90, 99};
		for(int i=0; i<score.length-1; i++){
			for(int j=0; j<score.length-i-1; j++){
				if(score[j]>score[j+1]){
					int temp = score[j];
					score[j] = score[j+1];
					score[j+1] = temp;
				}
			}
		}
		for (int a=0; a<score.length;a++) {
			System.out.println(score[a]);
			
		}
	}
}