import java.io.*;

public class Main {
	static int[] wine;	// 입력받을 포도주의 양
	static Integer[] dp;// dp[N] = m; : 1번째 잔부터 N번째 잔까지의 최댓값이 m
	
	static int find(int N) {
		if (dp[N] == null)	// N번재 잔 까지의 최댓값을 아직 모른다면...
			dp[N] = Math.max(
					// N번째 잔을 포함한 최댓값 루트와
					Math.max(find(N - 2), find(N - 3) + wine[N - 1]) + wine[N],
					// N번째 잔을 포함하지 않른 최댓값 루트를 비교
					find(N - 1));
		
		return dp[N];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		// 포도주 잔의 갯수 입력
		int N = Integer.parseInt(br.readLine());
		wine = new int[N + 1];
		dp = new Integer[N + 1];
		
		// 포도주의 양 입력
		for (int i = 1; i <= N; i++)
			wine[i] = Integer.parseInt(br.readLine());
		
		// 초기화
		dp[0] = 0;		// 0번째 잔은 없음
		dp[1] = wine[1];// 잔이 1개면 그 잔을 다 마시는 게 최대값
		if (N > 1) dp[2] = wine[1] + wine[2];	// 잔이 2개면 두 잔을 모두 마시는 게 최댓값
		
		// 출력
		System.out.println(find(N));
	}
 
}
