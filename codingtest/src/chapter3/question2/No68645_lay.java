package chapter3.question2;

import java.util.Arrays;

public class No68645_lay {

    public static void main(String[] args) {
        int n = 5;

        System.out.println(Arrays.toString(solution(n)));
    }

    public static int[] solution(int n) {

        int[][] triagle = new int[n][n];
        int v = 1;

        int x = 0;
        int y = 0;

        while (true) {
            // 아래
            while(true){
                triagle[y][x] = v++;
                if (y+1 == n || triagle[y+1][x] != 0) break; // 이동한 곳이 n이거나 0이 아닐떄 (이미 채워져있을 때)
                y += 1; // 아래로 이동
            }
            // 오른쪽으로 진행할 수 있는지 검증 (최대로 이동했거나 값이 있거나)
            if(x + 1 == n || triagle[y][x+1] != 0) break;
            x += 1;

            // 오른쪽
            while(true){
                triagle[y][x] = v++;
                if (x+1 == n || triagle[y][x+1] != 0) break;
                x += 1;
            }
            if (triagle[y-1][x-1] != 0) break;
            x -= 1;
            y -= 1;

            // 위
            while(true){
                triagle[y][x] = v++;
                if(triagle[y-1][x-1] != 0) break;
                x -= 1;
                y -= 1;
            }
            if(y + 1 == n || triagle[y+1][x] != 0) break;
            y += 1;
        }

        int[] result = new int[v-1];
        int index = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                result[index++] = triagle[i][j];
            }
        }

        return result;
    }
}
