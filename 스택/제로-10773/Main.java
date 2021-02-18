import java.io.*;
import java.util.Stack;

public class Main {
 
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	// 정수 K 입력
    	int K = Integer.parseInt(br.readLine());
    	
    	// 스택 생성
    	Stack<Integer> stack = new Stack<Integer>();
    	
        // 숫자 입력
    	for (int i = 0; i < K; i++) {
    		int num = Integer.parseInt(br.readLine());
    		
    		if (num == 0) stack.pop();
    		else stack.push(num);
    	}
    	
    	// 합 구하기
    	int sum = 0;
    	while (!stack.isEmpty()) {
    		sum += stack.pop();
    	}
    		
    	// 출력
    	System.out.println(sum);
    }
 
}
