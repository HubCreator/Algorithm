import java.util.*;

class User {
    String uid, action;

    public User(String uid, String action) {
        this.uid = uid;
        this.action = action;
    }
}

class Solution {
    private static final String IN = "님이 들어왔습니다.";
    private static final String OUT = "님이 나갔습니다.";

    public String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        List<User> list = new LinkedList<>();
        for (String s : record) {
            String[] split = s.split(" ");
            if (split[0].startsWith("L")) {
                list.add(new User(split[1], split[0]));
            } else if (split[0].startsWith("C")) {
                map.put(split[1], split[2]);
            } else {
                map.put(split[1], split[2]);
                list.add(new User(split[1], split[0]));
            }
        }
        for (User user : list) {
            if (user.action.startsWith("E"))
                answer.add(new StringBuilder(map.get(user.uid)).append(IN).toString());
            else answer.add(new StringBuilder(map.get(user.uid)).append(OUT).toString());
        }

        return answer.toArray(new String[0]);
    }
}