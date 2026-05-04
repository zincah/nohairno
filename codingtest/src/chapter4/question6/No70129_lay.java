package chapter4.question6;

public class No70129_lay {

    public static void main(String[] args) {
        No70129_lay no70129_lay = new No70129_lay();
        int[] result = no70129_lay.solution("110010101001");
        System.out.println(result[0] + " " + result[1]);
    }

    public int[] solution(String s) {

        String str = s;

        int loopCnt = 0;
        int zeroCnt = 0;
        StringBuilder sb = new StringBuilder();
        while(str.length() > 1){

            // 문자열 0 검증해서 0 삭제
            for(char ch : str.toCharArray()){
                if(ch == '0'){
                    zeroCnt++;
                }else{
                    sb.append(ch);
                }
            }

            // 0을 삭제한 string의 길이를 2진법으로 변환
            str = Integer.toString(sb.length(), 2);
            sb.setLength(0);
            loopCnt++;
        }

        return new int[]{loopCnt, zeroCnt};
    }
}
