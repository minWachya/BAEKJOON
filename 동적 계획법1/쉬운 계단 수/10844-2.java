import java.io.*;

public class Main {
	static long[][] dp;
	
	static long find(int N, int index) {
		if (N == 0) return dp[N][index];
        
		if (dp[N][index] == 0)
			if (index == 0)	
				dp[N][index] = find(N - 1, 1);
			else if (index == 9)
				dp[N][index] = find(N - 1, 8);
			else 	
				dp[N][index] = find(N - 1, index - 1) + find(N - 1, index + 1);

		return dp[N][index] % 1000000000;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
		int N = Integer.parseInt(br.readLine());
		dp = new long[N][10];
		
		for (int index = 0; index < 10; index++)
			dp[0][index] = 1L;
		
		long result = 0;	
		for (int index = 1; index < 10; index++) 
			result += find(N - 1, index);
		
		System.out.println(result % 1000000000);
	}
 
}
