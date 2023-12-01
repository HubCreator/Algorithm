import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    private static final Pattern PATTERN = Pattern.compile("\\{(.*?)\\}");

    public int[] solution(String s) {
        String substring = s.substring(1, s.length() - 1);
        List<String> result = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();
        Matcher matcher = PATTERN.matcher(substring);
        while (matcher.find()) {
            result.add(matcher.group(1));
        }
        Collections.sort(result, (a, b) -> a.length() - b.length());
        for (String line : result) {
            String[] split = line.split(",");
            for (String sp : split) {
                int t = Integer.parseInt(sp);
                if (answer.isEmpty() || !answer.contains(t)) {
                    answer.add(t);
                }
            }
        }
        return answer.stream().mapToInt(m -> m).toArray();
    }
}
