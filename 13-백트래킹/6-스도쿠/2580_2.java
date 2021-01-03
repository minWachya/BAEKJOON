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
	private static int[][] board;	// 스도쿠 판
	private static boolean[][] row, column, box;	// 행, 열, 3 * 3 박스
	// row[i][j] : i번째 열에 숫자 j기 true = 있음, false = 없음 (0<= i, j <= 8)
	// column[i][j] : i번째 행에 숫자 j기 true = 있음, false = 없음 (0<= i, j <= 8)
	// box[i][j] : i번째 3 * 3박스에 숫자 j기 true = 있음, false = 없음 (0<= i, j <= 8)
	private static Vector<Point> point = new Vector<Point>();	// 빈 칸을 담을 벡터
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	// 백트래킹 함수
	static void dfs(int depth) throws IOException {
		// depth가 빈 칸의 수와 같으면 (빈 칸을 모두 채웠으면)
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
		
		// depth번째 빈 칸 p 가쟈오기
		Point p = point.get(depth);
		int x = p.x;
		int y = p.y;
		// 채워져야하는 숫자 i + 1 찾기
		for (int i = 0; i < 9; i++) {
			// 숫자 i + 1이 아직 채워지지 않았다면
			if (!row[x][i] && !column[y][i] && !box[(x / 3) + (y / 3) * 3][i]) {
				board[x][y] = i + 1;	// 빈 칸에 i + 1 채우기
				row[x][i] = column[y][i] = box[(x / 3) + (y / 3) * 3][i] = true;	// 숫자 채웠다고 기록
				dfs(depth + 1);		// 다음 빈 칸 채우기
				board[x][y] = 0;	// 위에서 빈 칸을 채우지 못했으면 다시 빈 칸으로 만들기
				row[x][i] = column[y][i] = box[(x / 3) + (y / 3) * 3][i] = false;	// 숫자 안 채웠다고 기록
			}
		}
	}
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	board = new int[9][9];		// 스도쿠 판
    	row = new boolean[9][9];	// 열
    	column = new boolean[9][9];	// 행
    	box = new boolean[9][9];	// 3 * 3 박스
    	
    	// 입력
    	for (int i = 0; i < 9; i++) {
    		st = new StringTokenizer(br.readLine());
    		for (int j = 0; j < 9; j++) {  
    			int num = Integer.parseInt(st.nextToken());
    			board[i][j] = num;
    			
    			if (num == 0) {	// 빈 칸이면
    				point.add(new Point(i, j));	// 빈 칸의 좌표 저장
    			}
    			else {	// 빈 칸이 아니면
    				row[i][num - 1] = true;
    				column[j][num - 1] = true;
    				box[(i / 3) + (j / 3) * 3][num - 1] = true;
    			}
    		}
    	}
    	br.close();
    	
    	// 빈칸 채우기
    	dfs(0);
    }
}
