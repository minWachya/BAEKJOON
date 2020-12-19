import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());    // N 입력
        String[] str = new String[n];
        
        for (int i = 0; i < n; i++) 
            str[i] = br.readLine();
        br.close();
        
        // 정렬 (사전순)
        Arrays.sort(str);
        
        // 정렬 (길이순)
        Arrays.sort(str, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return Integer.compare(o1.length(), o2.length());
			}
        });
        
        // 출력
        StringBuilder sb = new StringBuilder();
		
		    sb.append(str[0]).append('\n');
        for (int i = 1; i < n; i++) {
            if (str[i - 1].equals(str[i])) continue;
            sb.append(str[i]).append('\n');
        }
        System.out.println(sb);
    }
}
