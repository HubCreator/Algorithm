import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static List<String> answer = new ArrayList<>();
    public static int[][] cache = new int[101][101];

    private static int match(String W, String S, int w, int s) {
        // 메모이제이션
        if (cache[w][s] != -1) return 1;
        // W[w]와 S[s]를 맞춰 나간다
        while (s < S.length() && w < W.length() &&
                (W.charAt(w) == '?' || W.charAt(w) == S.charAt(s))) {
            ++w;
            ++s;
        }
        // 더이상 대응할 수 없으면 왜 while문이 끝났는지 확인
        // 2. 패턴 끝에 도달해 끝난 경우 : 문자열도 끝났어야 함
        if (w == W.length()) return cache[w][s] = s == S.length() ? 1 : 0;
        // 4. *를 만나서 끝난 경우 : *에 몇 글자를 대응해야 할지 재귀 호출하면서 확인
        if (W.charAt(w) == '*') {
            for (int skip = 0; skip + s < S.length(); skip++) {
                if (match(W, S, w + 1, s + skip) == 1) {
                    return cache[w][s] = 1;
                }
            }
        }
        // 3. 이외의 경우에는 모두 대응되지 않는다
        return cache[w][s] = 0;
    }

    private static void initCache() {
        for (int[] ints : cache) {
            Arrays.fill(ints, -1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < totalCnt; i++) {
            String target = br.readLine();
            int cnt = Integer.parseInt(br.readLine());
            for (int j = 0; j < cnt; j++) {
                initCache();
                String S = br.readLine();
                if (match(target, S, 0, 0) == 1) {
                    answer.add(S);
                }
            }
        }

        for (String s : answer) {
            System.out.println(s);
        }
    }
}