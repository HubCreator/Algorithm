
class Point {
    int x, y;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        Point left = new Point(3, 0);
        Point right = new Point(3, 2);
        int[][] board = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {-1, 0, -1}
        };

        for (int n : numbers) {
            for (int y = 0; y < 4; y++) { // board를 돌면서
                for (int x = 0; x < 3; x++) {
                    if (board[y][x] == n) {
                        Point t = new Point(y, x);
                        if (x == 0) { // left
                            answer.append("L");
                            left = t;
                        } else if (x == 2) { // right
                            answer.append("R");
                            right = t;
                        } else { // middle
                            // 가까운 손을 비교해야 함
                            int l = Math.abs(left.x - t.x) + Math.abs(left.y - t.y);
                            int r = Math.abs(right.x - t.x) + Math.abs(right.y - t.y);
                            if (l < r) {
                                answer.append("L");
                                left = t;
                            } else if (l > r) {
                                answer.append("R");
                                right = t;
                            } else {
                                if (hand.equals("left")) {
                                    answer.append("L");
                                    left = t;
                                } else {
                                    answer.append("R");
                                    right = t;
                                }
                            }
                        }
                    }
                }
            }
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "left";
        System.out.println(T.solution(numbers, hand).equals("LRLLRRLLLRR") ? "YES" : "NO");

    }
}