public class No81302_pys {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            // 각 대기실 마다 검사
            answer[i] = check(places[i]) ? 1 : 0;
        }

        return answer;
    }

    private boolean check(String[] p) {
        // p = (["POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"])
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                // 사람자리만 검사
                if (p[r].charAt(c) != 'P') continue;

                // 상하좌우 (거리 1)
                if (isNearP(r, c, p)) return false;

                // 직선 거리 2
                if (isLine2P(r, c, p)) return false;

                // 대각선
                if (isDiagonalP(r, c, p)) return false;
            }
        }
        return true;
    }

    // 거리 1
    private boolean isNearP(int r, int c, String[] p) {
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || nc < 0 || nr >= 5 || nc >= 5) continue;

            if (p[nr].charAt(nc) == 'P') return true;
        }
        return false;
    }

    // 직선 거리 2
    private boolean isLine2P(int r, int c, String[] p) {
        int[] dr = {-2, 2, 0, 0};
        int[] dc = {0, 0, -2, 2};

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || nc < 0 || nr >= 5 || nc >= 5) continue;

            if (p[nr].charAt(nc) == 'P') {
                // 중간 확인
                int mr = (r + nr) / 2;
                int mc = (c + nc) / 2;

                if (p[mr].charAt(mc) == 'O') return true;
            }
        }
        return false;
    }

    // 대각선
    private boolean isDiagonalP(int r, int c, String[] p) {
        int[] dr = {-1, -1, 1, 1};
        int[] dc = {-1, 1, -1, 1};

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || nc < 0 || nr >= 5 || nc >= 5) continue;

            if (p[nr].charAt(nc) == 'P') {
                // 양 옆 확인
                if (p[r].charAt(nc) == 'O' || p[nr].charAt(c) == 'O')
                    return true;
            }
        }
        return false;
    }
}
