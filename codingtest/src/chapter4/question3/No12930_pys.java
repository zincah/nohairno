package chapter4.question3;

public class No12930_pys {
    public static String solution(String s) {
        StringBuilder answer = new StringBuilder();

        int idx = 0; // 단어 내 인덱스

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ' ') {
                answer.append(c);
                idx = 0; // 단어 새로 시작
            } else {
                if (idx % 2 == 0) {
                    answer.append(Character.toUpperCase(c));
                } else {
                    answer.append(Character.toLowerCase(c));
                }
                idx++;
            }
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        String s1 = "try hello world";

        System.out.println(solution(s1)); // TrY HeLlO WoRlD
    }

}
