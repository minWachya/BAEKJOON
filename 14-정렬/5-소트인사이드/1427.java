import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        //입력 및 자리수대로 나누기
        String[] num = br.readLine().split("");    br.close();
        
        //내림차순 정렬
        Arrays.sort(num, Collections.reverseOrder());
        
        //출력
        for (String t : num)
            bw.write(t);
        bw.close();
    }
}
