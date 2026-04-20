package chapter4.question3;

public class No12930_mjy {

    public static void main(String[] args) {
        String s = "try hello world";
        System.out.println(solution(s));
        System.out.println((int)'a');
        System.out.println((char)('A' + 32));
    }


    public static String solution(String s) {
        StringBuilder answer = new StringBuilder();

        boolean isUpper = true;
        for (char c : s.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                if(isUpper) {
                    answer.append(Character.toUpperCase(c));
                } else {
                    answer.append(Character.toLowerCase(c));
                }
                isUpper = !isUpper;
            } else {
                answer.append(c);
                isUpper = true;
            }

        }

        return answer.toString();
    }
}
