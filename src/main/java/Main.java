import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        String[] arr = new String[t];
        for (int i = 0; i < t; i++) {
            arr[i] = br.readLine();
        }
        int answer = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (check(arr[i], arr[j])) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    private static boolean check(String s1, String s2) {
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            if (!map1.isEmpty() &&
                    map1.containsKey(s1.charAt(i)) &&
                    map1.get(s1.charAt(i)) != s2.charAt(i)) {
                return false;
            }
            if (!map2.isEmpty() &&
                    map2.containsKey(s2.charAt(i)) &&
                    map2.get(s2.charAt(i)) != s1.charAt(i)) {
                return false;
            }
            map1.put(s1.charAt(i), s2.charAt(i));
            map2.put(s2.charAt(i), s1.charAt(i));
        }
        return true;
    }
}
