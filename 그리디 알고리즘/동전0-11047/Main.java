import java.io.*;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// N, K 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	// 동전 갯수
		int K = Integer.parseInt(st.nextToken());	// 원하는 합
		
		// 동전 가치를 담은 배열
		int[] coin = new int[N];
		
		// 동전 입력
		for (int i = 0; i < N; i++)
			coin[i] = Integer.parseInt(br.readLine());
		
		// K원을 만들기 위한 동전 갯수의 최댓값 구하기
		int count = 0;
		for (int i = N - 1; i >= 0; i--) {
			count += K / coin[i];
			K %= coin[i];
		}
		
		// 출력
		System.out.println(count);
	}
 
}
