import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// N의 약수 갯수 입력
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		
		// N의 약수 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			num[i] = Integer.parseInt(st.nextToken());
		
        // N의 약수를 오름차순으로 정렬
		Arrays.sort(num);
		
		// 출력
		System.out.println(num[0] * num[n - 1]);
	}
 
}
