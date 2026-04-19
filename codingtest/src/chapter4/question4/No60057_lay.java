package chapter4.question4;

public class No60057_lay {

    public static void main(String[] args) {
        No60057_lay no60057_lay = new No60057_lay();
        int result = no60057_lay.solution("aabbaccc"); // 2a2ba3c(aabbaccc) // ababcdcdababcdcd
        System.out.println(result);
    }

    public int solution(String s) {

        // 압축을 해서 구해지는 문자열의 최소값을 저장하기 위한 변수
        int min = s.length();

        // 자르는 단위가 절반보다 넘어가게 되면 압축을 할 수 없기에 문자열의 절반까지만 확인하면 됨
        for(int i=0; i<s.length()/2; i++){
            min = Math.min(splitBySize(i+1, s).length(), min);
        }

        return min;
    }

    private String splitBySize(int size, String str){
        StringBuilder sb = new StringBuilder();

        // 첫번째 Unit 저장 (현재 문자열과 비교하는 역할)
        String past = str.substring(0, size);

        // 반복 카운트
        int loopCnt = 1;
        for(int i=size; i<=str.length(); i+=size){

            // 지정된 size만큼 substring
            String subStr = str.substring(i, Math.min(i+size, str.length()));

            // 과거 문자열과 현재 문자열이 동일할때 반복 카운트 +1
            if(past.equals(subStr)){
                loopCnt++;

            // 동일하지 않을 때
            }else{
                if(loopCnt > 1){
                    // 반복카운트가 1보다 크면 문자열 앞쪽에 몇번 반복했는지 append
                    sb.append(loopCnt);
                }

                // 과거 문자열을 append 하고 반복 카운트 리셋
                sb.append(past);
                loopCnt = 1;
            }

            // 현재 문자열 저장
            past = subStr;
        }

        // 반복 문 종료 후 마지막 잔여 문자열 처리
        if(loopCnt > 1){
            sb.append(loopCnt);
        }
        sb.append(past);

        return sb.toString();
    }
}
