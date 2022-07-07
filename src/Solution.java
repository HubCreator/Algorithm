import java.util.List;

class Solution {
    public String solution(String new_id) {
        List<Character> reg = List.of('-', '_', '.');

        String answer = new_id.toLowerCase(); // 1 단계 - 소문자로
        StringBuilder sb = new StringBuilder();
        System.out.println("1 " + answer);

        for (int i = 0; i < answer.length(); i++) { // 2 단계 - 필요없는 특수문자 제거
            char t = answer.charAt(i);
            if (!Character.isDigit(t) && !Character.isAlphabetic(t) && !reg.contains(t))
                answer = answer.replace(t, ' ');
        }
        answer = answer.replaceAll(" ", "");
        System.out.println("2 " + answer);

        answer += " ";
        for (int i = 0; i < answer.length(); i++) { // 3 단계 - '.'을 하나로 압축
            if (answer.charAt(i) == '.' && answer.charAt(i) == answer.charAt(i + 1)) continue;
            sb.append(answer.charAt(i));
        }
        answer = sb.toString().trim();
        sb.delete(0, sb.length());
        System.out.println("3 " + answer);

        if (answer.charAt(0) == '.') { // 4 단계 - 맨 앞, 맨 뒤에 있는 '.' 제거
            answer = answer.substring(1);
        }
        if (answer.length() > 1 && answer.charAt(answer.length() - 1) == '.') {
            answer = answer.substring(0, answer.length() - 1);
        }
        System.out.println("4 " + answer);

        if (answer.length() == 0) answer = "a"; // 5 단계
        System.out.println("5 " + answer);


        if (answer.length() > 15) answer = answer.substring(0, 15).trim(); // 6 단계
        if (answer.length() > 1 && answer.charAt(answer.length() - 1) == '.') {
            answer = answer.substring(0, answer.length() - 1);
        }


        System.out.println("6 " + answer);


        if (answer.length() <= 2) { // 7 단계
            sb.append(answer);
            while (sb.length() < 3) {
                sb.append(answer.charAt(answer.length() - 1));
            }
            answer = sb.toString();
        }
        System.out.println("7 " + answer);

        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution("=.="));
    }
}