import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int[][] cost;	// 페인트 비용을 입력받을 배열
	// ex) cost[n][i] = 100; = (n + 1)번째 집을 i색으로 칠하는 값이 100이다. (i = 0 : 빨, 1 : 초, 2 : 파)
	static int[][] dp;		// 누적 합계를 저장할 배열
	// ex) dp[3][1] = 200; = 4번째 집을 초록색으로 칠할 때, 1번째 집부터 4번째 집까지 색이 겹치지 않는 최솟값 비용의 누적합이 200이다.
	
	// 최솟값 누적 구하기
	static int find(int N, int color) {
		if (dp[N][color] == 0) {	// n번째 집을 color색으로 칠할 때(1번째 집부터 n번째 집까지 칠할 때의 최솟값 비용의 누적합을 구하지 못했을 때)
			// n번째 집을 빨간 색으로 칠할 때, 1번째 집부터 n번째 집까지의 최솟값 비용의 누적합 =
			if (color == 0) // (n - 1번째 집은 초록색과 파란색이어야함.) 둘 중 최솟값 + n번째 집을 빨간 색으로 칠하는 비용
				dp[N][0] = Math.min(find(N - 1, 1), find(N - 1, 2)) + cost[N][0];
			// n번째 집을 초록 색으로 칠할 때, 1번째 집부터 n번째 집까지의 최솟값 비용의 누적합 =
			else if (color == 1)  // (n - 1번째 집은 빨강색과 파란색이어야함.) 둘 중 최솟값 + n번째 집을 초록 색으로 칠하는 비용
				dp[N][1] = Math.min(find(N - 1, 0), find(N - 1, 2)) + cost[N][1];
			// n번째 집을 파란 색으로 칠할 때, 1번째 집부터 n번째 집까지의 최솟값 비용의 누적합 =
			else	 // (n - 1번째 집은 빨강색과 초록색이어야함.) 둘 중 최솟값 + n번째 집을 파란 색으로 칠하는 비용
				dp[N][2] = Math.min(find(N - 1, 0), find(N - 1, 1)) + cost[N][2];
		}
		// 1번째 집부터 n번째 집을 color색으로 칠할 때까지의 최솟값 비용의 누적합을 모두 구하면 반환
		return dp[N][color];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 집의 수 입력
		int N = Integer.parseInt(br.readLine());
		cost = new int[N][3];	// 페인트 비용을 입력받을 배열 생성
		dp = new int[N][3];		// 누적 합계를 저장할 배열 셍성
		
		// 페인트 비용 입력
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < 3; i++)	// cost 배열에 비용 저장
				cost[n][i] = Integer.parseInt(st.nextToken());
		}
		
		// 첫 번째 집을
		dp[0][0] = cost[0][0];	// 빨간 색으로
		dp[0][1] = cost[0][1];	// 초록 색으로
		dp[0][2] = cost[0][2];	// 파란 새긍로 칠할 때의 비용 저장
		
		int red = find(N - 1, 0);	// 마지막 집을 빨간 색으로 칠할 때의 최솟값 비용의 누적합
		int green = find(N - 1, 1);// 마지막 집을 초록 색으로 칠할 때의 최솟값 비용의 누적합
		int blue = find(N - 1, 2); // 마지막 집을 파란 색으로 칠할 때의 최솟값 비용의 누적합
		
		// 위의 셋 중 최솟값 구해서 출력
		System.out.println(Math.min(Math.min(red, green), blue));
	}
 
}
