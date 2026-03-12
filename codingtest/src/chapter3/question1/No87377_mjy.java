package chapter3.question1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No87377_mjy {

    public static void main(String[] args) {
        int[][] example1 = {
                {2, -1, 4},
                {-2, -1, 4},
                {0, -1, 1},
                {5, -8, -12},
                {5, 8, 12}
        };

        System.out.println(Arrays.toString(solution(example1)));
    }

    public static String[] solution(int[][] line) {
        ArrayList<Point> points = new ArrayList<>();

        for (int i=0; i < line.length; i++) {
            for (int j=i+1; j < line.length; j++) {
                Point intersectP = intersectPoint(line[i][0], line[i][1], line[i][2],
                        line[j][0], line[j][1], line[j][2]);

                if (intersectP != null) {
                    points.add(intersectP);
                    System.out.println(intersectP.toString());
                }
            }
        }

        Point minP = getMinPoint(points);
        Point maxP = getMaxPoint(points);

        int w = (int)(maxP.x - minP.x + 1);
        int h = (int)(maxP.y - minP.y + 1);

        char[][] arr = new char[h][w];
        for (char[] row : arr) {
            Arrays.fill(row, '.');
        }

        for (Point p : points) {
            int x = (int)(p.x - minP.x);
            int y = (int)(maxP.y - p.y);
            arr[y][x] = '*';
        }

        String[] result = new String[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = new String(arr[i]);
        }

        return result;
    }

    public static Point intersectPoint(long a, long b, long e, long c, long d, long f) {
        double x = (double) (b * f - e * d) / (a*d - b*c);
        double y = (double) (e * c - a * f) / (a*d - b*c);

        if (x % 1 != 0.0 || y % 1 != 0.0) return null;
        return new Point((long) x, (long) y);
    }

    private static Point getMinPoint(List<Point> points) {
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;

        for (Point p : points) {
            if (p.x < x) x = p.x;
            if (p.y < y) y = p.y;
        }

        return new Point(x, y);
    }

    private static Point getMaxPoint(List<Point> points) {
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;

        for (Point p : points) {
            if (p.x > x) x = p.x;
            if (p.y > y) y = p.y;
        }

        return new Point(x, y);
    }

    private static class Point {
        public final long x, y;

        private Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}
