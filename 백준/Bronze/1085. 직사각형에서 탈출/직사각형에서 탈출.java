import java.util.Scanner;

public class Main {

	
	static int min(int[] arr)
	{
		int min = arr[0];
		int i = 0;
		while (i < arr.length)
		{
			if(min > arr[i])
				min = arr[i];
			i++;
		}
		return min;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x, y, w, h;
		x = scan.nextInt();
		y = scan.nextInt();
		w = scan.nextInt();
		h = scan.nextInt();
		
		int[] arr = {x, y, w - x, h - y};
		System.out.println(min(arr));
	}

}
