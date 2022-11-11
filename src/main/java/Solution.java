import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static StringBuilder t;
    static HashSet<Integer> visited;
    static int result;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine());

            char[] chArr = st.nextToken().toCharArray();
            K = Integer.parseInt(st.nextToken());

            int[] nums = new int[chArr.length];
            for (int i = 0; i < chArr.length; i++) {
                nums[i] = chArr[i] - '0';
            }

            visited = new HashSet<>();
            result = 0;

            dfs(nums, 0);

            answer.append("#").append(testCase).append(" ").append(result).append("\n");
        }
        System.out.println(answer);
    }

    private static void dfs(int[] nums, int count) {
        int r = parseInt(nums);

        if (count == K) { // K = 총 교환 횟수
            result = Math.max(result, r); // 최댓값을 갱신
            return;
        }

        if (visited.contains(r)) return; // 일종의 메모이제이션, 캐시 히트

        visited.add(r); // 캐시 미스

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int[] nNum = swap(nums.clone(), i, j);
                dfs(nNum, count + 1);
            }
        }
    }

    private static int parseInt(int[] nums) {
        t = new StringBuilder();
        for (int num : nums) {
            t.append(num);
        }
        return Integer.parseInt(t.toString());
    }

    private static int[] swap(int[] nNum, int i, int j) {
        int tmp = nNum[i];
        nNum[i] = nNum[j];
        nNum[j] = tmp;
        return nNum;
    }
}