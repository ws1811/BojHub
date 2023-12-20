import java.io.*;
import java.util.*;
public class Main {
	static char[][] board;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		board = new char[N][M]; // 보드
		// 보드 입력
		for(int i = 0; i < N; i++)
		{
			String line = br.readLine();
			for (int j = 0; j < M; j++)
			{
				board[i][j] = line.charAt(j);
			}
		}
		
		// 8 x 8 크기로 잘라내기(완탐)
		int min = 8 * 8;
		int count = 0;
		for(int i = 0; i + 8 <= N; i++)
		{
			for (int j = 0; j + 8 <= M; j++)
			{
				char[][] chessBoard = getChessBoard(i, j);
				count = startByWhite(chessBoard);
				if(count < min) min = count;
				count = startByBlack(chessBoard);
				if(count < min) min = count;
			}
		}
		System.out.println(min);
	}
	
	// 보드에서 8 x 8 크기 체스판을 잘라내는 메소드
	static char[][] getChessBoard(int row, int col)
	{
		char[][] chessBoard = new char[8][8];
		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				chessBoard[i][j] = board[row + i][col + j];
			}
		}
		return chessBoard;
	}
	
	// 다시 칠해야하는 칸의 수를 리턴하는 메소드들 -> 한 줄에서 체스판으로 수정해야
	// 흰색(W) 로 시작하는 경우
	// (짝수줄) W B W B W B W B
	// (홀수줄) B W B W B W B W
	static int startByWhite(char[][] arr) 
	{
		int count = 0;
		for(int i = 0; i < arr.length; i++)
		{
			for (int j = 0; j < arr.length; j++)
			{
				if(i % 2 == 0) // 짝수줄
				{
					// 짝수 열
					if (j % 2 == 0 && arr[i][j] == 'B') count++;
					// 홀수 열
					if (j % 2 == 1 && arr[i][j] == 'W') count++;
				}
				else // 홀수줄
				{
					// 짝수 열
					if (j % 2 == 0 && arr[i][j] == 'W') count++;
					// 홀수 열
					if (j % 2 == 1 && arr[i][j] == 'B') count++;
				}
			}
		}
		return count;
	}
	
	// 검은색(B) 로 시작하는 경우
	// (짝수행) B W B W B W B W
	// (홀수행) W B W B W B W B
	static int startByBlack(char[][] arr)
	{
		int count = 0;
		for(int i = 0; i < arr.length; i++)
		{
			for (int j = 0; j < arr.length; j++)
			{
				if(i % 2 == 0) // 짝수줄
				{
					// 짝수 열
					if (j % 2 == 0 && arr[i][j] == 'W') count++;
					// 홀수 열
					if (j % 2 == 1 && arr[i][j] == 'B') count++;
				}
				else // 홀수줄
				{
					// 짝수 열
					if (j % 2 == 0 && arr[i][j] == 'B') count++;
					// 홀수 열
					if (j % 2 == 1 && arr[i][j] == 'W') count++;
				}
			}
		}
		return count;
	}
	
}
