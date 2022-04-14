import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

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

        ArrayList<Integer> answer = new ArrayList<>();
        int p1 = 0, p2 = 0;
        while(p1 < arr_size1 && p2 < arr_size2) {
            if(arr1[p1] > arr2[p2]) {
                answer.add(arr2[p2++]);
            } else {
                answer.add(arr1[p1++]);
            }
        }
        while(p1 < arr_size1) answer.add(arr1[p1++]);
        while(p2 < arr_size2) answer.add(arr2[p2++]);

        answer.forEach(x -> System.out.print(x + " "));
    }
}