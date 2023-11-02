import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	static Stack<Integer> stack = new Stack<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		while (n > 0)
		{
			exeCommand(br.readLine());
			n--;
		}
		br.close();
		System.out.println(sb);

	}
	
	static void exeCommand(String command) {
		char c = command.charAt(0);
		
		switch(c) {
		case '1': 
			stack.push(Integer.parseInt(command.substring(2)));
			return;
		case '2': 
			sb.append(stack.isEmpty()? -1 : stack.pop()).append('\n');
			return;
		case '3': 
			sb.append(stack.size()).append('\n');
			return;
		case '4': 
			sb.append(stack.isEmpty()? 1 : 0).append('\n');
			return;
		case '5': 
			sb.append(stack.isEmpty()? -1 : stack.peek()).append('\n');
			return;
		default : return;
		}
	}
}

