import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];
        
        //숫자 입력
        for (int i = 0; i < N; i++)
            num[i] = Integer.parseInt(br.readLine());
        br.close();
        
        //숫자 오름차순 정렬
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if (num[i] > num[j]) {
                    int temp = num[i];
                    num[i] = num[j];
                    num[j] = temp;
                }
            }
        }
        
        //출력
        for (int i = 0; i < N; i++)
            bw.write(num[i] + "\n");
        bw.flush();
        bw.close();
    }
}
