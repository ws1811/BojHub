import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		/******* 입력 시작 *******/
        int N = Integer.parseInt(br.readLine());
        int []inputArr = new int[N];
        List<Integer> list = new ArrayList<>();
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) 
        {
            inputArr[i] = Integer.parseInt(st.nextToken());
        }
        /******* 입력 끝 *******/
        // 키가 큰 순서대로
        for(int i = N - 1; i >= 0; i--)
        {
        	//		 index element
        	list.add(inputArr[i], i + 1);
        }
        /******** 출력 *********/
        for(int h : list)
        {
        	System.out.print(h + " ");
        }
    }
	
	
}
