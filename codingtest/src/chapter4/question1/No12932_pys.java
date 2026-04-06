package chapter4.question1;

import java.util.Arrays;

public class No12932_pys {
    public static int[] solution(long n) {
        int[] answer = new int[String.valueOf(n).length()];
        int idx = 0;
        while (n > 0) {
            answer[idx++] = (int)(n % 10);
            n /= 10;
        }
        return answer;
    }

    public static void main(String[] args) {
        long n = 12345;
        System.out.println(Arrays.toString(solution(n)));
    }

}
