//import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	// 크로아티아 알파벳
	// c= , c-, dz=, d-, lj, nj, s=, z=
	static int isCroatic(char[] strArr, int i) {
		// c=, c-
		if(strArr[i] == 'c' && i <= strArr.length - 2) 
		{
			if(strArr[i+1] == '=' || strArr[i+1] == '-')
			{
				return 1;
			}
		}
		// dz=
		if(strArr[i] == 'd' && i <= strArr.length - 3) 
		{	//dz=
			if((strArr[i+1] == 'z' && strArr[i+2] =='='))
			{
				return 2;
			}
		}
		// d-
		if (strArr[i] == 'd' && i <= strArr.length - 2) 
		{
			if (strArr[i+1] == '-') {
				return 1;
			}
		}
		// lj
		if(strArr[i] == 'l' && i <= strArr.length - 2)
		{
			if(strArr[i+1] == 'j')
				return 1;
		}
		// nj
		if(strArr[i] == 'n'&& i <= strArr.length - 2)
		{
			if(strArr[i+1] == 'j')
				return 1;
		}
		
		// s=, z=
		if(strArr[i] == 's' && i <= strArr.length - 2)
		{
			if(strArr[i+1] == '=')
				return 1;
		}
		// z=
		if(strArr[i] == 'z' && i <= strArr.length - 2)
		{
			if(strArr[i+1] == '=')
				return 1;
		}
		
		// 크로아틱 알파벳 아닐 경우
		return -1;
	}
	
	public static void main(String[] args)  {
		Scanner scan = new Scanner(System.in);
		// [입력]
		// 첫째 줄에 최대 100글자의 단어가 주어진다. 알파벳 소문자와 '-', '='로만 이루어져 있다.
		// 단어는 크로아티아 알파벳으로 이루어져 있다. 문제 설명의 표에 나와있는 알파벳은 변경된 형태로 입력된다.
		String str = scan.nextLine();
//		System.out.println("** lenght = " + str.length());
		char[] strArr = str.toCharArray();
		int croAlp = 0; // 크로아티아 알파벳 개수
		// [출력]
		// 입력으로 주어진 단어가 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.
		for(int i = 0; i < str.length(); i++)
		{
//			System.out.println("Checking " + strArr[i] + ".... / now croAlp = " + croAlp);
			if(isCroatic(strArr, i)	== 1) {		
//				System.out.println("## " + strArr[i] + strArr[i+1]+ " is Croatic ! ##");
				croAlp++;
				i++;
			}else if (isCroatic(strArr, i) == 2)
			{
				croAlp++;
				i += 2;
			}else
			{
//				System.out.println("## " + strArr[i] + " is NOT Croatic... ##");
				croAlp++;
			}
		}		
		System.out.println(croAlp);
	}
}