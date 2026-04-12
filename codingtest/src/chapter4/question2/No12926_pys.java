package chapter4.question2;

public class No12926_pys {
    public static String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == ' ') {
                sb.append(c);
                continue;
            }
            
            // char는 유니코드 숫자로 처리
            // c - 'A' → 0~25로 변환(원래는 65~)
            // + n → 이동
            // % 26 → Z 넘어가면 다시 A로
            // + 'A' → 다시 문자로 복구
            
            if (c >= 'A' && c <= 'Z') { // 65 ~ 90
                sb.append((char)((c - 'A' + n) % 26 + 'A'));
            } else if (c >= 'a' && c <= 'z') { // 97 ~ 122
                sb.append((char)((c - 'a' + n) % 26 + 'a'));
            }
        }
        
        return sb.toString();
    }
  
    public static void main(String[] args) {
        // String inputS = "AB";
        // int inputN = 1;
        // String inputS = "z";
        // int inputN = 1;
        String inputS = "a B z";
        int inputN = 4;
        System.out.println(solution(inputS, inputN));
    }
}
