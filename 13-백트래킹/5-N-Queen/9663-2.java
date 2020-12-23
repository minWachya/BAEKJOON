import java.io.*;
import java.util.*;

public class Main {
	private static int n;		// 입력받을 N
	private static boolean[] col;// 퀸이 들어갈 행 (column)
	private static boolean[] dig1;// 퀸이 이동일 수 있는 대각선 1 (/) (diagonal)
	private static boolean[] dig2;// 퀸이 이동할 수 있는 대각선 2 (\)
	// col, dig1, dig2가 true : 해단 위치에 퀸을 둘 수 없음, false : 해당 위치에 퀸을 둘 수 있음
	private static int count = 0; // 퀸이 들어가는 경우의 수

	// 백트래킹 함수
	public static void N_Queen(int index) {	// index : 현재 행의 위치
		if (index == n) {	// level이 n이면(column을 다 채웠으면, 모든 행에 퀸이 하나씩 있으면)
			count++;		// 경우의 수 ++
			return;
		}
		
		for (int i = 0; i < n; i++) {
			// index 위치에 퀸을 놓을 때, 서로 공격할 수 없는지 체크하기
			// 행, 대각선1, 대각선2 자리가 false인지? (그 자리에 퀸을 둘 수 있는지?)
			// 대각선 1 (/) : 행 + 열, 대각선 2 (\) : n + 행 - 열
			if (!col[i] && !dig1[index + i] && !dig2[n - 1 + index - i]) {	// index 자리에 퀸을 놓을 수 있으면
				// 퀸을 놓은 해당 열과 퀸이 이동할 수 있는 대각선 자리를  true로 바꾸기
				col[i] = dig1[index + i] = dig2[n - 1 + index - i] = true;
				N_Queen(index + 1);		// 계속해서 다음 행에 퀸 놓기
				// 퀸을 놓은 해당 열과 퀸이 이동할 수 있는 대각선 자리를  false로 바꾸기(초기화)
				col[i] = dig1[index + i] = dig2[n - 1 + index - i] = false;
				}
		}
		return;
	}
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
        // 입력
        n = Integer.parseInt(br.readLine()); br.close();
        
        // 배열 생성
        col = new boolean[n];		// 열
        dig1 = new boolean[n * 2];	// 대각선 1(/)
        dig2 = new boolean[n * 2];	// 대각선 2(\)
        
        // 시작
        N_Queen(0);
        
        // 출력
        System.out.println(count);
    }
}
