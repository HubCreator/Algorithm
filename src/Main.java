import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private int solution(char[] s, char[] t) {
        Map<Character, Integer> target = new HashMap<>();
        Map<Character, Integer> w = new HashMap<>();
        int lt = 0, answer = 0;
        for (int i = 0; i < t.length; i++) { // target 값 설정
            target.put(t[i], target.getOrDefault(t[i], 0) + 1);
        }
        // 슬라이딩 윈도우 초기값 설정
        for (int i = 0; i < t.length - 1; i++) {
            w.put(s[i], w.getOrDefault(s[i], 0) + 1);
        }
        for (int rt = t.length - 1; rt < s.length; rt++) {
            w.put(s[rt], w.getOrDefault(s[rt], 0) + 1); // rt를 늘려
            if(target.equals(w)) answer++; // 아나그램인지 체크
            w.put(s[lt], w.get(s[lt]) - 1); // 다음 w 구성을 위해 lt의 요소 값을 제거
            if(w.get(s[lt]) == 0) w.remove(s[lt]); // 제거했는데 value가 0이면 key도 제거
            lt++; // lt 하나 증가
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();
        System.out.println(T.solution(s.toCharArray(), t.toCharArray()));
    }
}