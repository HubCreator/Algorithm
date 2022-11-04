class Solution {

    private int dfs(int[] arr, int idx) {
        int sum = arr[idx];
        arr[idx] = -1; // 해당 인덱스는 -1 표시

        // 양 옆의 인덱스도 -1 표시
        if (idx == 0) {
            arr[arr.length - 1] = -1;
            arr[idx + 1] = -1;
        } else if (idx == arr.length - 1) {
            arr[idx - 1] = -1;
            arr[0] = -1;
        } else {
            arr[idx - 1] = -1;
            arr[idx + 1] = -1;
        }

        int tmp = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != -1) {
                tmp = Math.max(tmp, dfs(arr.clone(), i));
            }
        }
        if (tmp != Integer.MIN_VALUE) sum += tmp;
        return sum;
    }

    public int solution(int sticker[]) {
        // 짝수개일 경우
        if (sticker.length % 2 == 0) {
            int even = 0, odd = 0;
            for (int i = 0; i < sticker.length; i++) {
                if (i % 2 == 0) even += sticker[i];
                else odd += sticker[i];
            }
            return Math.max(even, odd);
        }

        // 홀수개일 경우
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < sticker.length; i++) {
            answer = Math.max(answer, dfs(sticker.clone(), i));
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int[] arr = {1, 3, 2, 5, 4};
        System.out.println(T.solution(arr));
    }
}