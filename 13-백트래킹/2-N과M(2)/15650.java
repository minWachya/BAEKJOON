import java.io.*;
import java.util.*;

public class Main {
	private static int n, m;	// 입력받을 N, M
	private static int[] num;	// num[0] ~ num[m]까지가 출력할 1줄
	private static StringBuilder sb = new StringBuilder();
	
	// DFS(깊이 우선 탐색)
	public static void dfs(int depth, int number) {
		if (depth == m) {	// 깊이가 m이 되면 (num[0]~num[m]까지 다 채웠을 때) 출력
			for (int temp : num)
				sb.append(temp).append(' ');
			sb.append('\n');
			return;
		}
		
		for (int i = number; i <= n; i++) {	// number뷰터 n까지 반복(오름차순)
				num[depth] = i;				// num 배열에 숫자 채우기
				dfs(depth + 1, i + 1);		// 깊이 + 1, i + 1하며 재귀 호출
		}
		return;
	}
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine()); br.close();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        // num 배열 생성
        num = new int[m];
        
        // 시작
        dfs(0, 1);
        
        // 출력
        System.out.println(sb);
    }
}
