import java.io.*;

public class Main {
	static long[] arr = new long[101];	// 파도반 수열을 담을 배열
	
	/* P(1) = 1
	 * P(2) = 1
	 * P(3) = 1
	 * P(4) = 2
	 * P(5) = 2
	 * P(6) = 3
	 * P(7) = 4
	 * ...P(N) = P(N - 1) + P(N - 5);
	 * */
	static long P(int N) {
		if (arr[N] == 0) 
			arr[N] = P(N - 1) + P(N - 5);
		
		return arr[N];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 테스트 케이스 수 입력
		int T = Integer.parseInt(br.readLine());
		
		// 초기화
		arr[1] = 1;
		arr[2] = 1;
		arr[3] = 1;
		arr[4] = 2;
		arr[5] = 2;
		
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());	// 입력
			
			bw.write(P(N) + "\n");					// 출력
		}
		bw.flush();
		bw.close();
		br.close();
	}
 
}
