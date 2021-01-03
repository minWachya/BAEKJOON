import java.io.*;
import java.util.*;

// 체스판의 빈 칸을 담을 좌표
class Point {
	int x;
	int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	private static int[][] board = new int[9][9];	// 스도쿠 판
	private static Vector<Point> point = new Vector<Point>();	// 빈 칸을 담을 벡터
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	// 빈 칸 (x, y) 자리에 n을 넣을 수 있는지?
	static boolean isPossible(int x, int y, int n) {
		// 같은 행, 열에 n과 똑같은 숫자가 있는지?
		for (int i = 0; i < 9; i++) {
			// 같은 숫자가 있으면 탈락
			if (board[x][i] == n | board[i][y] == n) return false;
		}
		
		// 3 * 3 칸 안에 같은 숫자가 있는지?
		int box_x = (x / 3) * 3;
		int box_y = (y / 3) * 3;
		
		for (int i = box_x; i < box_x + 3; i++) {
			for (int j = box_y; j < box_y + 3; j++) {
				// 같은 숫자가 있으면 탈락
				if (board[i][j] == n) return false;
			}
		}
		
		// n이 들어갈 수 있으면 성공
		return true;
	}
	
	// 백트래킹 함수
	static void dfs(int depth) throws IOException {
		// depth 빈 칸의 수와 같으면 (빈 칸을 모두 채웠으면)
		if (depth == point.size()) {
			// 출력
	    	for (int i = 0; i < 9 ; i++) {
	    		for (int j = 0; j < 9; j++) {
	    			bw.write(board[i][j] + " ");
	    		}
	    		bw.newLine();
	    	}
	    	bw.flush();
	    	bw.close();
	    	System.exit(0);
		}
		
		// depth 빈 칸 p 가쟈오기
		Point p = point.get(depth);
		
		// 성공할 때까지 빈 칸에 n을 하나씩 집어넣기
		for (int n = 1; n < 10; n++) {
			// n을 넣을 수 있으면
			if (isPossible(p.x, p.y, n)) {
				board[p.x][p.y] = n;	// 스도쿠 판에 저장해놓고
				dfs(depth + 1);			// 다음 빈칸 채우기
				board[p.x][p.y] = 0;	// 위에서 빈 칸을 채우지 못했으면 다시 빈 칸으로 만들기
			}
		}
	}
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	// 입력
    	for (int i = 0; i < 9; i++) {   
    		st = new StringTokenizer(br.readLine());
    		for (int j = 0; j < 9; j++) {    			
    			board[i][j] = Integer.parseInt(st.nextToken());
    			// 빈 칸이면 벡터에 저장
    			if (board[i][j] == 0) point.add(new Point(i, j));
    		}
    	}
    	br.close();
    	
    	// 빈칸 채우기
    	dfs(0);
    }
}
