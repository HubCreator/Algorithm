class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[] str1 = new String[n], str2 = new String[n];
        String format = "%0" + n + "d";
        for (int i = 0; i < n; i++) {
            String s1 = String.format(format, Long.parseLong(Integer.toBinaryString(arr1[i])));
            String s2 = String.format(format, Long.parseLong(Integer.toBinaryString(arr2[i])));

            str1[i] = s1;
            str2[i] = s2;
        }

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (str1[i].charAt(j) == '1' || str2[i].charAt(j) == '1') sb.append(1);
                else sb.append(0);
            }
            answer[i] = sb.toString().replaceAll("1", "#").replaceAll("0", " ");
        }
        return answer;
    }
}