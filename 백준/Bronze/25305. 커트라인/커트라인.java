import java.util.Scanner;

//N명의 학생들이 응시했다.
//이들 중 점수가 가장 높은 k 명은 상을 받을 것이다. 이 때, 상을 받는 커트라인이 몇 점인지 구하라.
//커트라인이란 상을 받는 사람들 중 점수가 가장 가장 낮은 사람의 점수를 말한다.

public class Main {
	
	static void bubbleSort(int[] score) {
		int len = score.length;
		
		for(int i = 0; i < len; i++) {
			for(int j = 0; j + 1 < len; j++) {
				if (score[j] > score[j+1]) {
					int tmp = score[j];
					score[j] = score[j+1];
					score[j+1] = tmp;
				}
			}
		}
	}
	
	public static void main(String[] args)  {
		Scanner scan = new Scanner(System.in);
		//[입력]
		int n = scan.nextInt(); // 응시자 수 n
		int k = scan.nextInt(); // 상을 받는 사람 수 2
		int[] score = new int[n];	
		for (int i = 0; i < n; i++) {
			score[i] = scan.nextInt();
		}
		//정렬
		bubbleSort(score);
		//[출력]
		System.out.println(score[score.length - k]);
	}
}