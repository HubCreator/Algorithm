class Solution {
    public long solution(int r1, int r2) {
        long answer = 0, intersect = 0;
        int max = Math.max(r1, r2);
        int min = Math.min(r1, r2);
        double max2 = Math.pow(max, 2);
        double min2 = Math.pow(min, 2);


        for (int i = 0; i <= max; i++) {
            for (int j = 0; j <= max; j++) {
                double x = Math.pow(i, 2);
                double y = Math.pow(j, 2);
                if (x + y <= max2) {
                    answer++;

                    if (i == 0 || j == 0) {
                        intersect++;
                    }
                }

            }
        }
        System.out.println(answer - 1);

        return (long) answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(0, 10);
    }
}

// 2 -> 5 -> 10 -> 16 -> 25 -> 34 -> 44 -> 57 -> 72 -> 89
//  +3   +5    +6   +9     +9    +10    +13   +20   + 17
//   +2    +1    +3   +0
