import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int number, int limit, int power) {
        List<Integer> divisorCountList = getDivisorCountList(number);
        int result = 0;
        for (Integer divisor : divisorCountList) {
            result += divisor > limit ? power : divisor;
        }
        return result;
    }

    private List<Integer> getDivisorCountList(int number) {
        List<Integer> result = new ArrayList<>(number);
        for (int index = 1; index <= number; index++) {
            result.add(getDivisorCount(index));
        }
        return result;
    }

    private int getDivisorCount(int number) {
        int count = 0;
        for (int i = 1; i * i <= number; i++) {
            if (i * i == number) {
                count++;
            } else if (number % i == 0) {
                count += 2;
            }
        }
        return count;
    }
}