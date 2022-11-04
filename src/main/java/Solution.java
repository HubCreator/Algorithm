import java.util.Arrays;

class Solution {
    int result = 0;

    public int solution(int sticker[]) {
        if (sticker.length == 1) {
            return sticker[0];
        }
        int[] ch = new int[sticker.length];
        Arrays.fill(ch, -1);
        dfs(sticker, 0, ch.clone());
        dfs(sticker, 1, ch.clone());

        return result;
    }

    private void dfs(int[] arr, int idx, int[] ch) {
        if (idx == arr.length) {
            int total = 0;
            for (int i = 0; i < ch.length; i++) {
                if (ch[i] == 1) {
                    total += arr[i];
                }
            }
            result = Math.max(result, total);
            return;
        }

        if (ch[idx] == 0) return;

        if (idx == 0) {
            ch[ch.length - 1] = 0;
        } else if (idx == 1) {
            ch[idx + 1] = 0;
        }

        ch[idx] = 1;
        if (idx + 1 < arr.length) ch[idx + 1] = 0;

        for (int i = idx + 1; i <= arr.length; i++) {
            dfs(arr, i, ch.clone());
        }
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int[] arr = {14, 6, 5, 11, 3, 9, 2, 10};
        System.out.println(T.solution(arr));
    }
}