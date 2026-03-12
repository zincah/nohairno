import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[][] matrix = new int[n][n];

        int x = 0;
        int y = 0;
        int v = 1;

        while (true) {
            while(true) {
                matrix[y][x] = v++;
                if ((y+1) == n || matrix[y+1][x] != 0) break;
                y += 1;
            }
            if (x+1 == n || matrix[y][x+1] != 0) break;
            x += 1;
            
            while(true) {
                matrix[y][x] = v++;
                if (x+1==n || matrix[y][x+1] != 0) break;
                x += 1;
            }
            if (matrix[y-1][x-1] != 0) break;
            x -= 1;
            y -= 1;
            
            while(true) {
                matrix[y][x] = v++;
                if (matrix[y-1][x-1] != 0) break;
                x -= 1;
                y -= 1;
            }
            if (y + 1 == n || matrix[y+1][x] != 0) break;
            y += 1;
            
        }
        
        int[] answer = new int[v-1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[index++] = matrix[i][j];
            }
        }

        return answer;
    }
}
