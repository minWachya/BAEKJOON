import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());    //전체 사람 수
        
        int[][] size = new int[N][2];    //size[몸무게][키]
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            size[i][0] = Integer.parseInt(st.nextToken());
            size[i][1] = Integer.parseInt(st.nextToken());
        }
        br.close();
        
        int[] number = new int[N];    //순위 저장하는 배열
        for (int i = 0; i < N; i++) {
            int index = 1;
            for (int j = 0; j < N; j++) {
                //자기(i)보다 덩치 큰 사람(j)이 몇 명 있는지 index에 저장
                if (size[i][0] < size[j][0] && size[i][1] < size[j][1])
                    index++;
            }
            number[i] = index;
        }
        
        for (int i = 0; i < N; i++)
            System.out.print(number[i] + " ");
    }
}
