import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

/*
<버블 정렬>
요소가 n개인 배열에서 왼쪽으로 n-1회 비교, 교환

ex) 요소가 5개인 5 4 1 2 3 을 오름차순 정렬하기(n=5)
※<>는 비교하여 순서 바꾸기
-첫 번째(5-1번 비교)                -두 번째(5-2번 비교)
5 4 1 2<>3    =>    5 4 1 2 3        1 5 4 2<>3    =>    1 5 4 2 3
5 4 1<>2 3    =>    5 4 1 2 3        1 5 4<>2 3    =>    1 5 2 4 3
5 4<>1 2 3    =>    5 1 4 2 3        1 5<>2 4 3    =>    1 2 5 4 3
5<>1 4 2 3    =>    1 5 4 2 3
*/

public class Main {
    static int[] num;
    
    static void bubble(int[] num, int n) {
        //요소가 n개인 배열에서 왼쪽으로 n-1회 비교, 교환
        for (int i = 0; i < n-1; i++) {
            //왼쪽으로 이동해야하니 j = n-1부터 시작하여 점점 작아짐
            for (int j = n-1; j > i; j--) {
                //맨 왼쪽 요소(j)와 그 앞의 요소(j-1) 비교하여 정렬
                if (num[j-1] > num[j])
                    swap(j-1, j);
            }
        }
    }
    
    static void swap(int a, int b) {
        int temp = num[a];
        num[a] = num[b];
        num[b] = temp;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        num = new int[N];    //요소가 N개인 int형 배열을 생성
        
        //숫자 입력
        for (int i = 0; i < N; i++)
            num[i] = Integer.parseInt(br.readLine());
        br.close();
        
        //오름차순 정렬(버블 정렬)
        bubble(num, N);
        
        //출력
        for (int i = 0; i < N; i++)
            bw.write(num[i] + "\n");
        bw.flush();
        bw.close();
    }
}
