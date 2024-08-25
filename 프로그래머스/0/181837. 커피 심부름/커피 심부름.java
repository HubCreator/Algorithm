class Solution {
    public int solution(String[] order) {
        String hot = "hot", ice = "ice";
        String americano = "americano", latte = "latte";
        String anything = "anything";
        // 아메리카 4500, 라떼 5000
        // 메뉴만 -> ice
        // 옵션까지 -> hot?
        // 아무거나 -> ice 아메리카노
        
        int answer = 0;
        for (String o : order) {
            if (o.contains(americano)) {
                answer += 4500;
            } else if (o.contains(anything)) {
                answer += 4500;
            } else {
                answer += 5000;
            }
        }
        
        return answer;
    }
}