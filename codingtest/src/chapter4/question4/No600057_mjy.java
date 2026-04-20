package chapter4.question4;

public class No600057_mjy {

    public static void main(String[] args) {
        String s = "aabbaccc";
        System.out.println(solution(s));
    }

    public static int solution(String s) {
        int answer = s.length();

        for (int cut = 1; cut <= s.length()/2; cut++) {
            int sum = 0;
            int count = 1;
            for (int i = cut; i < s.length(); i += cut) {
                if (i + cut > s.length()) {
                    sum += s.length() - i;
                    break;
                }

                if (s.substring(i-cut, i).equals(s.substring(i, i + cut))) {
                    count++;
                } else {
                    sum += count == 1 ? cut : cut + String.valueOf(count).length();
                    count = 1;
                }

            }

            sum += count == 1 ? cut : cut + String.valueOf(count).length();

            if (sum < answer)
                answer = sum;
        }
        return answer;
    }
}
