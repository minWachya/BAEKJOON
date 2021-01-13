import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;	// 삼각형의 숫자들을 입력받을 배열
	// ex) arr[depth][intdex] : depth층의 index번째 요소
	// ex) arr[2][1] : 아래 그림으로 따지면 2층의 1번째 요소 = 5
	static Integer[][] dp;	// 최댓값 경로를 저장할 배열
	// 트리라고 가정하고 설명하면,
	// 부모의 왼쪽 자식과 오른쪽 자식 값 중 더 큰 값 + 부모 값을 다시 부모의 값에 저장함
	// 아래부터 위로 차례로 값을 저장해감
	/* ex)arr		dp
	  	   1        10		// 10 = 9 + 1
	  	  2 3       7 9		// 7 = 5 + 2. 9 = 6 + 3
	     4 5 6     4 5 6	// 맨 아랫 층은 arr배열 그대로
	  */
	static int N;	// 삼각형의 크기
	
	static int find(int depth, int index) {
		if (depth == N - 1)	// N층까지 도착하면 출력
			return dp[depth][index];
		
		// 아직 최댓값 경로를 저장하지 않았다면
		if (dp[depth][index] == null) 
			dp[depth][index] = Math.max(find(depth + 1, index), find(depth + 1, index + 1)) + arr[depth][index];
			// 부모 = 왼쪽 자식과 오른쪽 자식 중 더 큰 값 + 부모 값
		
		return dp[depth][index];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 입력
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];	// 삼격형의 숫자를 입력받을 배열 생성
		dp = new Integer[N][N];		// 최댓값 경로를 저장할 배열 생성
		
		for (int depth = 0; depth < N; depth++) {	// N층 만큼 입력
			st = new StringTokenizer(br.readLine());
			
			for (int index = 0; index <= depth; index++)// 1층 = 요소 1개, 2틍 = 요소 2개...N층 = 요소 N개
				arr[depth][index] = Integer.parseInt(st.nextToken());	// depth층의 index번째 요소
		}
		
		// 맨 아랫층은 arr배열 그대로(그래야 다음 층부터 최댓값을 고를 수 있음)
		for (int i = 0; i < N; i++)
			dp[N - 1][i] = arr[N - 1][i];
		
		// 출력
		System.out.println(find(0, 0));
	}
 
}
