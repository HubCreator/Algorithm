import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Base64;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            System.out.println("#" + t + " " + new String(Base64.getDecoder().decode(br.readLine())));
        }
    }
}