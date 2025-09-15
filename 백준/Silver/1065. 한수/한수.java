import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 어떤 양의 정수 X의 각 자리가 등차수열을 이룬다면, 그 수를 한수라고 한다. 
// 등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다. N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오. 
public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		for(int i = 1; i <= n; i++) {
			if(isHansoo(i))
				cnt++;
		}
		System.out.println(cnt);
	}
	
	private static boolean isHansoo(int p) {
		if(p < 10)
			return true;
		
		int first = p / 100;
		int second = (p % 100) / 10;
		int third = p % 10;
		
		if(first == 0) {
			return true;
		}
		else {
			if(first - second == second - third)
				return true;
		}
		return false;
	}
}
