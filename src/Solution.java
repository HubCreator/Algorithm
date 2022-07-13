class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        char[][] board = new char[n][n];

        for(int i = 0; i < n; i++) {
            Long t1 = Long.parseLong(Integer.toBinaryString(arr1[i]).toString());
            Long t2 = Long.parseLong(Integer.toBinaryString(arr2[i]).toString());

            final String format = "%0"+n+"d";
            String tmp1 = String.format(format, t1);
            String tmp2 = String.format(format, t2);

            for(int j = 0; j < n; j++) {
                if(tmp1.charAt(j) == '1' || tmp2.charAt(j) == '1') board[i][j] = '#';
                else if(tmp1.charAt(j) == '0' && tmp2.charAt(j) == '0') board[i][j] = ' ';
            }
        }

        for(int i = 0; i < n; i++) {
            answer[i] = new String(board[i]);
        }
        return answer;
    }
}