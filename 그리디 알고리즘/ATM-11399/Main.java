import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 사람 수 N 입력
		int N = Integer.parseInt(br.readLine());
		int[] P = new int[N];	// 돈을 인출하는 데에 필요한 시간
		
		// 각 사람들이 돈을 인출하는 데에 걸리는 시간 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			P[i] = Integer.parseInt(st.nextToken());
		
		// 오름차순 정렬
		Arrays.sort(P);
		
		// 각 P[i]가 돈을 뽑을 때까지 기다리는 시간 구하기
		for (int i = 1; i < N; i++)
			P[i] = P[i - 1] + P[i];
		
		// 각 사람이 돈을 인출하는 데에 필요한 시간의 합 구하기
		int sum = 0;
		for (int i = 0; i < N; i++)
			sum += P[i];
		
		// 출력
		System.out.println(sum);
	}
 
}
