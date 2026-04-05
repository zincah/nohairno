package chapter4.question1;

public class No12932_lay {

    public static void main(String[] args) {
        No12932_lay no12932_lay = new No12932_lay();
        int[] result = no12932_lay.solution(12345);

        for(int i=0; i<result.length; i++){
            System.out.print(result[i]);
        }

        int[] result2 = no12932_lay.solution2(12345);

        for(int i=0; i<result2.length; i++){
            System.out.print(result2[i]);
        }
    }

    public int[] solution(long n) {
        String nStr = String.valueOf(n);

        int[] result = new int[nStr.length()];
        int pos = 0;
        for(int i = nStr.length()-1; i >= 0; i--){
            result[pos++] = nStr.charAt(i) - '0';
        }

        return result;
    }

    // 시간이 더 오래걸림
    public int[] solution2(long n) {
        int[] result = new StringBuilder().append(n).reverse().chars().map(Character::getNumericValue).toArray();
        return result;
    }

}
