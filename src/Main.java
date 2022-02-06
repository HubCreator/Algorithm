import java.io.*;

public class Main {
    public static int recursive(int n) {
        if (n == 1) return 1;
        else if (n == 2) return 2;
        else return recursive(n - 2) + recursive(n - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++)
            System.out.print(recursive(i) + " ");
    }
}