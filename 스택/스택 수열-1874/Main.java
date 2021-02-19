import java.io.*;
import java.util.Stack;

public class Main {
 
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	// N 입력
    	int N = Integer.parseInt(br.readLine());
    	
    	// 스택 생성
    	Stack<Integer> stack = new Stack<Integer>();
    		
    	// N개의 숫자 입력
    	int start = 1;	// 스택에 1부터 저장(문제 : 1부터 N까지의 수를 스택에 넣었다가)
    	for (int i = 0; i < N; i++) {
    		int value = Integer.parseInt(br.readLine());	// 숫자 입력
    		
    		// 입력한 숫자가 시작 숫자보다 크면
    		if (value >= start) {
    			// start + 1 부터 value 까지 stack에 push 하기(오름차순으로 push 됨)
    			for (int num = start; num <= value; num++) {
    				stack.push(num);				// push
    				sb.append('+').append('\n');	// push한 만큼 + 출력
    			}
    			start = value + 1; // 다음 숫자부터 다시 push 준비
    		}
    		// stack의 맨 위 숫자과 입력한 숫자가 다르면(스택을 이용해 입력된 수열을 만들 수 없음)
    		else if (stack.peek() != value) {
    			System.out.println("NO");
    			System.exit(0);
    		}
    		
    		// stack의 맨 위 슷자와 입력한 숫자가 같으면
    		stack.pop();	// 빼서 수열에 추가(문제 : 뽑아 늘어놓음으로써 하나의 수열을 만들 수 있다)
    		sb.append('-').append('\n');	// - 출력
    	}
    	
    	// 결과 출력
    	System.out.println(sb);
    }
 
}
