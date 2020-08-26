import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        List<Point> point = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        
        //입력
        int x, y;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            point.add(new Point(x, y));
        }
        br.close();
        
        //정렬
        Collections.sort(point);
       
        //출력
        for (Point p : point)
            bw.write(p + "\n");
        bw.flush();
        bw.close();
    }
}

class Point implements Comparable<Point> {
    int x, y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public int compareTo(Point p){
        //x값이 같을 때 this.y가 크면 1 리턴, p.y가 크면 -1, y값도 같으면 0 리턴
        if (this.x == p.x) return this.y > p.y ? 1 : (this.y < p.y ? -1 : 0);
        //this.x가 크면 1 리턴, p.x가 크면 -1 리턴
        else return this.x > p.x ? 1 : -1;
    }
    @Override
    public String toString() {
        return x + " " + y;
    }
    
}
