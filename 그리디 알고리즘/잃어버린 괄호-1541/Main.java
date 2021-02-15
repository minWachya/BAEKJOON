import java.io.*;
import java.util.StringTokenizer;
/*
ex) 50+30-10+30+40-30+10을 최솟값으로 만들기 = 50+30-(10+30+40)-(30+10)
(- 뒤에 오는 숫자들을 괄호로 묶기)

1단계 : - 기준으로 나누기
50+30 / 10+30+40 / 30+10

2단계 : +기준으로 나누고 더하기
80 / 80 / 40

3단계 : 빼기(이때, 맨 첫 번째 숫자는 빼지 말고 더해야 함.)
80 - 80 - 30 = -40
*/

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 식 입력
        // 1단계 : -기준으로 나누기
		StringTokenizer st1 = new StringTokenizer(br.readLine(), "-");
		
        // 2단계 : + 기준으로 나누고 더하기(맨 첫 번째 숫자는 더하기)
		StringTokenizer st2 = new StringTokenizer(st1.nextToken(), "+");
		int sum = 0;
		while (st2.hasMoreTokens())
			sum += Integer.parseInt(st2.nextToken());
		
        // 2단계 : + 기준으로 나누고 더하기
		while(st1.hasMoreTokens()) {
			st2 = new StringTokenizer(st1.nextToken(), "+");
			
            // 3단계 : 빼기
			while (st2.hasMoreTokens())
				sum -= Integer.parseInt(st2.nextToken());
		}
		
        // 출력
		System.out.println(sum);
	}
 
}
