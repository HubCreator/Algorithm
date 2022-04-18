import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size1 = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        int[] arr1 = new int[size1];
        int size2 = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        int[] arr2 = new int[size2];

        for(int i = 0; i < size1; i++)
            arr1[i] = Integer.parseInt(st1.nextToken());
        for(int i = 0; i < size2; i++)
            arr2[i] = Integer.parseInt(st2.nextToken());


        Arrays.sort(arr1);
        Arrays.sort(arr2);
        ArrayList<Integer> answer = new ArrayList<>();
        int p1 = 0, p2 = 0;

        while(p1 < size1 && p2 < size2) {
            if(arr1[p1] == arr2[p2]) {
                answer.add(arr1[p1++]);
                p2++;
            }
            else if(arr1[p1] < arr2[p2])
                p1++;
            else
                p2++;
        }

        answer.stream().forEach(x -> System.out.print(x + " "));
    }
}