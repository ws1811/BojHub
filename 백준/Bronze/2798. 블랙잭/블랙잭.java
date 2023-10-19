import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int addCards(int[] comb)
	{
		int sum = 0;
		for (int i=0; i<comb.length;i++)
		{
			sum += comb[i];
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// 입력
		int n = scan.nextInt(); // 카드의 개수
		int m = scan.nextInt(); 
		// 카드의 합은 m 을 넘어선 안되지만
		// m과 최대한 가까워야 한다
		int[] cards = new int[n];
		for(int i=0; i<cards.length; i++)
		{
			cards[i] = scan.nextInt(); //카드들 입력(n개)
		}
		
		int[] comb = new int[3]; // 카드 3장의 저장할 변수
		int max = 0;
		for (int i=0; i < cards.length; i++)
		{
			comb[0] = cards[i];
			for (int j=i+1;j<cards.length;j++) {
				comb[1] = cards[j];
				for (int k=j+1; k<cards.length;k++) {
					comb[2] = cards[k];
					if (addCards(comb) > max && addCards(comb) <= m) {
						max = addCards(comb);
					}
				}
			}
		}
		System.out.println(max);
		
	}

}
