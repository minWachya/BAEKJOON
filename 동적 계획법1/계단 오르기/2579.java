import java.io.*;

public class Main {
	static int[] stair;	// 계단의 점수를 입력빋을 배열
	static Integer[] dp;// 계단 점수의 누적 최댓값을 저장할 배열
	
	// 누적 점수 최댓값 구하기
	// (if문에서 dp[N - 3]를 검사하게 되기 때문에 인덱스 에러가 나지 않기 위해 N >= 3을 만족해야 함)
	// (N >= 3이라면, 무한 재귀를 막기 위해 dp[N]에서 N = 0, 1, 2는 초기화가 되어 있어야 함)
	static int find(int N) {
		if (dp[N] == null)	// N번째 계단을 밟을 때의 누적 점수 최댓값이 아직 계산되지 않으면
			dp[N] = Math.max(find(N - 2), find(N - 3) + stair[N - 1]) + stair[N];
		return dp[N];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 계단 수 입력
		int N = Integer.parseInt(br.readLine());
		stair = new int[N];
		dp = new Integer[N];
		
		// 계단 점수 입력
		for (int i = 0; i < N; i++) 
			stair[i] = Integer.parseInt(br.readLine());
		
		// 9번째 줄 : N = 0, 1, 2는 초기화가 되어 있어야 함
		dp[0] = stair[0];	// N = 1이면, 하나의 계단을 밟는 것이 누적 점수 최댓값
    // N = 2라면, 두 개의 계단을 다 밟는 것이 누적 점수 최댓값
		if (N >= 2) dp[1] = stair[0] + stair[1];
    // N = 3라면, 마지막 계단은 꼭 밟고, 나머지 두 개의 계단 중 큰 값을 밟는 것이 누적 점수 최댓값
    if (N >= 3) dp[2] = Math.max(stair[0], stair[1]) + stair[2];   
        
    // 출력
		System.out.println(find(N - 1));
	}
 
}
