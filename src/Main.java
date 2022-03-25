import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder(str).reverse();

        if(!str.equalsIgnoreCase(sb.toString())) {
            System.out.println("NO");
        } else
            System.out.println("YES");
    }
}