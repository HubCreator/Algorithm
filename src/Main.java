import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer input_nums = new StringTokenizer(br.readLine(), " ");
        int[] nums = new int[N];
        for(int i = 0; i < nums.length; i++)
            nums[i] = Integer.parseInt(input_nums.nextToken());

        for(int i = 0; i < N; i++) {
            int index = i; // 기준값
            for(int j = i+1; j < N; j++) // 기준값 이후의 값들을 비교
                if(nums[j] < nums[index]) index = j; // index는 가장 작은 요소값을 찾아감

            int tmp = nums[index]; // 가장 작은 요소와 현재 기준값을 swap
            nums[index] = nums[i];
            nums[i] = tmp;
        }
				/*
					13 5 11 7 23 15
					7 5 11 13 23 15

				*/
        Arrays.stream(nums).forEach(x->System.out.print(x+" "));
    }
}