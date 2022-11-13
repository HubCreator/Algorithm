import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static StringBuilder answer = new StringBuilder();
    static StringTokenizer st;
    static int[] arr = new int[100];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int test_case = 1; test_case <= 10; test_case++) {
            answer.append("#").append(test_case).append(" ");

            int dumCnt = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int len = st.countTokens();
            for (int i = 0; i < len; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < dumCnt; i++) {
                arr[minIdx()]++;
                arr[maxIdx()]--;
            }
            answer.append(arr[maxIdx()] - arr[minIdx()]).append("\n");
        }
        System.out.println(answer);
    }

    private static int maxIdx() {
        int maxIdx = 0;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
                maxIdx = i;
            }
        }
        return maxIdx;
    }

    private static int minIdx() {
        int minIdx = 0;
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minValue) {
                minValue = arr[i];
                minIdx = i;
            }
        }
        return minIdx;
    }
}