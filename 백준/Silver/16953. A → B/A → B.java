import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int A;
	static long B;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] arr = br.readLine().split(" ");
		A = Integer.parseInt(arr[0]);
		B = Long.parseLong(arr[1]);
		
		System.out.println(search());
	}
	
	private static int search() {
        Queue<Long> que = new LinkedList<>();
        que.add((long)A);
        int cnt = 0;
        
        while(!que.isEmpty()) {
            int size = que.size(); 
            cnt++;
            
            for(int i = 0; i < size; i++) { 
                long tmp = que.poll();
                
                if(tmp == B) {
                    return cnt;
                }
                
                if(tmp * 2 <= B) {
                    que.add(tmp * 2);
                }
                if(tmp * 10 + 1 <= B) {
                    que.add(tmp * 10 + 1);
                }
            }
        }
        return -1;
    }
}
