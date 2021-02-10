import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int[] num;	// N개의 정수 수열을 저장할 배열
	static Integer[] dp;// dp[n] = m; n번째 정수까지의 최대 연속 합은 m
	
	static int find(int N) {
		if (dp[N] == null)	// 아직 최대 연속 합을 구하지 못했으면
			// N번째 정수까지의 최대 연속 합 = 이전 최대 연속 합 + 현재 정수 값과 현재 정수 값 중 최댓값
			dp[N] = Math.max(find(N - 1) + num[N], num[N]);
		
		return dp[N];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		// 정수 N 입력
		int N = Integer.parseInt(br.readLine());
		num = new int[N];
		dp = new Integer[N];
		
		// N개의 정수 수열 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			num[i] = Integer.parseInt(st.nextToken());
		
		// 초기화
		dp[0] = num[0];
		
		// 최대 연속 합 찾기
		find(N - 1);
		
		// 최대 연속 합 구라기
		int max = dp[0];
		for (int i = 1; i < N; i++)
			if (max < dp[i]) max = dp[i];
		
		// 출력
		System.out.println(max);
	}
 
}
