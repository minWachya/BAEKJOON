import java.io.*;

public class Main {
	static Integer[] dp;	// ex) dp[N] = m; : N을 1로 만들기 위한 최소 연산 횟수 = m
	
	static int find(int N) {
		if (dp[N] == null) {	// dp[N]이 초기화 되어있지 않으면
			if (N % 6 == 0)		// N이 6으로 나눠지면
				dp[N] = Math.min(Math.min(find(N / 3), find(N / 2)), find(N - 1)) + 1;
			else if (N % 3 == 0)// N이 3으로 나눠지면
				dp[N] = Math.min(find(N / 3), find(N - 1)) + 1;
			else if (N % 2 == 0)// N이 2로 나눠지면
				dp[N] = Math.min(find(N / 2), find(N - 1)) + 1;
			else	// 그렇지 않으면
				dp[N] = find(N - 1) + 1;
		}
		return dp[N];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력
		int N = Integer.parseInt(br.readLine());
		dp = new Integer[N + 1];
		dp[0] = dp[1] = 0;	// 초기화
		
		//출력
		System.out.println(find(N));
	}
 
}
