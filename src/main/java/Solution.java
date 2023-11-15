class Solution {

    public int solution(int[] arr) {
        int answer = 1, max = 1;
        for (int e : arr) {
            max = Math.max(max, e);
        }

        for (int i = max; i >= 2; i--) {
            boolean flag = false;
            int count = 0;
            for (int num : arr) {
                if (count > 1) {
                    flag = true;
                    break;
                }
                if (num % i == 0) {
                    count++;
                }
            }
            if (flag || count > 1) {
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j] % i == 0) {
                        arr[j] /= i;
                    }
                }
                answer *= i;
            }
        }

        for (int num : arr) {
            answer *= num;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution(new int[]{4, 4});
        System.out.println("result = " + result);
    }
}