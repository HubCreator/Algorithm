import java.util.*;

class Solution {
    Map<Integer, List<Character>> map;
    List<Character> elements;
    Set<String> entry, answer;

    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        initialize(orders);
        makeEntry(course);


        return new String[]{};
    }


    private void makeEntry(int[] course) {
        entry = new TreeSet<>();
        for (int len : course) {
            for (int i = 0; i < (1 << elements.size()); i++) {
                char[] buffer = new char[len];
                int idx = 0;
                for (int j = 0; j < elements.size(); j++) {
                    if ((i & (1 << j)) != 0 && idx < len) {
                        buffer[idx++] = elements.get(j);
                    }
                }
                if (idx == len) {
                    Arrays.sort(buffer);
                    entry.add(new String(buffer));
                }
            }
        }
    }

    private void initialize(String[] orders) {
        map = new HashMap<>();
        elements = new ArrayList<>();
        for (int i = 0; i < orders.length; i++) {
            String order = orders[i];
            List<Character> tmp = new ArrayList<>();
            for (int j = 0; j < order.length(); j++) {
                tmp.add(order.charAt(j));
                if (elements.isEmpty() || !elements.contains(order.charAt(j))) {
                    elements.add(order.charAt(j));
                }
            }
            map.put(i, tmp);
        }
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        for (String s : T.solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4})) {
            System.out.println("s = " + s);
        }
    }
}