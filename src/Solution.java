class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int arr1RowSize = arr1.length, arr1ColSize = arr1[0].length;
        int arr2RowSize = arr2.length, arr2ColSize = arr2[0].length;
        int idx = 0;
        int[][] answer = new int[arr1RowSize][arr2ColSize];

        for (int i = 0; i < arr1RowSize; i++) {
            if (idx == arr2ColSize) idx = 0;
            int[] arr1Tmp = arr1[i].clone();
            int[] arr2Tmp = new int[arr2RowSize];

            for (int j = 0; j < arr2ColSize; j++) {
                int sum = 0;
                for (int k = 0; k < arr2RowSize; k++)
                    arr2Tmp[k] = arr2[k][j];

                for (int k = 0; k < arr1Tmp.length; k++)
                    sum += arr1Tmp[k] * arr2Tmp[k];

                answer[i][idx++] = sum;
            }
        }
        return answer;
    }
}