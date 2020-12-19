import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());    // N 입력
        String[][] members = new String[n][2];
        
        // 입력
        for (int i = 0; i < n; i++) {
        	String[] str = br.readLine().split(" ");
        	members[i][0] = str[0];	// 나이
        	members[i][1] = str[1];	// 이름
        }
        br.close();
        
        // 나이 오름차순 정렬
        Arrays.sort(members, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				int age1 = Integer.parseInt(o1[0]);
				int age2 = Integer.parseInt(o2[0]);
				return Integer.compare(age1, age2);
			}
        });
        
        // 출력
       StringBuilder sb = new StringBuilder();
       for (int i = 0; i < n; i++)
           sb.append(members[i][0] + " " + members[i][1] + '\n');
       System.out.println(sb);
    }
}
