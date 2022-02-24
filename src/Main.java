import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");

        int S = Integer.parseInt(st1.nextToken());
        int N = Integer.parseInt(st1.nextToken());
        int[] arr = new int[N];
        LinkedList<Integer> answer = new LinkedList<>();

        for(int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(st2.nextToken());

        for(int i = 0; i < arr.length; i++) {
            if(answer.size() < S) {
                if(!answer.contains(arr[i]))
                    answer.push(arr[i]);
                else
                    answer.push(answer.remove(answer.indexOf(arr[i])));
            }
            else {
                if(!answer.contains(arr[i])) {
                    answer.remove(answer.size()-1);
                    answer.push(arr[i]);
                }
                else
                    answer.push(answer.remove(answer.indexOf(arr[i])));
            }
        }
        answer.forEach(x->System.out.print(x + " "));
    }
}