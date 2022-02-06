import java.io.*;

public class Main {
    public static int[] fibo;
    public static int recursive(int n) {
        if (n == 1) return fibo[n] = 1;
        else if (n == 2) return fibo[n] = 1;
        else return fibo[n] = recursive(n-2) + recursive(n-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        fibo = new int[n+1];

        recursive(n);
        for(int i = 1; i <= n; i++)
            System.out.print(fibo[i] + " ");
    }
}