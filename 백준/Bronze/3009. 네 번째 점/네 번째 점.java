import java.util.Arrays;
import java.util.Scanner;



public class Main {
	
	static int getCoord(int[] coords)
	{
		int result = 0;;
		
		if (coords[0] == coords[1])
			result = coords[2];
		else if (coords[0]== coords[2])
			result = coords[1];
		else if (coords[1] == coords[2])
			result = coords[0];
		return result;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] xs = new int[3]; // x 좌표 3개
		int[] ys = new int[3]; // y 좌표 3개
		int x, y; //구할 좌표
		
		for(int i=0; i<3; i++)
		{
			xs[i] = scan.nextInt();
			ys[i] = scan.nextInt();
		}
		x = getCoord(xs);
		y = getCoord(ys);
		
		System.out.printf("%d %d\n", x, y);
	}

}
