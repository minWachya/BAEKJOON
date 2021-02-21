import java.io.*;
import java.util.*;

public class Main {
 
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	// 큐 생성
    	Queue<Integer> q = new LinkedList<Integer>();
    	
    	// N, K 입력
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());
    	
    	// 큐 초기화
    	for (int i = 1; i <= N; i++)
    		q.offer(i);
    	
    	// 출력 준비
    	StringBuilder sb = new StringBuilder();
    	sb.append('<');
    	
    	// K번째 숫자 제거 반복하기
    	while (q.size() > 1) {
    		for (int i = 1; i < K; i++) {// K-1번째 동안 반복
    			int temp = q.poll();	 // 맨 위 숫자를
    			q.offer(temp);			 // 맨 뒤로 보내기
    		}
    		// K번째 숫자 제거하면서 출력
    		sb.append(q.poll()).append(", ");
    	}
    	sb.append(q.poll()).append('>');	// 츌력 마무리
    	
    	// 출력
    	System.out.println(sb);
    }
 
}
