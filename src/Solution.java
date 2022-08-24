class Solution {
    public int solution(String s) {
        String[] nums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String tmp = s;
        for (int i = 0; i < 10; i++) {
            tmp = tmp.replaceAll(nums[i], String.valueOf(i));
        }
        return Integer.parseInt(tmp);
    }
}