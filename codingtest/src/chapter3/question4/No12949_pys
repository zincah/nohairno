package chapter3.question4;

import java.util.*;

public class No12949_pys {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        // 결과 행렬 = [왼쪽행렬행개수][오른쪽행렬열개수]
        int[][] answer = new int[arr1.length][arr2[0].length];

        // arr1 행
        for (int i = 0; i < answer.length; i++) {
            // arr2 열
            for (int j = 0; j < answer[i].length; j++) {
                // 공통 길이 (앞 행렬의 열 = 뒤 행렬의 행)
                for (int k = 0; k < arr2.length; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        No12949_pys sol = new No12949_pys();

//        int[][] arr1 = {{1, 4},{3, 2},{4, 1}};
//        int[][] arr2 = {{3, 3},{3, 3}};

        int[][] arr1 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
        int[][] arr2 = {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};

        System.out.println(Arrays.deepToString(sol.solution(arr1, arr2)));
    }
}
