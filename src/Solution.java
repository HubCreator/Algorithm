import java.util.LinkedList;
import java.util.Queue;

class Truck {
    int weight, move;

    public Truck(int weight) {
        this.weight = weight;
        this.move = 1;
    }

    public void gogo() {
        this.move++;
    }
}

class Solution {
    public int solution(int bridgeLen, int weight, int[] weights) {
        int curWeight = 0, answer = 0;
        Queue<Truck> waitQ = new LinkedList<>();
        Queue<Truck> moveQ = new LinkedList<>();
        for (int w : weights) waitQ.offer(new Truck(w));

        while (!waitQ.isEmpty() || !moveQ.isEmpty()) {
            answer++;
            if (moveQ.isEmpty()) {
                Truck p = waitQ.poll();
                curWeight += p.weight;
                moveQ.offer(p);
                continue;
            }
            for (Truck t : moveQ) t.gogo(); // 모두 움직여
            if (moveQ.peek().move > bridgeLen) { // 제일 앞에 놈이 다리 길이보다 길면 빼야함
                Truck p = moveQ.poll();
                curWeight -= p.weight;
            }
            if (!waitQ.isEmpty() && curWeight + waitQ.peek().weight <= weight) { // 다리 위에 추가적으로 올릴 수 있으면 올려라
                Truck p = waitQ.poll();
                curWeight += p.weight;
                moveQ.offer(p);
            }
        }

        return answer;
    }
}