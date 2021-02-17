import java.io.*;
import java.util.StringTokenizer;

public class Main {
	// 유클리드 호제법으로 최대 공약수 구하기(Greatest Common Divisor)
	/*	1단계, a > b
	 * 	2단계, r = a % b
	 * 	3단계, 만약 r = 0이면 최대 공약수 = b
	 * 	4단계, r = 0이 아니면 a = b, b = r로 바꾸고 3단계 반복
	 * */
	public static long getGCD(long a, long b) {
		long r = a % b;	// 2단계, r = a % b
		
		// 4단계, r = 0이 아니면 a = b, b = r로 바꾸고 3단계 반복
		while (r > 0) {	// 3단계, 만약 r = 0이면 최대 공약수 = b
			a = b;
			b = r;
			r = a % b;
		}
		
		return b;
	}
	
	// 유클리드 호제법으로 최소 공배수 구라기(Least Common Multiple)
	// a * b / 최대 공배수
	public static long getLCM(long a, long b, long gcd) {
		return (a * b) / gcd;
	}
 
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st;
    	
    	// 테스트 케이스 입력
    	int T = Integer.parseInt(br.readLine());
    	
    	for (int i = 0; i < T; i++) {
    		st = new StringTokenizer(br.readLine());
    		long a = Long.parseLong(st.nextToken());
    		long b = Long.parseLong(st.nextToken());
    		
    		// 최대 공약수 구하기
    		long gcd = getGCD(Math.max(a, b), Math.min(a, b));	// 1단계, a > b
    		
    		// 최소 공배수 구하기
    		long lcm = getLCM(a, b, gcd);
    		
    		// 출력
    		bw.write(lcm + "\n");
    	}
    	bw.flush();
    	bw.close();
    	br.close();
    }
 
}
