import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    static int[] count = new int[8001];    //최빈값을 찾기 위한 배열(count[num[i]]++)
    
    //최빈값 구하는 함수
    static int mostNum(int max, int min) {
        int most = 0, index = 0;      //최빈값과 그때의 인덱스
        int flag = 0;                 //최빈값이 몇 개인지
       
        for (int i = min; i <= max; i++) {
            if (most < count[i]) {
                most = count[i];    //최빈값 수정
                flag = 0;           //최초 최빈값
                index = i;          //최초 최빈값의 인덱스
            }
            else if (most == count[i]) {
                flag++;
                //최댓값이 여러개면 두번째로 작은 값의 인덱스 저장
                if (flag == 1) index = i;
            }
        }
        
        return index - 4000;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];    //숫자를 입력할 배열
        
        //숫자 입력
        int sum = 0;
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(br.readLine());
            sum += num[i];            //숫자 합 구하기
            count[num[i] + 4000]++;   //숫자 출현 빈도 구하기, 음수도 있으니 + 4000(ㅣ값ㅣ <= 4000)
        }
        br.close();
        
        //오름차순 정렬
        Arrays.sort(num);
        
        //최빈값 구하기
        int max = num[N-1] + 4000;    //num 배열의 최댓값이 저장된 count 배열의 인덱스
        int min = num[0] + 4000;      //num 배열의 최솟값이 저장된 count 배열의 인덱스
        int index = mostNum(max, min);
        
        //출력
        bw.write(Math.round((double)sum / (double)N) + "\n");  //산술 평균
        bw.write(num[N / 2] + "\n");                           //중앙값
        bw.write(index+ "\n");                                 //최빈값
        bw.write(num[N - 1] - num[0] + "\n");                  //범위(최대 - 최소)
        bw.flush();
        bw.close();
    }
}
