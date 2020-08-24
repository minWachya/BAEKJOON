import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    static final int MAX = 10001;
    
    static int[] num = new int[MAX];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int temp;
        
        //숫자 입력(숫자 입력할 때마다 num[입력한 숫자]++)
        for (int i = 0; i < N; i++) {
            temp = Integer.parseInt(br.readLine());
            num[temp]++;
        }
        br.close();
        
        //출력
        for (int i = 0; i < MAX; i++) {
            if (num[i] == 0) continue;
            
            for (int j = 0; j < num[i]; j++)
                bw.write(i + "\n");
        }
        bw.flush();
        bw.close();
    }
}
