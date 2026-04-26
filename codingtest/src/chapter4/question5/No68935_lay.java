package chapter4.question5;

public class No68935_lay {

    public static void main(String[] args) {
        No68935_lay no68935_lay = new No68935_lay();
        int result = no68935_lay.solution(45);
        System.out.println(result);
    }

    public int solution(int n) {

        // 3진법으로 변환해서 String 변수에 저장
        String str = Integer.toString(n, 3);

        // 변환된 String을 뒤집기
        String reverseStr = new StringBuilder(str).reverse().toString();

        // 뒤집어진 String값을 다시 10진법으로 변환해서 리턴
        return Integer.parseInt(reverseStr, 3);
    }
}
