import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String tmp = br.readLine();
        char answer = ' ';

        HashMap<Character, Integer> map = new HashMap<>();
        for(char x : tmp.toCharArray())
            map.put(x, map.getOrDefault(x, 0)+1); // 해당 value가 없다면 0 반환

        int max = Integer.MIN_VALUE;
        for(char key : map.keySet()) { // keySet() -> 존재하는 키들을 모두 순회
            /*System.out.println(key + " " + map.get(key));*/
            if(map.get(key) > max) {
                max = map.get(key);
                answer = key;
            }
        }

        System.out.println(answer);
    }
}