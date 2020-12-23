import java.io.*;
import java.util.*;

public class Main {
	private static int n;		// 입력받을 N
	private static int[] column;// 퀸이 들어갈 행
	private static int count = 0; // 퀸이 들어가는 경우의 수

	// 백트래킹 함수
	public static void N_Queen(int index) {	// index : 현재 행의 위치
		if (index == n) {	// level이 n이면(column을 다 채웠으면)
			count++;		// 경우의 수 ++
			return;
		}
		
		for (int i = 0; i < n; i++) {
			column[index] = i;	// index 행에 퀸 놓기
			
			// index 위치에 퀸을 놓으면 서로 공격할 수 없는지 체크하기
			if (isPossible(index)) {	// index 자리에 퀸을 놓을 수 있으면
				N_Queen(index + 1);		// 계속해서 다음 행에 퀸 놓기
				}
		}
		return;
	}
	// index 위치에 퀸을 놓으면 서로 공격할 수 없는지 체크하기
	private static boolean isPossible(int index) {
		for (int i = 0; i < index; i++) {
			// 서로 공격할 수 없으려면
			// 1, 일직선 상에 퀸이 있으면 안 됨
			// 2, 대각성 상에 퀸이 있으면 안 됨(맡변 == 높이면 대각선 상에 있는 것)
			if (column[index] == column[i] ||
					Math.abs(index - i) == Math.abs(column[index] - column[i]))
				return false;	// 퀸을 놓으면 안 됨
		}
		return true;	// 퀸을 놓아도 됨
	}
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
        // 입력
        n = Integer.parseInt(br.readLine()); br.close();
        
        // column 배열 생성
        column = new int[n];
        
        // 시작
        N_Queen(0);
        
        // 출력
        System.out.println(count);
    }
}
