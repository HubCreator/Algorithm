import java.util.Arrays;

class Solution {
    public int solution(String dartResult) {
        int idx = 0;
        int[] values = new int[3];
        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);
            if (Character.isDigit(c)) {
                if (c == '1' && Character.isDigit(dartResult.charAt(i + 1))) {
                    values[idx] = 10;
                    i++;
                    continue;
                }
                values[idx] = Integer.parseInt(String.valueOf(c));
            } else if (Character.isAlphabetic(c)) {
                switch (c) {
                    case 'D' -> values[idx] = (int) Math.pow(values[idx], 2);
                    case 'T' -> values[idx] = (int) Math.pow(values[idx], 3);
                }
                if (i + 1 < dartResult.length() && Character.isDigit(dartResult.charAt(i + 1))) idx++;
            } else {
                switch (c) {
                    case '*' -> {
                        if (idx != 0) values[idx - 1] *= 2;
                        values[idx] *= 2;
                    }
                    case '#' -> values[idx] *= -1;
                }
                idx++;
            }
        }
        return Arrays.stream(values).sum();
    }
}