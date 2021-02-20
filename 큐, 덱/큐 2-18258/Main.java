import java.io.*;
import java.util.*;

public class Main {
 
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	// 큐 생성(Queue에는 back이 없음, back구현을 위해 LinkedList로 선언)
    	Deque<Integer> q = new LinkedList<Integer>();
    	
    	// 명령 수 N 입력
    	int N = Integer.parseInt(br.readLine());
    	
    	// N개의 명령 입력
    	StringTokenizer st;
    	for (int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		
    		switch (st.nextToken()) {
    		case "push" :
    			q.offer(Integer.parseInt(st.nextToken()));
    			break;
    			
    		case "pop" :
    			Integer popNum = q.poll();
    			if (popNum == null) sb.append(-1).append('\n');
    			else sb.append(popNum).append('\n');
    			break;
    			
    		case "size" :
    			sb.append(q.size()).append('\n');
    			break;
    			
    		case "empty" : 
    			if (q.isEmpty()) sb.append(1).append('\n');	// 비어 있으면 1
    			else sb.append(0).append('\n');				// 아니면 0
    			break;
    			
    		case "front" :
    			Integer forntNum = q.peek();
    			if (forntNum == null) sb.append(-1).append('\n');
    			else sb.append(forntNum).append('\n');
    			break;
    			
    		case "back" : 
    			Integer backNum = q.peekLast();
    			if (backNum == null) sb.append(-1).append('\n');
    			else sb.append(backNum).append('\n');
    			break;
    		}
    	}
    	// 출력
    	System.out.println(sb);
    }
 
}
