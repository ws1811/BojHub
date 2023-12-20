import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		
		while(!(line = br.readLine()).equals("0"))
		{
			if (isPalindrome(line) == true)
				System.out.println("yes");
			else
				System.out.println("no");
		}
	}
	
	static boolean isPalindrome(String str)
	{
		int len = str.length();
		for (int i = 0; i < len/2; i++)
		{
			if(str.charAt(i) != str.charAt(len - 1 - i)) return false;
		}
		return true;
	}
}
