class Solution {
    public int[] solution(int brown, int yellow) {
        int height, total = brown + yellow;
        for (int width = 3; width <= total; width++) {
            if (total % width == 0) {
                height = total / width;
                if (brown == width * 2 + height * 2 - 4) {
                    if (width > height) {
                        return new int[]{width, height};
                    }
                    return new int[]{height, width};
                }
            }
        }

        return null;
    }
}