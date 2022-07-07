
class Solution {
    public String solution(String new_id) {
        String answer = "";
        String temp = new_id.toLowerCase(); // 1 단계 - 소문자로 변환

        temp = temp.replaceAll("[^-_.a-z0-9]", ""); // 2 단계 - 숫자, 알파벳, 특정 기호를 제외하고 제거

        temp = temp.replaceAll("[.]{2,}", "."); // 3 단계 - 연속된 '.'을 제거

        temp = temp.replaceAll("^[.]|[.]$", ""); // 4 단계 - 처음과 끝에 '.'을 제거

        if (temp.equals("")) // 5 단계 - 빈 문자열이면 a를 추가
            temp += "a";

        if (temp.length() >= 16) { // 6 단계 - 길이가 16 이상이면 16 이후의 수를 제거, 제거한 이후에 끝자리가 '.'이면 제거
            temp = temp.substring(0, 15);
            temp = temp.replaceAll("^[.]|[.]$", "");
        }

        if (temp.length() <= 2) // 7 단계 - 길이가 2 이하라면, 마지막 문자를 길이가 3까지 반복하여 길이를 늘림
            while (temp.length() < 3)
                temp += temp.charAt(temp.length() - 1);

        answer = temp;
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution("=.="));
    }
}