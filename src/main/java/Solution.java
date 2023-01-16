import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int number, int limit, int power) {
        List<Integer> divisorCountList = getDivisorCountList(number);
        int result = 0;
        for (Integer target : divisorCountList) {
            if (target > limit) {
                result += power;
            } else {
                result += target;
            }
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

    private int getDivisorCount(int index) {
        int count = 0;
        for (int i = 1; i <= index; i++) {
            if (index % i == 0) {
                count++;
            }
        }
        return count;
    }
}