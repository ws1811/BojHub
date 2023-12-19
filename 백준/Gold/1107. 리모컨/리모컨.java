import java.util.*;

public class Main {
	static final int MAX = 999999;
	

	public static void main(String[] args) throws Exception {
		int N, M;
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		List<Integer> broken; // 고장난 버튼 저장할 리스트
		
		broken = new ArrayList<Integer>();
		for (int i = 0; i < M; i++) { // 고장난 버튼
			int button = scan.nextInt();
			broken.add(button);
		}

		int min = Math.abs(100 - N); // +, - 버튼으로만 움직였을 때
		
		// 완전 탐색
		for (int i = 0; i <= MAX; i++) { 
			int count = 0;
			String str = String.valueOf(i);
			boolean chk = true;
			for (int k = 0; k < str.length(); k++) {
				// 고장난 버튼 때문에 바로 i 못 누르면 스킵
				if (broken.contains(str.charAt(k) - '0')) { 
					chk = false;
					break;
				}
			}
			if (chk == false)
				continue;

			count += str.length();	  //  자릿수만큼 버튼 입력
			count += Math.abs(i - N); //  나머지 -> +/- 눌러서 이동

			// 최소값 갱신
			if (count < min) {
				min = count;
			}
		}

		System.out.println(min);
	}

}
