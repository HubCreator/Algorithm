import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine()+" ";
        StringBuilder sb = new StringBuilder();

        int cnt = 1;
        for(int i = 0; i < str.length()-1; i++) {
            if(str.charAt(i) == str.charAt(i+1))
                cnt++;
            else {
                sb.append(str.charAt(i));
                if(cnt > 1) sb.append(cnt);
                cnt = 1;
            }
        }

        System.out.println(sb);
    }
}