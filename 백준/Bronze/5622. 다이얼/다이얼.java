import java.util.Scanner;


public class Main {
	
    // 상남자특) 하드코딩
	static int getTime(char c) {
		if ('A' <= c && c <= 'C')
			return 3;
		else if ('D' <= c && c <= 'F')
			return 4;
		else if ('G' <= c && c <= 'I')
			return 5;
		else if ('J' <= c && c <= 'L')
			return 6;
		else if ('M' <= c && c <= 'O')
			return 7;
		else if ('P' <= c && c <= 'S')
			return 8;
		else if ('T' <= c && c <= 'V')
			return 9;
		else if('W' <= c && c <= 'Z')
			return 10;
		else
		 return -1;
	}
	
	public static void main(String[] args)  {
		Scanner scan = new Scanner(System.in);
		int sum = 0;
		//[입력]
		// 첫째 줄에 알파벳 대문자로 이루어진 단어가 주어진다.
		// 단어의 길이는 2보다 크거나 같고, 15보다 작거나 같다.
		
		String telStr = scan.nextLine();
		//[출력]
		// 첫째 줄에 다이얼을 걸기 위해서 필요한 최소 시간을 출력한다.
		
		char[] telArray = telStr.toCharArray();
		for(int i = 0; i < telArray.length; i++)
		{
			sum += getTime(telArray[i]);
		}
		System.out.println(sum);
	}
}