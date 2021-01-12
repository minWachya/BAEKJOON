import java.io.*;

public class Main {
	public static int[] dp;    // 이전 결과를 저장할 배열
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		dp = new int[n + 2];
		dp[1] = 1;
		dp[2] = 2;
        
        // 출력
        System.out.println(tile(n));
	}
	/* n = 1일 때 dp[1] = 1
       n = 2일 때 dp[2] = 2
       n = 3일 때 dp[3] = 3
       n = 4일 때 dp[4] = 5
       n = 5일 때 dp[5] = 8... dp[n] = dp[n - 1] + dp[n - 2]*/
	public static int tile(int n) {
        if(dp[n] == 0)
			dp[n] = (tile(n - 1) + tile(n - 2)) % 15746;    // (A+B)%C == (A%C + B%C)%C
		return dp[n];
	}
 
}
