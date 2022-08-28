import java.util.ArrayList;
import java.util.List;

class User {
    int y, x;

    public User(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

class Solution {
    int board_size;

    private boolean isValid(String[] place, User u1, User u2) {
        boolean flag = false;
        if (u1.y == u2.y || u1.x == u2.x) {
            for (int i = Math.min(u1.y, u2.y); i <= Math.max(u1.y, u2.y); i++) {
                for (int j = Math.min(u1.x, u2.x); j <= Math.max(u1.x, u2.x); j++) {
                    if (place[i].charAt(j) == 'X') {
                        return true;
                    }
                }
            }
        } else {
            int cnt = 0;
            for (int i = Math.min(u1.y, u2.y); i <= Math.max(u1.y, u2.y); i++) {
                for (int j = Math.min(u1.x, u2.x); j <= Math.max(u1.x, u2.x); j++) {
                    if (place[i].charAt(j) == 'X') cnt++;
                }
            }
            return cnt == 2;
        }
        return flag;
    }

    public int[] solution(String[][] places) {
        board_size = places.length;
        int[] answer = new int[board_size];
        int idx = 0;
        List<User> list = new ArrayList<>();
        boolean flag;

        for (String[] place : places) {
            list.clear();
            flag = true;
            for (int i = 0; i < place.length; i++) {
                for (int j = 0; j < place[i].length(); j++) {
                    if (place[i].charAt(j) == 'P') list.add(new User(i, j));
                }
            }
            Loop1:
            for (int i = 0; i < list.size() - 1; i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    int dist = Math.abs(list.get(i).y - list.get(j).y) + Math.abs(list.get(i).x - list.get(j).x);
                    if (dist < 2) {
                        flag = false;
                        break Loop1;
                    } else if (dist == 2) {
                        if (!isValid(place, list.get(i), list.get(j))) {
                            flag = false;
                            break Loop1;
                        }
                    }
                }
            }
            if (flag) answer[idx] = 1;
            idx++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        String[][] arr = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };
        for (int x : T.solution(arr)) System.out.print(x + " ");
    }
}