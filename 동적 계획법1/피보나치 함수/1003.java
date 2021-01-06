import java.io.*;

public class Main {
	private static Integer[][] dp = new Integer[41][2];
	// dp[i][0] : n = i일 때 0의 호출 횟수, dp[i][1] : n = i일 때 1의 호출 횟수
	
	static Integer[] fibonacci(int n) {
		// n을 아직 탐색하지 않았을 때
		if (dp[n][0] == null | dp[n][1] == null) {
			// n일 때의 0과 1 호출 횟수를 재귀호출
			dp[n][0] = fibonacci(n - 1)[0] + fibonacci(n - 2)[0];
			dp[n][1] = fibonacci(n - 1)[1] + fibonacci(n - 2)[1];
		}
		// n을 이미 탐색했으면 dp[n][0], dp[n][1] 정보를 담고 있는 dp[n]를 리턴
		return dp[n];
	}
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	dp[0][0] = 1;	// n = 0 일 때 0의 호출 쵯수
    	dp[0][1] = 0;	// n = 0 일 때 1의 호출 쵯수
    	dp[1][0] = 0;	// n = 1 일 때 0의 호출 쵯수
    	dp[1][1] = 1;	// n = 1 일 때 1의 호출 쵯수
    	
    	// 테스트 케이스 T 입력
    	int T = Integer.parseInt(br.readLine());
    	
    	for (int i = 0; i < T; i++) {
    		// 입력
    		int n = Integer.parseInt(br.readLine());
    		// 0, 1의 호출 횟수 구하기
    		fibonacci(n);
    		// 출력
    		sb.append(dp[n][0] + " " + dp[n][1] + "\n");
    	}
    	System.out.print(sb);
    }	// end of main
}
