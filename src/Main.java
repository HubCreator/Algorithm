import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node {
    int data;
    Node lt, rt;

    public Node(int val) {
        this.data = val;
        lt = rt = null;
    }
}

public class Main {
    static int num;
    static int[] ch;
    public static void DFS(int L) {
        if(L == num+1) {
            StringBuilder sb = new StringBuilder("");
            for(int i = 0; i <= num; i++)
                if(ch[i] == 1) {
                    sb.append(i);
                    sb.append(" ");
                }
            if(!sb.equals(""))
                System.out.println(sb);
        } else {
            // 사용함
            ch[L] = 1;
            DFS(L+1);
            // 사용하지 않음
            ch[L] = 0;
            DFS(L+1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());
        ch = new int[num+1];
        DFS(1);
    }
}