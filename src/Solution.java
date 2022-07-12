import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = strings.clone();

        Comparator<String> comp = (s1, s2) -> {
            char str1 = s1.charAt(n);
            char str2 = s2.charAt(n);

            if (str1 > str2)
                return 1;
            else if (str1 < str2)
                return -1;
            else
                return 0;
        };

        Arrays.sort(strings);
        Arrays.sort(strings, comp);

        for (int i = 0; i < strings.length; i++)
            answer[i] = strings[i];

        return answer;
    }
}
