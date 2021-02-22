import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		LinkedList<int[]> q;	// [0] = 문서 순서, [1] = 문서 중요도
		
		// 테스트 케이스 입력
		int T = Integer.parseInt(br.readLine());	
 
		while (T-- > 0) {
			// 문서 갯수 N, 몇 번째로 인쇄되었는지 궁금한 문서 M 입력
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			q = new LinkedList<>();	// Queue의 활용, [0] = 문서 순서, [1] = 문서 중요도
			
			// N개 문서의 중요도 입력
			st = new StringTokenizer(br.readLine());
			// 문서 순서와 문서 중요도를 q에 저장
			for (int i = 0; i < N; i++) 
				q.offer(new int[] {i, Integer.parseInt(st.nextToken())});
			
			// 프린트 가동
			int count = 0;	// 인쇄 횟수
			while (!q.isEmpty()) {
				int[] frontDocument = q.poll();	// 맨 처음 문서
				boolean isMax = true;	// frontDocument가 가장 중요도가 큰지?
				
				// q의 다른 문서들과 중요도 비교 
				for(int i = 0; i < q.size(); i++) {
					// 맨 처음 문서보다 i번쩨 문서의 중요도가 크다면
					if(frontDocument[1] < q.get(i)[1]) {
						q.offer(frontDocument);	// 맨 처음 문서를 뒤로 보내고
						
						// i이전의 문서들도 다 뒤로 보내기
						for(int j = 0; j < i; j++)
							q.offer(q.poll());
						
						isMax = false;	// 맨 첫 번째 문서의 중요도가 가장 크지 않음
						
						break;
					}
				}
                
				if(isMax) {
                    count++;	// 맨 첫 번째 문서의 중요도가 가장 크다면 출력하기(인쇄 횟수++)
                    if(frontDocument[0] == M) break; // M번째 문서라면 반복 종료
                }
			}
			
			// M번째 문서의 인쇄 차례 출력
			sb.append(count).append('\n');
		}
		
		// 출력
		System.out.println(sb);
	}

}
