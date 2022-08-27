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
    int idx = 0;
    List<User> list = new ArrayList<>();
    List<Boolean> answerTmp = new ArrayList<>();
    String[][] places;
    int[] ch, answer;

    private boolean isValid(User u1, User u2) {
        boolean answer = false;
        int dist = Math.abs(u1.y - u2.y) + Math.abs(u1.x - u2.x);
        if (dist > 2) return true;
        else {
            for (int i = Math.min(u1.y, u2.y); i <= Math.max(u1.y, u2.y); i++) {
                for (int j = Math.min(u1.x, u2.x); j <= Math.max(u1.x, u2.x); j++) {
                    if (places[idx][i].charAt(j) == 'X') {
                        answer = true;
                        break;
                    }
                }
            }
        }
        return answer;
    }

    private void combi(int L, int s) {
        if (L == 2) {
            User u1 = list.get(ch[0]);
            User u2 = list.get(ch[1]);
            answerTmp.add(isValid(u1, u2));
        } else {
            for (int i = s; i < list.size(); i++) {
                ch[L] = i;
                combi(L + 1, i + 1);
            }
        }
    }

    public int[] solution(String[][] _places) {
        places = _places;
        answer = new int[places.length];
        for (String[] place : places) {
            list.clear();
            answerTmp.clear();
            for (int i = 0; i < place.length; i++) {
                for (int j = 0; j < place[i].length(); j++) {
                    if (place[i].charAt(j) == 'P') list.add(new User(i, j));
                }
            }
            ch = new int[2];
            combi(0, 0);
            answer[idx++] = answerTmp.contains(false) ? 0 : 1;
        }

        return answer;
    }
}