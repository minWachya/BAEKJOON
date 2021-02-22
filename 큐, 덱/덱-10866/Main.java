import java.io.*;
import java.util.*;

public class Main {
 
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	ArrayDeque<Integer> dq = new ArrayDeque<Integer>();	// 덱 생성
    	
    	// 명령 수 N 입력
    	int N = Integer.parseInt(br.readLine());
    	
    	while (N-- > 0) {
    		st = new StringTokenizer(br.readLine());	// 명령어 입력
    		
    		switch (st.nextToken()) {
    		case "push_front" :
    			dq.addFirst(Integer.parseInt(st.nextToken()));
    			break;
    			
    		case "push_back" :
    			dq.addLast(Integer.parseInt(st.nextToken()));
    			break;
    			
    		case "pop_front" :
    			if (dq.isEmpty()) sb.append(-1).append('\n');
    			else sb.append(dq.pollFirst()).append('\n');
    			break;
    			
    		case "pop_back" :
    			if (dq.isEmpty()) sb.append(-1).append('\n');
    			else sb.append(dq.pollLast()).append('\n');
    			break;
    			
    		case "size" : 
    			sb.append(dq.size()).append('\n');
    			break;
    			
    		case "empty" :
    			if (dq.isEmpty()) sb.append(1).append('\n');
    			else sb.append(0).append('\n');
    			break;
    			
    		case "front" :
    			if (dq.isEmpty()) sb.append(-1).append('\n');
    			else sb.append(dq.peekFirst()).append('\n');
    			break;
    			
    		case "back" :
    			if (dq.isEmpty()) sb.append(-1).append('\n');
    			else sb.append(dq.peekLast()).append('\n');
    			break;
    		}
    	}
    	
    	// 출력
    	System.out.println(sb);
    }
 
}
