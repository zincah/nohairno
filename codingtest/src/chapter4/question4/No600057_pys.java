package chapter4.question4;

public class No600057_pys {
    public static int solution(String s) {
        int n = s.length();
        int answer = n; // 압축 아예 안되는 경우

        // 절반 이상은 압축 의미 X
        for (int unit = 1; unit <= n / 2; unit++) {
            int count = 1; // 같은 조각 반복 횟수
            int length = 0; // 압축된 문자열 길이
            String prev = s.substring(0, unit); // 이전 문자열 조각

            for (int i = unit; i < n; i += unit) {
                // 현재 조각 만들기
                String current;
                if (i + unit <= n) {
                    current = s.substring(i, i + unit);
                } else {
                    current = s.substring(i); // 남은 문자열
                }

                // 압축판단(같은게 나오는 동안은 쌓기만 하기)
                if (prev.equals(current)) {
                    // 같으면 개수 증가
                    count++;
                } else {
                    // 다르면 압축 진행
                    // 1. '이전문자열조각' 길이 더해주고
                    length += prev.length();
                    // 2. '횟수' 길이 더해주고
                    if (count > 1) {
                        length += String.valueOf(count).length();
                    }
                    prev = current; // 달랐던 문자열이 이전 문자열 조각이 됨
                    count = 1;
                }
            }

            // 마지막 조각 처리(마지막까지 오면 여기까지 압축 수동)
            length += prev.length();
            if (count > 1) {
                length += String.valueOf(count).length();
            }

            // 최소 길이 갱신
            answer = Math.min(answer, length);
        }

        return answer;
    }

    public static void main(String[] args) {
        String s1 = "aabbaccc";
        String s2 = "ababcdcdababcdcd";
        String s3 = "abcabcdede";
        String s4 = "abcabcabcabcdededededede";
        String s5 = "xababcdcdababcdcd";

        System.out.println(solution(s5));
    }

}
