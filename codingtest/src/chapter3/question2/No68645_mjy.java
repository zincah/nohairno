package chapter3.question2;


import java.awt.*;
import java.util.Arrays;

public class No68645_mjy {

    public static void main(String[] args) {
        int n = 5;

        System.out.println(Arrays.toString(solution(n)));
    }

    public static int[] solution(int n) {

        int[][] array = new int[n][n];

        Point p = new Point(-1, 0);
        int dir = 0;
        int cur = 1;

        while (n != 0) {
            for (int i = 0; i < n; i++) {
                p = nextPoint(p, dir);
                array[p.x][p.y] = cur++;
            }

            dir = (dir + 1) % 3;
            n--;
        }

        int[] result = new int[cur-1];
        cur = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] != 0)
                    result[cur++] = array[i][j];
            }
        }

        return result;
    }

    public static Point nextPoint(Point curP, int dir) {
        if (dir == 0) {
            return new Point(++curP.x, curP.y);
        } else if (dir == 1) {
            return new Point(curP.x, ++curP.y);
        } else {
            return new Point(--curP.x, --curP.y);
        }
    }
}
