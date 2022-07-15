class Solution {
    public String solution(String s) {
        char[] arr = s.toCharArray();
        int tmp = 0;
        for(int i = 0; i < arr.length; i++) {
            if(tmp % 2 == 0) arr[i] = Character.toUpperCase(arr[i]);
            else arr[i] = Character.toLowerCase(arr[i]);
            tmp++;
            if(Character.isSpace(arr[i])) tmp = 0;
        }
        return new String(arr);
    }
}