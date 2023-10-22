import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);	
		
		// 입력
		// 첫째 줄에 입력의 크기 n (1 ~ 500000) 이 주어진다
		int n = scan.nextInt();
		
		/* MenOfPassion 알고리즘은 다음과 같다.
		 
		 MenOfPassion(A[], n) {
		    sum <- 0;
		    for i <- 1 to n
		        sum <- sum + A[i]; # 코드1
		    return sum;
		} 
		
		*/
		
		// 첫째 줄에 코드 1의 수행 횟수 출럭
		// 둘째 줄에 코드1의 수행 횟수를 다항식으로 나타내었을 때, 최고차항의 차수를 출력한다. 
		// 단, 다항식으로 나타낼 수 없거나 최고차항의 차수가 3보다 크면 4를 출력한다.
		
		
		// [출력] 
		// 1. 첫째 줄 -> 입력 n 이 들어면 코드 1은 n 번 수행된다
		System.out.println(n);
		// 2. 둘쨰 줄  -> 코드 1의 수행횟수 : nx (최고차항 : 1차)
		System.out.println(1);
		
	}

}
