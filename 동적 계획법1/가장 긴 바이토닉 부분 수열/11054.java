import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int N;	// 수열 A의 크기
	static int[] A;	// 수열 A
	static int[] dp1;	// 조건 1 : S(1) < S(2) < ... < S(k)를 만족하는 수열의 길이
	static int[] dp2;	// 조건 2 : S(k) > S(k-1) > ... > S(1)을 만족하는 수열의 길이
	
	// 최장 증가 부분 수열(조건 1 검사)
	static int LTS(int n) {
		if (dp1[n] == 0) {	// 아직 초기화가 되어있지 않으면...
			dp1[n] = 1;		// 자기 자신의 원소(=1개)로 초기화
			
			// 0 ~ N-1끼지의 요소를 N과 비교하며 최대 요소 갯수 찾기 
			for (int i = n - 1; i >= 0; i--)
				if (A[i] < A[n])	// 조건 1을 만족하면
					dp1[n] = Math.max(dp1[n], LTS(i) + 1); // dp1[N]와 dp1[i]+1의 값 중 최댓값으로 갱신
		}
		return dp1[n];
	}
	
	// 최장 감소 부분 수열(조건 2 검사)
	static int LDS(int n) {
		if (dp2[n] == 0) {	// 아직 초기화가 되어있지 않으면...
			dp2[n] = 1;		// 자기 자신의 원소(=1개)로 초기화
			
			// N+1 ~ N-1끼지의 요소를 N과 비교하며 최대 요소 갯수 찾기 
			for (int i = n + 1; i < N; i++)
				if (A[n] > A[i])	// 조건 2를 만족하면
					dp2[n] = Math.max(dp2[n], LDS(i) + 1); // dp2[N]와 dp2[i]+1의 값 중 최댓값으로 갱신
		}
		return dp2[n];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		// 수열 A의 크기 입력
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		dp1 = new int[N];
		dp2 = new int[N];
		
		// 수열 A의 요소 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());
		
		// dp[0] ~ dp[N - 1] 채우기
		for (int i = 0; i < N; i++) {
			LTS(i);
			LDS(i);
		}
		
		// 최댓값 찾기
		int max = dp1[0] + dp2[0];
		for (int i = 1; i < N; i++)
			if (max < dp1[i] + dp2[i]) max = dp1[i] + dp2[i];
		
		// 출력
		System.out.println(max - 1);	// 자기 자신의 요소 1개는 중복이라 1 빼주기
	}
 
}
