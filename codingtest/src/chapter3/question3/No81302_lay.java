package chapter3.question3;

public class No81302_lay {

    public static void main(String[] args) {
        No81302_lay no81302_lay = new No81302_lay();
        int[] result = no81302_lay.solution(new String[][]{
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        });

        for(int i=0; i<result.length; i++){
            System.out.print(result[i] + " ");
        }
    }

    // 상좌우하 방향
    int[] dx = {0, -1, 1, 0};
    int[] dy = {-1, 0, 0, 1};

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for(int i=0; i<answer.length; i++){
            String[] place = places[i];
            char[][] room = new char[place.length][];
            for(int j=0; j<room.length; j++){
                room[j] = place[j].toCharArray();
            }

            if(isDistanced(room)){
                answer[i] = 1;
            }else{
                answer[i] = 0;
            }
        }

        return answer;
    }

    // 응시자가 앉아있는 자리인지 찾는 메소드, 기존에 검사했던 위치를 제외하기 위해서 3-d 값을 exclude로 전달
    private boolean isNextToVolunteer(char[][] room, int x, int y, int exclude){
        for(int d = 0; d < 4; d++){
            if(d == exclude) continue;

            int nx = x + dx[d];
            int ny = y + dy[d];
            if(ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) continue;
            if(room[ny][nx] == 'P') return true;
        }
        return false;
    }

    // x,y 좌표에서 상좌우하를 검사하고 O인 경우에는 한번 더 검사하는 메소드 진행
    private boolean isDistanced(char[][] room, int x, int y){
        for(int d = 0; d < 4; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) continue;

            switch (room[ny][nx]){
                case 'P': return false; // P인 경우 지정된 좌석에 앉지 않았음을 의미
                case 'O':
                    // O인 경우 현재 검사했던 위치를 제외한 상좌우하를 검사하는 메소드 진행
                    if(isNextToVolunteer(room, nx, ny, 3-d)) return false;
                    break;
            }
        }
        return true;
    }

    // room을 검사
    private boolean isDistanced(char[][] room){
        for(int y = 0; y < room.length; y++){
            for(int x = 0; x < room[y].length; x++){

                if(room[y][x] != 'P') continue;

                // (x,y)가 P인 경우 해당 좌표로 들어가서 상좌우하를 검사
                if(!isDistanced(room, x, y)) return false;
            }
        }
        return true;
    }

}
