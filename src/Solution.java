import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int solution(int[] citations) {
        Integer[] intArray = new Integer[citations.length];

        for(int i = 0; i < citations.length; i++)
            intArray[i] = citations[i];

        Arrays.sort(intArray, Collections.reverseOrder());

        for(int i = 0; i < intArray.length; i++) {
            if(intArray[i] <= i+1)
                return i;
        }

        return intArray.length;
    }
}