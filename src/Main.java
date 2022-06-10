import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public List<Integer> solution(int n1, int[] arr1, int n2, int[] arr2) {
        List<Integer> result = new ArrayList<>();
        int p1 = 0, p2 = 0;
        while (p1 < n1 && p2 < n2) { // 둘 중 하나라도 오버되면 break
            boolean b = arr1[p1] < arr2[p2] ?
                    result.add(arr1[p1++]) :
                    result.add(arr2[p2++]);
        }
        // 해당 조건을 만족하면 loop
        while(p1 < n1) result.add(arr1[p1++]); // p1이 아직 n1만큼 돌지 않았다면 끝까지 돌려라
        while(p2 < n2) result.add(arr2[p2++]); // p2이 아직 n2만큼 돌지 않았다면 끝까지 돌려라

        return result;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n1 = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        int n2 = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];
        for (int i = 0; i < n1; i++) {
            arr1[i] = Integer.parseInt(st1.nextToken());
        }
        for (int i = 0; i < n2; i++) {
            arr2[i] = Integer.parseInt(st2.nextToken());
        }
        for (int x : T.solution(n1, arr1, n2, arr2)) {
            System.out.print(x + " ");
        }
    }
}