package chapter3.question3;

import java.awt.*;

public class No1302_mjy {

    public static void main(String[] args) {
        String[][] arr = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };

        System.out.println(solution(arr));
    }

                             // 상 우 하 좌
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};


    public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int n = 0; n < places.length; n++) {
            byte[][] place = new byte[places[n].length][];
            for (int i = 0; i < places[n].length; i++) {
                place[i] = places[n][i].getBytes();
            }
            answer[n] = isOk(place);
        }
        return answer;
    }

    private static int isOk(byte[][] place) {
        for (int i = 0; i < place.length; i++) {
            for (int j = 0; j < place[i].length; j++) {
                if (place[i][j] == 'O' || place[i][j] == 'P') {
                    Point p = new Point(i, j);
                    int pCount = place[i][j] == 'O' ? 0 : 1;
                    for (int d = 0; d < 4; d++) {
                        int nx = p.x + dx[d];
                        int ny = p.y + dy[d];

                        if (nx >= 0 && nx < place.length && ny >= 0 && ny < place[i].length) {
                            if (place[nx][ny] == 'P') pCount++;
                        }

                        if (pCount > 1) return 0;
                    }
                }
            }
        }
        return 1;
    }
}
