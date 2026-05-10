package chapter4.question7;

public class No12916_lay {

    public static void main(String[] args) {

        No12916_lay main = new No12916_lay();
        boolean result = main.solution("pPoooyY");
        System.out.println(result);
    }

    boolean solution(String s) {
        int n = 0;
        for(char ch : s.toCharArray()){
            switch(ch){
                case 'p', 'P' -> n++;
                case 'y', 'Y' -> n--;
            }
        }

        return n == 0;
    }
}
