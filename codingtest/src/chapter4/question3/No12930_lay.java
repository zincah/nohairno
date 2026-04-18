package chapter4.question3;

public class No12930_lay {

    public static void main(String[] args) {
        No12930_lay no12930_lay = new No12930_lay();
        String result = no12930_lay.solution("try hello world");
        System.out.println(result);
    }

    public String solution(String s) {

        char[] chArr = s.toCharArray();
        int idx = 0;

        for(int i =0; i<chArr.length; i++){

            char ch = chArr[i];
            if(ch == ' '){
                idx = 0;
            }else{
                chArr[i] = idx++%2 == 0 ? Character.toUpperCase(ch) : Character.toLowerCase(ch);
            }

        }

        return new String(chArr);
    }
}
