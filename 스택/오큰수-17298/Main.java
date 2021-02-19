import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
 
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	// 스택 생성
    	Stack<Integer> stack = new Stack<Integer>();
    	
    	// 수열 A의 크기 입력
    	int N = Integer.parseInt(br.readLine());
    	int[] A = new int[N];	// 수열 A 생성
    	
    	// 수열 A의 요소 입력
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for (int i = 0; i < N; i++) 
    		A[i] = Integer.parseInt(st.nextToken());
    	
    	// A[0] ~ A[N-1]의 오큰수 구하기(A[index]의 오큰수를 구해서 A[index]에 저장하기)
    	for (int index = 0; index < N; index++) {
    		// stack이 비지 않았고(안에 index가 남아있고), 현재 수 < 오른쪽 수 라면
    		while (!stack.isEmpty() && A[stack.peek()] < A[index]) {
    			A[stack.pop()] = A[index];	// 햔재 수의 오큰수는 A[index]
    		}
    		stack.push(index);	// A[index]의 오큰수를 구하기 위해 A의 index를 push
    	}
    	
    	// 오큰수를 구하지 못한 수들(오큰수가 없는 수)을 -1로
    	while (!stack.isEmpty())
    		A[stack.pop()] = -1;
    	
    	// 출력
    	StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb.append(A[i]).append(' ');
		}
		System.out.println(sb);
    }
 
}
