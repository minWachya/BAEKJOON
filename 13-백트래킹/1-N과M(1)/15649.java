import java.io.*;
import java.util.*;

public class Main {
	public static int[] num;          // num[0]~num[m]까지가 출력 1줄
	public static boolean[] visit;    // 방문 상태
    //->(true = 방문 중인 상태(방문 불가능), false = 방문하지 않은 상태(방문 가능))
	public static StringBuilder sb = new StringBuilder();
	
    // DFS(깊이 우선 탐색)
	public static void dfs(int n, int m,  int depth) {
		if (depth == m) {    // 깊이가 m이 되면(num[0]~num[m]까지 다 채웠을 때) 출력
			for (int temp : num)
				sb.append(temp).append(' ');
			sb.append('\n');
			return;
		}
        
		for (int i = 0; i < n; i++) {
			if (!visit[i]) {           // 방문하지 않은 상태면
				visit[i] = true;       // 해당 노드를 방문 중인 상태로 변경(방문 불가능)
                //->(방문 중이면 방문 못 함(중복 방지))
                
				num[depth] = i + 1;    // num 배열에 숫자 채우기
				dfs(n, m, depth + 1);  // 다음 자식 노드 방문을 위해 depth + 1하며 재귀호출
                
				// 방문이 끝나면 해당 노드를 방문하지 않은 상태(방문 가능)로 변경
                visit[i] = false;     
			}
		}
        return;
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine()); br.close();
        int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
        
        // num배열과 visit배열 생성
        num = new int[m];
        visit = new boolean[n];
        
        // 시작
        dfs(n, m, 0);
        // 출력
        System.out.println(sb);
    }
}
