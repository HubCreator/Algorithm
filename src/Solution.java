class Solution {
    public long solution(long n) {
        StringBuilder sb = new StringBuilder();
        Long.toString(n).chars().sorted().forEach(c -> sb.append(Character.valueOf((char) c)));
        System.out.println("sb = " + sb);
        return Long.parseLong(sb.reverse().toString());
    }
}