import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int[] W;	// weight, W[i] = w; : i번째 물건의 무게는 w
	static int[] V;	// value, V[i] = v; : i번째 물건의 가치는 v
	static Integer[][] dp;	// dp[i][w] = v; : 1번째부터 i번째 물건 중 무게가 w 이하를 만족하는 최대 가치는 v
	// ex) (무게, 가치) = 1 : (6, 13), 2 : (4, 8), 3 : (3, 6), 4 : (5, 12) 일 때,
	// dp[3][5] = 1번째부터 3번째 물건 중 무게가 5 이하를 만족하는 최대 가치 = 2 : (4, 8) = 8
	// dp[4][5] = 1번째부터 4번째 물건 중 무게가 5이하를 만족하는 최대 가치 = 4 : (5, 12) = 12
	
	// 1번째부터 n번째 물건 중 무게가 weight 이하를 만족하는 최대 가치를 반환
	static int find(int n, int weight) {
		// 0번째 물건은 없음 
		if (n < 1) return 0;
		
		if (dp[n][weight] == null) {
			if (W[n] <= weight)	// n번째 물건을 담을 수 있으면(n번째 물건의 무게가 최대 무게보다 낮은 경우)
				// 현재 물건을 담지 않은 최대 가치 vs 현재 물건을 담은 최대 가치 비교(무게는 둘 다 weight 이하)
				dp[n][weight] = Math.max(find(n - 1, weight),
						find(n - 1, weight - W[n]) + V[n]);
			else	// n번째 물건을 담을 수 없으면
				dp[n][weight] = find(n - 1, weight);	// 현재 물건을 담지 않은 최대 가치 저장
		}
		return dp[n][weight];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		// 물품의 수 N, 최대 무게 K 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		W = new int[N + 1];	// 무게
		V = new int[N + 1];	// 가치
		dp = new Integer[N + 1][K + 1];
		
		// 물건 N개의 무게 W 입력
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
		
		// 출력
		System.out.println(find(N, K));
	}
 
}
