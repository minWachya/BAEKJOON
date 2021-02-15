import java.io.*;
import java.util.*;

/* ex) 도로 길이     2   3   1
 *     기름값     5   2   4   1
 *     
 * 1단계 : 현재 기름값 < 다음 기름값이면, 현재 기름 값으로 다음 도로 달리기(다음 기름값을 현재 기름값으로 변경)
 *     도로 길이     2   3   1
 *     기름값     5   2   2   1
 *     
 * 2단계 : 도로 길이 * 기름값
 *      (2 * 5) + (3 * 2) + (1 * 2) = 18
 * */

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 도시 수 입력
		int N = Integer.parseInt(br.readLine());
		long[] roadLength = new long[N - 1];	// 도로 길이
		long[] cost = new long[N];			// 기름값
		
		// 도로 길이 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N - 1; i++)
			roadLength[i] = Integer.parseInt(st.nextToken());
		
		// 기름값 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			cost[i] = Integer.parseInt(st.nextToken());
		
		// 1단계
		long sum = 0;
		for (int i = 0; i < N - 1; i++) {
			if (cost[i] < cost[i + 1])    // 현재 기름값 < 다음 기름값이면,
				cost[i + 1] = cost[i];    // 현재 기름 값으로 다음 도로 달리기(다음 기름값을 현재 기름값으로 변경)
			
			// 2단계 : 도로 길이 * 기름값
			sum += roadLength[i] * cost[i];
		}
		
		// 출력
		System.out.println(sum);
	}
 
}
