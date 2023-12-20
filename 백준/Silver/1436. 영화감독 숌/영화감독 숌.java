import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		
		
		int count = 0;
		for (int i = 1; count < N; i++)
		{
			if(isDoomNum(i) == true)
			{
				count++;
				if (count == N) 
					System.out.println(i);
			}
		}
	}
	
	
	
	static boolean isDoomNum(int n) {
		// 정수를 char 배열로 바꾸고
		String str = Integer.toString(n);
		char[] charArray = str.toCharArray();
		// 6이 세 개 이상 연속되어있는지
		for(int i = 0 ; i + 2 < charArray.length; i++)
		{
			if(charArray[i] == '6') // 6이 처음 나왔을 때 -> 뒤에 두 개 도 6인지
			{
				if(charArray[i + 1] == '6' && charArray[i + 2] == '6')
					return true;
			}
		}
		return false;
	}
}