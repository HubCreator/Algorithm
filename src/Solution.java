import java.util.ArrayList;
import java.util.List;

class Person {
    String lang, area, role, favor;
    int score;

    public Person(String lang, String area, String role, String favor, int score) {
        this.lang = lang;
        this.area = area;
        this.role = role;
        this.favor = favor;
        this.score = score;
    }

    public boolean isFulfilled(String lang, String area, String role, String tmp) {
        String favor = tmp.split(" ")[0];
        int score = Integer.parseInt(tmp.split(" ")[1]);

        if (score > this.score) return false;
        if (!lang.equals("-") && !lang.equals(this.lang)) return false;
        if (!area.equals("-") && !area.equals(this.area)) return false;
        if (!role.equals("-") && !role.equals(this.role)) return false;
        if (!favor.equals("-") && !favor.equals(this.favor)) return false;

        return true;
    }
}

class Solution {
    List<Person> people;

    public int[] solution(String[] info, String[] query) {
        people = new ArrayList<>();
        int[] answer = new int[query.length];
        for (String s : info) {
            String[] arr = s.split(" ");
            people.add(new Person(arr[0], arr[1], arr[2], arr[3], Integer.parseInt(arr[4])));
        }

        for (int i = 0; i < query.length; i++) {
            String[] arr = query[i].split(" and ");
            int cnt = 0;
            for (Person p : people) {
                if (p.isFulfilled(arr[0], arr[1], arr[2], arr[3])) cnt++;
            }
            answer[i] = cnt;
        }
        return answer;
    }
}