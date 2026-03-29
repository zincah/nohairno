package chapter3.question4;

import java.util.Arrays;

public class No12949_mjy {

    public static void main(String[] args) {

//        int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
//        int[][] arr2 = {{3, 3}, {3, 3}};

        int[][] arr1 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
        int[][] arr2 = {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};

        System.out.println(Arrays.deepToString(solution(arr1, arr2)));
    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                int value = 0;
                for (int k = 0; k < arr1[i].length; k++) {
                    value += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = value;
            }
        }
        return answer;
    }
}
