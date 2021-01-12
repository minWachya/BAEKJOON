import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		
        // 출력
        System.out.println(tile(n));
	}
	/* 
	n = 1일 때 1
    n = 2일 때 2
    n = 3일 때 3... = n = 1일 떼 + n = 2일 때
    n = 4일 때 5... = n = 2일 떼 + n = 3일 때
    n = 5일 때 8... = n = 3일 떼 + n = 4일 때*/
	public static int tile(int n) {
        if (n <= 2) return n;
        
        int num1 = 1;	// n = 1일 때 1
        int num2 = 2;	// n = 2일 때 2
        int sum = 0;	// ...(n - 1)일 떼 + (n - 2)일 때
        
        for (int i = 2; i < n; i++) {
        	sum = (num1 + num2) % 15746; // (n - 1)일 때 + (n - 2)일 때
        	num1 = num2;	// n - 1
        	num2 = sum;		// n - 2
        }
        return sum;
	}
 
}
