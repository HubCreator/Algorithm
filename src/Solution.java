import java.util.*;

class Solution {
    int[] ch;
    List<Character> list = new ArrayList<>();
    List<String> entry = new ArrayList<>();

    private void dfs(int L, int s) {
        if (L == ch.length) {
            StringBuilder sb = new StringBuilder();
            for (int x : ch) sb.append(list.get(x));
            entry.add(sb.toString());
        } else {
            for (int i = s; i < list.size(); i++) {
                ch[L] = i;
                dfs(L + 1, i + 1);
            }
        }
    }

    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        List<Integer> courseList = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (int x : course) courseList.add(x);
        Arrays.sort(orders);
        for (String order : orders)
            for (int i = 0; i < order.length(); i++)
                if (list.isEmpty() || !list.contains(order.charAt(i)))
                    list.add(order.charAt(i));

        for (int i : course) {
            ch = new int[i];
            entry.clear();
            map.clear();
            dfs(0, 0);

            for (String e : entry) {
                String[] split = e.split("");
                Arrays.sort(split);
                String join = String.join("", split);

                for (String order : orders) {
                    if(join.equals(order)) continue;
                    boolean flag = true;
                    for (String s : split) {
                        if (!order.contains(s)) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) map.put(join, map.getOrDefault(join, 0) + 1);
                }
            }
            if (map.isEmpty()) continue;
            int max = Collections.max(map.values());
            for (Map.Entry<String, Integer> e : map.entrySet()) {
                if (e.getValue().equals(max) && courseList.contains(e.getValue())) answer.add(e.getKey());
            }
        }

        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        String[] arr1 = {"XYZ", "XWY", "WXA"};
        int[] arr2 = {2, 3, 4};
        for (String s : T.solution(arr1, arr2)) {
            System.out.println("s = " + s);
        }
    }
}