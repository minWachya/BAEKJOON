import java.io.*;
import java.util.*;

/* <전깃줄의 교차를 확인하는 방법>
 * 전깃줄 1은 1-2, 전긱줄 2는 3-1이라고 하자.
 * 조건 1, 전깃줄 1이 A전봇대에 연결되는 위치 번호(1) < 전깃줄 2이 A전봇대에 연결되는 위치 번호(3)
 * 조건 2, 전깃줄 1이 B전봇대에 연결되는 위치 번호(2) > 전깃줄 2이 B전봇대에 연결되는 위치 번호(1)
 * 조건 1과 조건 2를 모두 만족시키면 전깃줄 1과 2는 서로 교차함!
 */

public class Main {
	static int[][] wire;	// 입력받을 N개의 전깃줄 배열
	static int[] dp; // dp[n] = m; n번째 전깃줄을 설치하면 최대 m만큼의 전깃줄을 교차없이 연결할 수 있음
    // 단, n번째부터 N번째까지의 전깃줄 사이의 최댓값을 의미함.(0번째부터 N번째까지 연결 가능한 최대 전깃줄 수의 값이 아님)
	// ex) dp[3] = 2; 3번째 전깃줄을 연결했을 때 4번째부터 N번째 전깃줄까지 교차하지 않는 전깃줄이 2개(3번째 포함)
	
	static int find(int N) {
		if (dp[N] == 0) {
			dp[N] = 1;	// 자기 자신 하나 연결(기본)
			
			// N + 1번째 부터 N번째 전깃줄까지 연결 가능한 최대 전깃줄 수 구하기
			for (int i = N + 1; i < dp.length; i++)
				if (wire[N][1] < wire[i][1])	// 현재 전깃줄과 i번째 전깃줄이 조건 2를 만족하면,
					// 현재 값과 i번째 전깃줄을 연결했을 때의 연결 가능한 최대 전깃줄 값을 비교하여 더 큰 값 저장 
					dp[N] = Math.max(dp[N], find(i) + 1);
		}
		return dp[N];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		// 전깃줄 개수 입력
		int N = Integer.parseInt(br.readLine());
		wire = new int[N][2];	// wire[N개의 전깃줄][0 = A전봇대, 1 = B전봇대]
		dp = new int[N]; // dp[n] = m; n번째 전깃줄을 설치하면 최대 m만큼의 전깃줄을 교차없이 연결할 수 있음
		
		// N개의 전깃줄 입력(A-B)
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			wire[i][0] = Integer.parseInt(st.nextToken()); // A전봇대
			wire[i][1] = Integer.parseInt(st.nextToken()); // B전봇대
		}
		
		// A전봇대 기준으로 오름차순 정렬 = 조건 1 만족
		Arrays.sort(wire, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		// 연결 가능한 최대 전깃줄 갯수 찾기
		int max = 0;
		for (int i = 0; i < N; i++)
			if (max < find(i)) max = dp[i];
		
		// 출력
		// 없애야하는 전깃줄의 최소 개수 = 전체 전깃줄 갯수 - 연결 가능한 최대 전깃줄 갯수
		System.out.println(N - max);
	}
 
}
