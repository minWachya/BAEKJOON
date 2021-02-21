import java.io.*;
import java.util.*;

public class Main {
 
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	// 큐 생성
    	Queue<Integer> q = new LinkedList<Integer>();
    	
    	// N 입력
    	int N = Integer.parseInt(br.readLine());
    	
    	// N개의 카드를 1부터 N까지의 숫자로 채우기
    	for (int i = 1; i <= N; i++)
    		q.offer(i);
    	
    	// 카드 동작하기
    	while (q.size() > 1) {
    		q.poll();	            // 제일 위에 있는 카드 버리기
    		int topCard = q.poll();	// 제일 위에 있는 카드를
    		q.offer(topCard);		// 제일 아래에 있는 카드 밑으로 옮기기
    	}
    	
    	// 출력
    	System.out.println(q.peek());
    }
 
}
