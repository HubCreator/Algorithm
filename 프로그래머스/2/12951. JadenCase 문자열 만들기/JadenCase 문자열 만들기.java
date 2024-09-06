class Solution {
    public String solution(String s) {
        char[] arr = s.toLowerCase().toCharArray();
        if (Character.isAlphabetic(arr[0])) {
            arr[0] = Character.toUpperCase(arr[0]);
        }
        
        for (int i = 1; i < arr.length; i++) {
            char t = arr[i];
            if (Character.isAlphabetic(t) && arr[i - 1] == ' ') {
                arr[i] = Character.toUpperCase(t);
            }
        }
        return new String(arr);
    }
}