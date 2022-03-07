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

        for(int i = 0; i < N-1; i++) {
            for(int j = 0; j < N-i-1; j++) { // 바로 옆에 있는 값들을 비교
                if(nums[j] > nums[j+1]) {   // 가장 큰 값을 맨 오른쪽에 위치시킴
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }

        Arrays.stream(nums).forEach(x->System.out.print(x+" "));
    }
}