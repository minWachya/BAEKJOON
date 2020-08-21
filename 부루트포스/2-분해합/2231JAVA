import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static void divideSum(int N){
        int M = 0;    //N의 생성자
    
        //N = M + (M 자리수의 합) ==>> M = N - (M 자리수의 합)
        //M이 최솟값이 되기 위해선 (M 자리수의 합)이 최대여야함(N-54)
        //N-54 => M의 최댓값은 6자리(300,000), 각 자리수의 최댓값 = 9 => 6*9 = 54
        for (int i = N-54; i < N; i++) {
            int sum = i;    //M
            int temp = i;   //M의 각 자리수의 합을 구하기 위한 변수
        
        //temp가 더이상 나눠지지 않을 때까지
        while (temp > 0) {
            sum += temp%10;    //M에 M의 각 자리수를 더하기(1의 자리부터)
            temp /= 10;
            }
            
        if (sum == N) {
            M = i;
            break;
            }
        }
        System.out.println(M);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); br.close();
        divideSum(N);
    }
}
