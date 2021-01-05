import java.io.*;
import java.util.StringTokenizer;

public class Main {
	private static int N;	// 인원 수 (4 <= N <= 20)
	private static int[][] arr;	// 팀의 능력치 표
	private static boolean[] visit;	// index인 사람을 어느 팀으로 구성할지?
	// visit[index] = index는 true : 스타트 팀, false : 링크 팀, 또는 아직 팀이 정해지지 않은 상태
	private static int min = 198;	// 능력치 최솟값 (1 <= S(ij) < 100)
	
	// 백트래킹 함수
	public static void dfs(int index, int depth) {
		// 팀을 다 구성했으면 스타트 팀과 링크 팀의 능력치 최솟값 찾기
		if (depth == N / 2) {	// N / 2명이 true면(스타트 팀), 나머지 N / 2는 자동으로 false(링크 팀) 
			findMin();			// 능력치 최솟값 구하기
			return;
		}
		
		// 팀 구성하기
		for (int i = index; i < N; i++) {
			if (!visit[i]) {		// i의 팀이 정해지지 않은 상태(false)면
				visit[i] = true;	// i를 스타트 팀으로 넣기
				dfs(i + 1, depth + 1);	// 다음 팀원 구하기
				visit[i] = false;	// i를 다시 팀이 정해지지 않은 상태로 변경
			}
		}
	}	// end of dfs(int index, int depth)
	
	// 스타트 팀과 링크 팀의 능력치를 구하고, 그 최소 차이를 구하는 메소드
	static void findMin() {
		int startTeam = 0;	// 스타트 팀
		int linkTeam = 0;	// 링크 팀
		
		// 스타트 팀과 링크 팀의 능력치 구하기
		for (int i = 0; i < N - 1; i ++) {
			for (int j = i + 1; j < N; j++) {
				// true는 스타트 팀
				if (visit[i] && visit[j]) {
					startTeam += arr[i][j];
					startTeam += arr[j][i];
				}
				// false는 링크 팀
				else if (!visit[i] && !visit[j]) {
					linkTeam += arr[i][j];
					linkTeam += arr[j][i];
				}
			}
		}
		
		// 최솟값 구하기
		min = Math.min(min, Math.abs(startTeam - linkTeam));
		
		// 0이면 출력하고 바로 종료
		if (min == 0) {
			System.out.println(min);
			System.exit(0);
		}
	}	// end of findMin()
 	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	// 인원 수 N 입력
    	N = Integer.parseInt(br.readLine());
    	
    	arr = new int[N][N];	// 팀의 능력치 표 생성
    	visit = new boolean[N];	// 팀원 생성
    	
    	// 팀의 능력치 표 입력
    	for (int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for (int j = 0; j < N; j++)
    			arr[i][j] = Integer.parseInt(st.nextToken());
    	}
    	
    	// 능력치 차이 최솟값 구하기
    	dfs(0, 0);
    	
    	// 출력
    	System.out.println(min);
    }	// end of main
}
