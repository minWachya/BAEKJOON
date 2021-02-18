import java.io.*;
import java.util.Stack;

public class Main {
	static String find(String str) {
		// 스택 생성
    	Stack<Character> stack = new Stack<Character>();
		
    	/* 1단계 : "(", "[" 일 때 push하고
    	 * 2단계 : ")", "]" 일 때 pop 해서 empty하면 YES
    	 * 주의 1: 이때, "()))"처럼 ")"가 많으면 empty지만 NO 해줘야 함
    	 * 주의2 : peek한 괄호와 이전 괄호가 짝이 맞지 않는다면 NO 
    	 * */
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
		
			if (c == '(' || c == '[') stack.push(c);	// 1단계
			else if (c == ')') 				// 2단계
				if (stack.isEmpty() || stack.peek() != '(') return "no";	// 주의
				else stack.pop();
			else if (c == ']')				// 2단계
				if (stack.isEmpty() || stack.peek() != '[') return "no";	// 주의
				else stack.pop();
		}
		
		return (stack.isEmpty() ? "yes" : "no");
	}
 
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	while (true) {
    		String str = br.readLine();		// 입력
    		if (str.equals(".")) break;		// 종료 조건
    			
    		System.out.println(find(str));	// 출력
    	}	
    }
 
}
