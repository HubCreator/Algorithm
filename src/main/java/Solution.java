import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Point {
    int y, x;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public Point(Point point) {
        this.y = point.getY();
        this.x = point.getX();
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
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

class Line {
    Point a, b;

    public Line(Point a, Point b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return (Objects.equals(a, line.a) && Objects.equals(b, line.b)) ||
                (Objects.equals(a, line.b) && Objects.equals(b, line.a));
    }

    @Override
    public int hashCode() {
        return Objects.hash(a.getY() + a.getX() + b.getY() + b.getX());
    }
}

class Solution {
    private static final int MIN = -5;
    private static final int MAX = 5;

    Set<Line> lines = new HashSet<>();

    private void moveY(int val, Point point, Point tmp) {
        if (val >= MIN && val <= MAX) {
            point.setY(val);
            lines.add(new Line(tmp, new Point(point)));
        }
    }

    private void moveX(int val, Point point, Point tmp) {
        if (val >= MIN && val <= MAX) {
            point.setX(val);
            lines.add(new Line(tmp, new Point(point)));
        }
    }

    private void move(Point point, char dir) {
        Point tmp = new Point(point);
        if (dir == 'U') {
            moveY(point.getY() - 1, point, tmp);
        } else if (dir == 'D') {
            moveY(point.getY() + 1, point, tmp);
        } else if (dir == 'L') {
            moveX(point.getX() - 1, point, tmp);
        } else if (dir == 'R') {
            moveX(point.getX() + 1, point, tmp);
        }
    }

    public int solution(String dirs) {
        Point point = new Point(0, 0);
        for (int i = 0; i < dirs.length(); i++) {
            move(point, dirs.charAt(i));
        }
        return lines.size();
    }
}