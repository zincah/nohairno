package chapter4.question2;

import java.util.Arrays;

public class No12926_mjy {

    public static void main(String[] args) {

        String s = "a B z";
        int n = 4;
        System.out.println(solution(s, n));

    }


    public static String solution(String s, int n) {

        byte[] c = s.getBytes();
        for (int i = 0; i < s.length(); i++) {
            if (c[i] == ' ') continue;

            int term = 'Z' - 'A' + 1;
            if (c[i] >= 'a') c[i] = (byte) ((c[i] - 'a' + n) % term + 'a');
            else c[i] = (byte) ((c[i] - 'A' + n) % term + 'A');

        }

        return new String(c);
    }
}
