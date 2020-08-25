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
        int[] count = new int[MAX];    //count[입력한 숫자 + 4000] = 입력한 숫자의 중복된 갯수
                                       //ex)count[4004] = 2 : count[4 + 4000] = 2 : 4가 2번 입력됨.
        //입력
        int num;
        for (int i = 0; i < N; i++) {
            num = Integer.parseInt(br.readLine());
            count[num + 4000]++;
        }
        br.close();
        
        //출력
        bw.write(average(count, N) + "\n");            //산술 평균
        bw.write(mid(count, N) + "\n");                //중앙값
        bw.write(mostNum(count, N) + "\n");            //최빈값
        bw.write(range(count, N) + "\n");              //범위
        bw.flush();
        bw.close();
    }
    
    static final int MAX = 8001;
    
    //산술 평균
    //count[i]가 0이 아닌 것들만 더하기
    static int average(int[] count, int N) {
        int sum = 0;
        
        for (int i = 0; i < MAX; i++)
            sum += count[i] * (i - 4000);
        
        return (int) Math.round((double)sum / (double)N);
    }
    
    //중앙값
    //입력된 값 = count배열의 인덱스 - 4000, count배열에 오름차순대로 저장됨
    static int mid(int[] count, int N) {
        int cnt = 0, i;
        for (i = 0; i < MAX; i++) {
            //count 배열 안에는 입력한 숫자 - 4000가 얼마나 있는지가 들어있음
            //오름차순대로 숫자를 몇 개 입력했는지 누적하여 더하기
            cnt += count[i];
            
            //누적하여 더한 숫자가 중앙값 인덱스(N/2)를 넘으면 빠져나오기
            if (cnt > N / 2) break;
        }
        
        return i - 4000;
    }
    
    //최빈값
    static int mostNum(int[] count, int N) {
        int most = 0, result = 0;    //최빈값
        
        //최빈값 구하기
        int i, j;
        for (i = 0; i < MAX; i++) {
            if (most < count[i]) most = count[i];
        }
        
        //첫 번째 최빈값 구하기
        for (i = 0; i < MAX; i++) {
            if (most == count[i]) {
                result = i - 4000;
                break;
            }
        }
        
        //두 번째 최빈값 구하기
        for (j = i + 1; j < MAX; j++) {
            if (most == count[j]) {
                result = j - 4000;
                break;
            }
        }
        
        return result;
    }
    
    //범위
    static int range(int[] count, int N) {
        int min = 0, max = 0;
        
        //최솟값 구하기
        for (int i = 0; i < MAX; i++) {
            if (count[i] != 0)  {
                min = i - 4000;
                break;
            }
        }
        
        //최댓값 구하기
        for (int i = MAX - 1; i >= 0; i--) {
            if (count[i] != 0) {
                max = i - 4000;
                break;
            }
        }
        
        return max - min;
    }
}
