import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());    //숫자 카드 갯수 N
        int M = Integer.parseInt(st.nextToken());    //세 숫자의 합 마지노선 M
        int sum, max = 0;
        
        //N개의 숫자 입력 
        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
        
        //세 수의 합 모든 경우 구하기
        //세 수의 합 sum이 M과 가장 가까워 질 때마다 max 수정
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                for(int k = j+1; k < N; k++) {
                    sum = nums[i] + nums[j] + nums[k];
                    if (sum > max && sum <= M)
                        max = sum;
                }
            }
        }
        System.out.println(max);
    }
}
