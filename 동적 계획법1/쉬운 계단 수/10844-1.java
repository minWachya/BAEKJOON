import java.io.*;

public class Main {
	static long[][] dp;	// 계단 수를 저장할 배열
	// ex) dp[N][index] = m; N의 자리수가 index일 때 계단 수 m개
	// ex) dp[2][3] = 2; 2의 자리수가 3인 계단 수는 2개(32, 34)
	
	static long find(int N, int index) {
		if (N == 1) return dp[N][index];	// 1의 자리수는 1 리턴
		
		if (dp[N][index] == 0)	// dp[N][index]가 정의되어있지 않으면
			if (index == 0)		// N의 자리 수가 0이면 다음에 올 수는 반드시 1
				dp[N][index] = find(N - 1, 1);
			else if (index == 9)// N의 자리 수가 9면 다음에 올 수는 반즈시 8
				dp[N][index] = find(N - 1, 8);
			else 				// N의 자리 수가 index이면 다음에 올 수는 1 작거나 1 큰 수
				dp[N][index] = find(N - 1, index - 1) + find(N - 1, index + 1);
		// 출력 조건 : 1,000,000,000으로 나눈 나머지
		return dp[N][index] % 1000000000;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		// 입력
		int N = Integer.parseInt(br.readLine());
		dp = new long[N + 1][10];	// 설명 편하게 하기 위해 N + 1로 선언(dp[0]은 안 씀)
		
		for (int index = 0; index < 10; index++)
			dp[1][index] = 1L;
		
		long result = 0;	// 계단 수 결과
		for (int index = 1; index < 10; index++) // 0으로 시작하는 계딴은 없으니 1부터 계단수 세기
			result += find(N, index);	// N의 자리가 index인 계단 수를 누적하여 저장
		
		// 출력 조건 : 1,000,000,000으로 나눈 나머지
		System.out.println(result % 1000000000);
	}
 
}
