import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static char[] str1;	// 입력받을 문자열 1
	static char[] str2;	// 입력받을 문자열 2
	static Integer[][] dp;	// dp[x][y] = m; str1의 x번째까지의 문자열과 str2의 y번째까지의 문자열의 LCS 길이는 m
	// ex) str1 = ACAYKP, str2 = CAPCAK일 때
	// dp[2][3] = ACA와 CAPC의 LCS 길이는 {A, C}로 2
	
	// LCS(Longest Common Subsequence, 최장 공통 부분 수열), LCS 길이를 리턴함
	static int LCS(int x, int y) {
		// 인덱스 오류 방지(공집합)
		if (x < 0 || y < 0) return 0;
		
		// 아직 참색하지 않았다면
		if (dp[x][y] == null) {
			dp[x][y] = 0;	// 부분 수열을 0으로 초기화(공통 부분 수열이 0개)
			
			// str1의 x번째 문자와 str2의 y번째 문자가 같으면(이전 공통 부분 수열 + 1)
			if (str1[x] == str2[y]) dp[x][y] = LCS(x - 1, y - 1) + 1;
			// 같지 않으면 str1의 길이를 하나 줄인 LCS 길이와 str2의 길이를 하나 줄인 LCS 길이 줄 최댓값으로
			else dp[x][y] = Math.max(LCS(x - 1, y), LCS(x, y - 1));
		}
		return dp[x][y];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		// 두 문자열 입력
		str1 = br.readLine().toCharArray();
		str2 = br.readLine().toCharArray();
		
		dp = new Integer[str1.length][str2.length];
		
		// 출력
		System.out.println(LCS(str1.length - 1, str2.length - 1));
	}
 
}
