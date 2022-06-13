import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// 모든 아나그램 찾기 (해시, 투포인터, 슬라이딩윈도우), 대소문자 구분, 부분 문자열은 연속되어야 함
public class Main {
    private int solution(String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int answer = 0, lt = 0;
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> target = new HashMap<>();


        for (char c : chars2) {
            window.put(c, window.getOrDefault(c, 0) + 1);
        }
        for (int rt = 0; rt < chars2.length - 1; rt++) { // 초기 윈도우값
            target.put(chars1[rt], target.getOrDefault(chars1[rt], 0) + 1);
        }
        for (int rt = chars2.length - 1; rt < chars1.length; rt++) {
            target.put(chars1[rt], target.getOrDefault(chars1[rt], 0) + 1);
            if (window.equals(target)) answer++;
            target.put(chars1[lt], target.get(chars1[lt]) - 1);
            if (target.get(chars1[lt]) == 0) target.remove(chars1[lt]);
            lt++;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        System.out.println(T.solution(str1, str2));
    }
}