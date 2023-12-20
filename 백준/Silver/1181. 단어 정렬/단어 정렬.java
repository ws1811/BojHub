import java.io.*;
import java.util.*;
public class Main {
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String[] words = new String[N];
		
		for (int i = 0; i < N; i++)
		{
			words[i] = br.readLine();
		}
		
		
		// 중복된 단어 제거
        HashSet<String> set = new HashSet<>(Arrays.asList(words));
        words = set.toArray(new String[0]);

        // 정렬
        Arrays.sort(words, (a, b) -> {
            if (a.length() == b.length()) {
                return a.compareTo(b);
            }
            return Integer.compare(a.length(), b.length());
        });
        
		// 출력
		for (int i = 0; i < words.length; i++)
		{
			System.out.println(words[i]);
		}
	}
	
	// 1. 길이가 짧은 것부터
	// 2. 길이가 같으면 사전 순으로
	static void sort(String[] arr)
	{
		int len = arr.length;
		// 길이순 정렬
		for (int i = 0; i < len; i++)
		{
			for (int j = i; j < len; j++)
			{
				if(arr[i].length() > arr[j].length())
				{
					swap(arr, i, j);
				}
			}
		}
		// 길이가 같으면 사전 순 정렬
		for (int i = 0; i < len; i++)
		{
			for (int j = i; j < len; j++)
			{
				if(arr[i].length() == arr[j].length())
				{
					if(strCmp(arr[i], arr[j]) > 0) // 오름차순 정렬
						swap(arr, i, j);
				}
			}
		}
	}
	
	// 길이가 같은 경우 -> 알파벳 순으로 비교
	static int strCmp(String str1, String str2)
	{
		int cmp = 0;
		for (int i = 0; i < str1.length(); i++)
		{
			if(str1.charAt(i) > str2.charAt(i))
			{
				return str1.charAt(i) - str2.charAt(i);
			}
		}
		return 0;
	}
	// 문자열 교환
	static void swap(String[] arr, int i, int j)
	{
		String tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
