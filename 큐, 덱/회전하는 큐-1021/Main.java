import java.io.*;
import java.util.*;

public class Main {
 
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	LinkedList<Integer> deque = new LinkedList<Integer>();	// 큐 생성
    	
    	int count = 0;	// 2번, 3번 연산 횟수
    	
    	// N, M 입력
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());	// 큐의 크기 N
    	int M = Integer.parseInt(st.nextToken());	// 뽑으려하는 수의 갯수 M
    	
    	// 1~N까지의 숫자를 덱에 담기
    	for (int i = 1; i <= N; i++)
    		deque.offer(i);
    	
    	// 뽑으려는 수 M개 입력
    	st = new StringTokenizer(br.readLine());
    	int[] m = new int[M];	// 뽑으려하는 수가 담긴 배열
    	for (int i = 0; i < M; i++)
    		m[i] = Integer.parseInt(st.nextToken());
    	
    	// m[0~M-1] 뽑아내기
    	// 뽑아내려는 요소가 큐의 첫 번째 요소가 될 때까지 2번 연산, 3번 연산 반복
    	for (int i = 0; i < M; i++) {
    		int targetIndex = deque.indexOf(m[i]);	// 뽑으려는 숫자의 인덱스
    		
    		int halfIndex;	// 큐의 중간 위치
    		if (deque.size() % 2 == 0) halfIndex = deque.size() / 2 - 1;	// N이 짝수면 중간 위치는 N/2-1
    		else halfIndex = deque.size() / 2;	// 홀수면 중간 위치는 N/2
    		
    		// 뽑으려는 숫자가 중간 지점보다 앞에 있으면
    		if (targetIndex <= halfIndex) {
    			// 2번 연산(왼쪽으로 한 칸씩 이동)
    			for (int j = 0; j < targetIndex; j++) {
    				int temp = deque.pollFirst();	// 맨 앞 요소를
    				deque.offerLast(temp);			// 맨 뒤로 보내기
    				count++;						// 연산 횟수 증가
    			}
    		}
    		// 뽑으려는 숫자가 중간 지점보다 뒤에 있으면
    		else {
    			// 3번 연산(오른쪽으로 한 칸씩 이동)
    			for (int j = 0; j < deque.size() - targetIndex; j++) {
    				int temp = deque.pollLast();	// 맨 뒤 요소룰
    				deque.offerFirst(temp);			// 맨 앞으로 보내기
    				count++;						// 연산 횟수 증가
    			}
    		}
    		
    		// 1번 연산(첫 번째 요소 뽑아내기)
    		deque.pollFirst();
    	}	// for문 끝
    	
    	// 출력
    	System.out.println(count);
    }
 
}
