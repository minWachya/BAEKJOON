import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();
        
        //665에서 1씩 증가하며 666있는지 확인
        //number를 문자열로 바꾸고 "666" 포함하는지 확인
        int index = 0;    //666 발견하면 ++하여 몇 번째 종말의 숫자인지 세기
        int number = 665;
        
        while (index != N) {    //N번째 종말의 숫자를 발견할 때까지
            number++;
            String temp = Integer.toString(number);
        
            if (temp.contains("666")) index++;
        }
        System.out.println(number);
        
    }
}
