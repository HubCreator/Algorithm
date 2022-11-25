import java.util.*;

class Solution {
    Map<String, Integer> map;
    Set<String> entry;

    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        makeEntry(orders, course);
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() >= 2) {
                answer.add(e.getKey());
            }
        }
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() >= 2) {
                System.out.println(e.getKey() + " / " + e.getValue());
            }
        }
        Collections.sort(answer);

        return answer.toArray(new String[0]);
    }


    private void makeEntry(String[] orders, int[] course) {
        entry = new TreeSet<>();
        map = new HashMap<>();
        int tmp = 0;
        for (String order : orders) {
            for (int i = 0; i < (1 << order.length()); i++) {
                char[] buffer = new char[order.length()];
                int idx = 0;
                for (int j = 0; j < order.length(); j++) {
                    if ((i & (1 << j)) != 0 && idx < order.length()) {
                        buffer[idx++] = order.charAt(j);
                    }
                }
                String trim = new String(buffer).trim();
                for (int j = course.length - 1; j > 0; j--) {
                    if (trim.length() == course[j]) {
                        Set<String> keySet = map.keySet();
                        boolean flag = true;
                        for (String s : keySet) {
                            if (!s.equals(trim) && s.contains(trim)) {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            map.put(trim, map.getOrDefault(trim, 0) + 1);
                            entry.add(trim);
                        }
                    }
                }
            }
            tmp++;
        }

    }


    public static void main(String[] args) {
        Solution T = new Solution();
        for (String s : T.solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4})) {
//            System.out.println("s = " + s);
        }
    }
}