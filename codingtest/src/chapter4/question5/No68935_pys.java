package chapter4.question5;

public class No68935_pys {
    public static int solution(int n) {
        String str = Integer.toString(n, 3); // 10진법 -> 3진법으로 변환
        String reversed = new StringBuilder(str).reverse().toString(); // 뒤집기
        return Integer.valueOf(reversed, 3); // 3진법 -> 10진법
    }

    public static void main(String[] args) {
        int n1 = 45;
        int n2 = 125;

        System.out.println(solution(n1));
    }

}
