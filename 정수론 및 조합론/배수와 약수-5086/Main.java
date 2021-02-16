import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static String find(int a, int b) {
		// a가 b의 약수
		if (b % a == 0) return "factor";
		// a가 b의 배수
		else if (a % b == 0) return "multiple";
		// 둘 다 아님
		return "neither";
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		// 입력
		while (true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (a == 0 && b == 0) break;	// 종료 조건
			
			String str = find(a, b);		// 관계 구하기
			
			// 출력
			bw.write(str + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
 
}
