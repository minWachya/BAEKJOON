import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int[][][] dp = new int[21][21][21];
	// -50 <= a, b, c <= 50이지만, w메소드의 2번째 if문에서 20 이상이면 모두 20으로 바뀌므로 20까지 배열 생성
	
	static int w(int a, int b, int c) {
		// 0 <= a, b, c <= 20이고, 전에 계산한 적이 있는 값이면 그 값을 반환
		if (isRange(a, b, c) && dp[a][b][c] != 0) return dp[a][b][c];
		
		if (a <= 0 || b <= 0 || c <= 0) return 1;
		// dp[a][b][c]에 값을 저장
		if (a > 20 || b > 20 || c > 20) return dp[20][20][20] = w(20, 20, 20);
		// 아래부턴 a, b, c가 20을 넘지 않음
		if (a < b && b < c)
			return dp[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
		return dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
	}
	// 0 <= a, b, c <= 20인지? (dp의 인덱스는 20까지 있으니까 인덱스를 넘지 않도록 체크)
	static boolean isRange(int a, int b, int c) {
		return 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20;
	}
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
;    	StringTokenizer st;
    	
    	while (true) {
    		st = new StringTokenizer(br.readLine());
    		
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		int c = Integer.parseInt(st.nextToken());
    		
    		// a, b, c가 모두 -1이면 종료
    		if (a == -1 && b == -1 && c == -1) break;
    		
    		// 출력
    		bw.write("w(" + a + ", " + b + ", " + c + ") = "
    				+ w(a, b, c) + "\n");
    	}
        bw.flush();
        bw.close();
        br.close();
    	
    }	// end of main
}
