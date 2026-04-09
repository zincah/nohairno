package chapter4.question2;

public class No12926_lay {

    public static void main(String[] args) {
        No12926_lay no12926_lay = new No12926_lay();
        String result = no12926_lay.solution("aBc", 2);
        System.out.println(result);
    }

    public String solution(String s, int n) {

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch == ' '){
                sb.append(' ');
                continue;
            }

            int idx = ch;
            if(idx >= 65 && idx <= 90){
                // 대문자
                sb.append(moveIndex(idx, n, 90));
            }else{
                // 소문자
                sb.append(moveIndex(idx, n, 122));
            }

        }

        return sb.toString();
    }

    private char moveIndex(int idx, int n, int max){
        if((idx + n) > max){
            int chgIdx = (idx + n) - 26;
            return (char)chgIdx;
        }else{
            return (char)(idx+n);
        }
    }
}
