package ru.msvdev.leetcode.topInterview150.math;

import java.util.*;

/**
 * 149. Max Points on a Line
 * <p>
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane,
 * return the maximum number of points that lie on the same straight line.
 * <p>
 * Example 1:
 * Input: points = [[1,1],[2,2],[3,3]]
 * Output: 3
 * <p>
 * Example 2:
 * Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * Output: 4
 * <p>
 * Constraints:
 * -- 1 <= points.length <= 300
 * -- points[i].length == 2
 * -- -1e4 <= xi, yi <= 1e4
 * -- All the points are unique.
 */
public class N149MaxPointsOnALine {

    public int maxPoints2(int[][] points) {
        final int n = points.length;
        if (n < 3) return n;

        int maxPoints = 2;
        for (int i = 0; i < n - 2; i++) {
            final int x1 = points[i][0];
            final int y1 = points[i][1];

            for (int j = i + 1; j < n - 1; j++) {
                final int x2 = points[j][0];
                final int y2 = points[j][1];
                int countOnLine = 2;

                for (int k = j + 1; k < n; k++) {
                    final int x3 = points[k][0];
                    final int y3 = points[k][1];

                    if (x1 * (y3 - y2) + x2 * (y1 - y3) + x3 * (y2 - y1) == 0) countOnLine++;
                }

                if (maxPoints < countOnLine) maxPoints = countOnLine;
            }
        }

        return maxPoints;
    }


    public int maxPoints1(int[][] points) {
        final int n = points.length;
        if (n < 3) return n;

        int maxPoints = 2;
        final Map<Line, Set<Point>> linesMap = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i; j < n; j++) {
                final Line line = Line.getInstance(points[i][0], points[i][1], points[j][0], points[j][1]);
                Set<Point> pointSet = linesMap.get(line);
                if (pointSet == null) {
                    pointSet = new HashSet<>();
                    pointSet.add(new Point(points[i][0], points[i][1]));
                    pointSet.add(new Point(points[j][0], points[j][1]));
                    linesMap.put(line, pointSet);
                } else {
                    pointSet.add(new Point(points[j][0], points[j][1]));
                    if (maxPoints < pointSet.size()) maxPoints = pointSet.size();
                }
            }
        }

        return maxPoints;
    }

    private record Point(int x, int y) {
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    private record Line(int dx, int dy, int c) {
        public static Line getInstance(int x0, int y0, int x1, int y1) {
            int dx = x1 - x0;
            int dy = y1 - y0;

            if (dx == 0) {
                return new Line(0, 1, -x0);
            }
            if (dy == 0) {
                return new Line(1, 0, y0);
            }

            if (dx < 0) {
                dx = -dx;
                dy = -dy;
            }

            int a = dx;
            int b = (dy > 0) ? dy : -dy;
            if (a < b) {
                int tmp = a;
                a = b;
                b = tmp;
            }

            while (b > 0) {
                int tmp = a % b;
                a = b;
                b = tmp;
            }

            dx /= a;
            dy /= a;

            return new Line(dx, dy, y0 * dx - x0 * dy);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Line line = (Line) o;
            return c == line.c && dx == line.dx && dy == line.dy;
        }

        @Override
        public int hashCode() {
            return Objects.hash(dx, dy, c);
        }
    }
}
