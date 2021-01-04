import java.io.*;
import java.util.StringTokenizer;

public class Main {
	private static int n;	// 숫자 갯수
	private static int[] arr;	// A1 ~ An 까지의 숫자 배열
	private static int[] operator = new int[4];	// 연산자, 인덱스 0 : +, 1 : -, 2 : *, 3 : /
	private static int max = Integer.MIN_VALUE;	// 최댓값
	private static int min = Integer.MAX_VALUE;	// 최솟값
	
	// 백트래킹 함수
	public static void dfs(int num, int index) {	// num : 이전에 계산한 결과
		// index가 n과 같다면(모든 연산을 마치면) 돌아가기
		if (index == n) {
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}
		
		// 4가지 연산을 한 번씩 해보기
		for (int i = 0; i < 4; i++) {
			if (operator[i] > 0 ) {	// 연산자 갯수가 0이 아니라면
				operator[i]--;		// 헤당 연산자 1 감소
				
				// 해당 연산자로 연산하기
				switch(i) {
				case 0 :	// 더하기 +
					dfs(num + arr[index], index + 1);
					break;
				case 1 : 	// 빼기 - 
					dfs(num - arr[index], index + 1);
					break;
				case 2 :	// 곱하기 *
					dfs(num * arr[index], index + 1);
					break; 
				case 3 : 	// 나누기 /
					dfs(num / arr[index], index + 1);
					break;
				}
				
				operator[i]++;	// 연산 끝나면 다시 원래대로
			}
		}
	}
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	// 입력
    	n = Integer.parseInt(br.readLine());
    	arr = new int[n];	// n개의 숫자 배열 생성
    	
    	// 숫자 배열(A1 ~ An) 입력
    	st = new StringTokenizer(br.readLine());
    	for (int i = 0; i < n; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	// 연산자 갯수 입력
    	st = new StringTokenizer(br.readLine());
    	for (int i = 0; i < 4; i++) {
    		operator[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	// 연산하기
    	dfs(arr[0], 1);	// index 0부터 계산하니까 다음 index는 1
    	
    	// 출력
    	System.out.println(max + "\n" + min);
    }
}
