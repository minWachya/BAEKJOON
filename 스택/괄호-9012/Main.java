import java.io.*;
import java.util.Stack;

public class Main {
	static String find(String str) {
		// 스택 생성
    	Stack<Character> stack = new Stack<Character>();
		
    	/* 1단계 : "(" 일 때 push하고
    	 * 2단계 : ")" 일 때 pop 해서 empty하면 YES
    	 * 주의 : 이때, "()))"처럼 ")"가 많을 땐 empty지만 NO 해줘야 함
    	 * */
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if (c == '(') stack.push(c);			// 1단계
			else if (stack.isEmpty()) return "NO";	// 주의
			else stack.pop();						// 2단계
			
		}
		
		return (stack.isEmpty() ? "YES" : "NO");
	}
 
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	// 테스트 케이스 T 입력
    	int T = Integer.parseInt(br.readLine());
    	
    	for (int i = 0; i < T; i++) {
    		String str = br.readLine();		// 입력
    			
    		System.out.println(find(str));	// 출력
    	}	
    }
 
}
