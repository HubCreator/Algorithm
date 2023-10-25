import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(String str1, String str2) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> union = new ArrayList<>();
        List<String> intersection = new ArrayList<>();

        init(str1.toUpperCase(), list1);
        init(str2.toUpperCase(), list2);

        for (String s : list1) {
            if (list2.remove(s)) {
                intersection.add(s);
            }
            union.add(s);
        }
        for (String s : list2) {
            union.add(s);
        }

        double similarity;
        if (union.size() == 0) {
            similarity = 1;
        } else {
            similarity = (double) intersection.size() / (double) union.size();
        }
        return (int) (similarity * 65536);
    }

    private void init(String str1, List<String> list) {
        for (int i = 0; i < str1.length() - 1; i++) {
            char c1 = str1.charAt(i);
            char c2 = str1.charAt(i + 1);
            if (Character.isAlphabetic(c1) && Character.isAlphabetic(c2)) {
                String t = c1 + "" + c2;
                list.add(t);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("aa1+aa2", "AAAA12"));
    }
}
