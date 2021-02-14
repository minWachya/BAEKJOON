import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 회의 수 N 입력
		int N = Integer.parseInt(br.readLine());
		int[][] schedule = new int[N][2];
		
		// N개의 회의 시작 시간과 종료 시간 입력
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			schedule[i][0] = Integer.parseInt(st.nextToken());	// 시작 시간
			schedule[i][1] = Integer.parseInt(st.nextToken());	// 종료 시간
		}
		
		// 회의가 일찍 끝나는 순서대로 정렬(빨리 끝나는 회의를 많이 집어 넣는 것이 최댓값)
		Arrays.sort(schedule, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// 회의 종료 시간이 같아면 일찍 시작하는 회의부터
				// ex) (시작, 종료) : (1, 2), (3, 3), (2, 3)일 때,
				// (1, 2), (3, 3), (2, 3) 순으로 정렬되면 회의 최대 갯수는 (1, 2), (3, 3)으로 2 이지만
				// 시작 시간이 빠른 순서대로 정렬하면 (1, 2), (2, 3), (3, 3)으로 3개가 됨.
				if (o1[1] == o2[1]) return o1[0] - o2[0];
				return o1[1] - o2[1];
			}
		});
		
		// 최대 사용 가능한 회의 최대 개수 찾기
		int endTime = 0;	// 회의가 끝나는 시간
		int count = 0;		// 사용한 회의 갯수
		for (int i = 0; i < N; i++) {
			if (endTime <= schedule[i][0]) {	// 회의가 끝나고 바로 시작 가능한 회의가 있으면
				endTime = schedule[i][1];		// 그 회의가 끝나는 시간으로 갱신하고 다시 반복
				count++;	// 회의++
			}
		}
		
		// 출력
		System.out.println(count);
	}
 
}
