import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(String s) {
        Set<String> set = new HashSet<>();
        String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
        Arrays.sort(arr, (a, b) -> a.length() - b.length());
        int[] answer = new int[arr.length];
        int idx = 0;
        for (String s1 : arr) {
            for (String s2 : s1.split(",")) {
                System.out.print(s2 + " ");
                if (set.add(s2)) answer[idx++] = Integer.parseInt(s2); // set 컬렉션에 이미 요소가 있으면 false 반환
            }
            System.out.println();
        }
        return answer;
    }
}