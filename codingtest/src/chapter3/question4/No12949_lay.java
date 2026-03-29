package chapter3.question4;

public class No12949_lay {

    public static void main(String[] args) {
        No12949_lay no12949_lay = new No12949_lay();
//        int[][] answer = no12949_lay.solution(new int[][]{{1,4},{3,2},{4,1}}, new int[][]{{3,3},{3,3}});
//        int[][] answer = no12949_lay.solution(new int[][]{{2,3,2},{4,2,4},{3,1,4}}, new int[][]{{5,4,3},{2,4,1},{3,1,1}});
        int[][] answer = no12949_lay.solution(new int[][]{{2,3,2},{4,2,4},{3,1,4}}, new int[][]{{5,4,3,1},{2,4,1,1},{3,1,1,1}});

        for(int i=0; i<answer.length; i++){
            for(int j=0; j<answer[i].length; j++){
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] solution(int[][] arr1, int[][] arr2) {

        int r = arr2[0].length;     // 행
        int c = arr1.length;        // 열
        int[][] resultArr = new int[c][r]; // 결과배열 : arr1의 열의 수 * arr2의 행의 수

        // 1. arr1 을 열의 수만큼 반복한다.
        for(int i=0; i<arr1.length; i++){

            // 2. arr[i]를 취득
            int[] row = arr1[i];

            // 3. arr2[0]의 수만큼 반복한다.
            for(int j=0; j<arr2[0].length; j++){

                // 4. 행렬의 곱셈을 저장할 변수
                int hap = 0;

                // 5. arr[i] 의 각 원소와 arr2의 행값은 고정, 열값만 k에 따라 변경하면서 행렬의 곱셈을 수행한다.
                for(int k=0; k < row.length; k++){
                    hap += row[k] * arr2[k][j];
                }

                // 6. 결과 배열에 저장한다.
                resultArr[i][j] = hap;
            }
        }

        return resultArr;
    }
}
