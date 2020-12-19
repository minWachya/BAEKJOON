import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder[] sb = new StringBuilder[201];    // 1 <= 나이 <= 200
        
        int n = Integer.parseInt(br.readLine());	// n 입력

        for(int i = 0; i < 201; i++)    // sb 초기화
            sb[i] = new StringBuilder();
        
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");	// 나이, 이름 입력받기
            int age = Integer.parseInt(st.nextToken());	// 나이
            sb[age].append(age).append(' ').append(st.nextToken()).append("\n");	// sb[나이]에 나이 + 이름 추가
        }
        
        // 출력
        StringBuilder sb2 = new StringBuilder();
        for(StringBuilder temp : sb)
        	sb2.append(temp);
        System.out.println(sb2);
    }
}
