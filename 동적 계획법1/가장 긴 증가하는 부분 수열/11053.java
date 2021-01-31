import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int[] A;	// 입력받을 스열 A
	static int[] dp;// 메모제이션 할 배열 dp
	// ex) dp[i] = m;	: 0~i 요소 중 증가 수열 요소는 m개(최장 증가 부분 수열의 길이가 m)
	
	// 최장 증가 부분 수열
	static int LTS(int N) {
		if (dp[N] == 0) {	// 아직 초기화가 되어있지 않으면...
			dp[N] = 1;		// 자기 자신의 원소(=1개)로 초기화
			
			// 0 ~ N-1끼지의 요소를 N과 비교하며 최대 요소 갯수 찾기 
			for (int i = N - 1; i >= 0; i--)
				if (A[i] < A[N])	// A[i]의 값이 A[N]보다 값이 작으면
					dp[N] = Math.max(dp[N], LTS(i) + 1); // dp[N]와 dp[i]+1의 값 중 최댓값으로 갱신
		}
		return dp[N];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		// 수열 A의 크기 입력
		int N = Integer.parseInt(br.readLine());
		A = new int[N];
		dp = new int[N];
		
		// 수열 A의 요소 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());
		
		// dp[0] ~ dp[N - 1] 채우기
		for (int i = 0; i < N; i++)
			LTS(i);
		
		// 최댓값 찾기
		int max = dp[0];
		for (int i = 1; i < N; i++)
			if (max < dp[i]) max = dp[i];
		
        // 출력
		System.out.println(max);
	}
 
}
