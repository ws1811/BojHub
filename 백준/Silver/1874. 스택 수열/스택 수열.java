import java.io.*;
import java.util.Stack;
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		int n = Integer.parseInt(br.readLine());
		int start = 0;
		
		while(n > 0)
		{
			int next = Integer.parseInt(br.readLine());
			
			if(next > start)
			{
				for(int i = start + 1; i <= next; i++)
				{
					stack.push(i);
					sb.append("+").append("\n");
				}
				start = next;
			}
			else if (stack.peek() != next)
			{
				System.out.println("NO");
				return;
			}
			stack.pop();
			sb.append("-").append("\n");
			n--;
		}
		
		System.out.print(sb);
	}

}
