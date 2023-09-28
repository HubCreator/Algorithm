import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0, maxLength = Integer.MIN_VALUE;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int rt = 0; rt < arr.length; rt++) {
            minHeap.offer(arr[rt]);
            maxHeap.offer(arr[rt]);
            if (maxHeap.peek() - minHeap.peek() > 2) {
                maxHeap.remove(arr[lt]);
                minHeap.remove(arr[lt]);
                lt++;
            }
            maxLength = Math.max(maxLength, rt - lt + 1);
        }
        System.out.print(maxLength);
    }
}
