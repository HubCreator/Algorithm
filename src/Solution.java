class Solution {
    public int[] solution(int brown, int yellow) {
        int tmp = (brown + 4) / 2;
        return new int[]{(int) ((tmp + Math.sqrt(Math.pow(tmp, 2) - 4 * (brown + yellow))) / 2),
                (int) ((tmp - Math.sqrt(Math.pow(tmp, 2) - 4 * (brown + yellow))) / 2)};
    }
}