import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int arr_size1 = Integer.parseInt(br.readLine());
        int[] arr1 = new int[arr_size1];
        StringTokenizer st1 = new StringTokenizer(br.readLine()," ");
        int arr_size2 =Integer.parseInt(br.readLine());
        int[] arr2 = new int[arr_size2];
        StringTokenizer st2 = new StringTokenizer(br.readLine()," ");

        for(int i = 0; i < arr1.length; i++)
            arr1[i] = Integer.parseInt(st1.nextToken());

        for(int i = 0; i < arr2.length; i++)
            arr2[i] = Integer.parseInt(st2.nextToken());

        IntStream intStream1 = Arrays.stream(arr1);
        IntStream intStream2 = Arrays.stream(arr2);
        IntStream result = IntStream.concat(intStream1, intStream2).sorted();

        result.forEach(x->System.out.print(x + " "));
    }
}