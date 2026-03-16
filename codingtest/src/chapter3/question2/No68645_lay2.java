package chapter3.question2;

import java.util.Arrays;

public class No68645_lay2 {

    public static void main(String[] args) {
        int n = 5;

        System.out.println(Arrays.toString(solution(n)));
    }

    private static final int[] dx = {0, 1, -1};
    private static final int[] dy = {-1, 0, 1};

    public static int[] solution(int n) {

        int[][] triangle = new int[n][n];
        int v = 1;
        int x = 0;
        int y = n-1;
        int d = 0;

        while(true){
            triangle[y][x] = v++;
            int nx = x + dx[d]; // 이동한 x 좌표
            int ny = y + dy[d]; // 이동한 y 좌표

            // 이동한 x,y 좌표가 n이거나 0보다 작거나 배열에 이미 값이 채워져있을 때 방향을 전환한다.
            if(nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0){

                // 방향 배열의 값을 통해 방향을 전환해서 움직인다.
                d = (d + 1) % 3;
                nx = x + dx[d];
                ny = y + dy[d];

                // 전환했을 때도 x,y 좌표가 n이거나 0보다 작거나 배열에 값이 채워져있을 때는 while문을 종료한다.
                if(nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0){
                    break;
                }
            }

            x = nx;
            y = ny;
        }

        int[] result = new int[v-1];
        int index = 0;
        for(int i = n-1; i >= 0; i--){
            for(int j = 0; j < n-i; j++){
                result[index++] = triangle[i][j];
            }
        }

        return result;
    }
}
