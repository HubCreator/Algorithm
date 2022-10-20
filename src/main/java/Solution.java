import java.util.*;

class Point {
    int y, x;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return y == point.y && x == point.x;
    }

    @Override
    public int hashCode() {
        return Objects.hash(y, x);
    }
}

class Solution {

    private List<LinkedList<Character>> update(List<LinkedList<Character>> board, Set<Point> set) {
        List<LinkedList<Character>> updated = new ArrayList<>();
        for (int i = 0; i < board.size(); i++) {
            updated.add(new LinkedList<>());
            for (int j = 0; j < board.get(i).size(); j++) {
                if (!set.contains(new Point(j, i))) updated.get(i).add(board.get(i).get(j));
            }
            while (updated.get(i).size() < board.get(i).size()) updated.get(i).addFirst('*');
        }
        return updated;
    }

    public Set<Point> isValid(List<LinkedList<Character>> board, int i, int j) {
        Character cur = board.get(i).get(j);
        if (cur.equals('*')) return null;
        Set<Point> result = new HashSet<>();
        result.add(new Point(j, i));
        if (board.get(i).get(j + 1) == cur) result.add(new Point(j + 1, i));
        if (board.get(i + 1).get(j) == cur) result.add(new Point(j, i + 1));
        if (board.get(i + 1).get(j + 1) == cur) result.add(new Point(j + 1, i + 1));
        if (result.size() == 4) return result;
        return null;
    }

    private void check(List<LinkedList<Character>> board, Set<Point> set) {
        set.clear();
        for (int i = board.size() - 2; i >= 0; i--) {
            for (int j = board.get(i).size() - 2; j >= 0; j--) {
                Set<Point> tmp = isValid(board, i, j);
                if (tmp != null) {
                    set.addAll(tmp);
                }
            }
        }
    }

    private List<LinkedList<Character>> makeBoard(int m, int n, String[] _board) {
        List<LinkedList<Character>> board = new ArrayList<>();
        for (int i = 0; i < n; i++) board.add(new LinkedList<>());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board.get(i).add(_board[j].charAt(i));
            }
        }
        return board;
    }

    public int solution(int m, int n, String[] _board) {
        int answer = 0;
        List<LinkedList<Character>> board = makeBoard(m, n, _board);
        Set<Point> set = new HashSet<>();
        while (true) {
            check(board, set);
            if (set.isEmpty()) break;
            answer += set.size();
            board = update(board, set); // board 갱신
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        String[] arr = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        System.out.println(T.solution(4, 5, arr));
    }
}