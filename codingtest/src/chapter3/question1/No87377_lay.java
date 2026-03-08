package chapter3.question1;

import java.util.*;

public class No87377_lay {

    // 교점을 저장할 리스트 선언
    List<String> intersections = new ArrayList<>();

    // 좌표를 찍을 때 별을 포함하는 최소한의 크기만 나타내기 위한 min,max 값
    private long maxX = Long.MIN_VALUE;
    private long maxY = Long.MIN_VALUE;
    private long minX = Long.MAX_VALUE;
    private long minY = Long.MAX_VALUE;

    public String[] solution(int[][] line) {

        // 1. 교점 구해서 리스트에 저장하기
        getIntersection(line);

        // 2. 별 좌표 그리기
        List<String> result = new ArrayList<>();

        StringBuilder lineSb = new StringBuilder();
        for(long i=maxY; i>=minY; i--){
            lineSb.setLength(0);

            for(long j=minX; j<=maxX; j++){
                if(intersections.contains(j+"_"+i)){
                    lineSb.append("*");
                }else{
                    lineSb.append(".");
                }
            }
            result.add(lineSb.toString());

        }

        return result.stream().toArray(String[]::new);
    }

    // 교점 구하는 메소드
    private void getIntersection(int[][] line){
        for(int i=0; i<line.length; i++){
            long A = (long)line[i][0];
            long B = (long)line[i][1];
            long E = (long)line[i][2];

            for(int j=i+1; j<line.length; j++){
                long C = (long)line[j][0];
                long D = (long)line[j][1];
                long F = (long)line[j][2];

                // AD - BC = 0 인 경우 패스를 하기 위한 조건문
                if(A*D-B*C == 0) continue;

                long xu = B*F-E*D; // x 분자
                long xd = A*D-B*C; // x 분모
                long yu = E*C-A*F; // y 분자
                long yd = xd;      // y 분모

                // 정수가 아닐 경우를 거르기 위한 조건문
                if(xu%xd != 0 || yu%yd != 0) continue;

                long x = xu/xd;
                long y = yu/yd;

                // min, max 값 지정
                if(maxX < x) maxX = x;
                if(minX > x) minX = x;
                if(maxY < y) maxY = y;
                if(minY > y) minY = y;

                // 교점 리스트에 저장
                intersections.add(x+"_"+y);
            }
        }

    }
}
