package DX.num1;

class UserSolution {

    private final static int MAX_N = 1000;
    private final static int MAX_M = 20;

    private int[][] fullMap; // 전체지도 저장하기 (1: 보물, 0: 빈칸)
    private int N, M; // 각 지도의 한 변의 길이 저장하기

    public void init(int N, int M, int Map[][]) {
        // 1. map 저장 - 패턴매칭하기
        this.N = N;
        this.M = M;
        fullMap = new int[N][N]; // 전체지도 N*N

        // Map을 fullMap으로 복사해오기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                fullMap[i][j] = Map[i][j];
            }
        }
    }

    // 90도, 180도, 270도 돌리기
    private int[][][] makeRotations(int[][] originPiece) {
        // 돌려질 애 저장할 변수
        int[][][] rotated = new int[4][M][M];

        // 돌리기 - 각 위치마다 4개 한 번에 계산
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                // 0도: [i][j]
                rotated[0][i][j] = originPiece[i][j];
                // 90도 회전: [j][M-1-i]
                rotated[1][j][M - 1 - i] = originPiece[i][j];
                // 180도 회전: [M-1-i][M-1-j]
                rotated[2][M - 1 - i][M - 1 - j] = originPiece[i][j];
                // 270도 회전: [M-1-j][i]
                rotated[3][M - 1 - j][i] = originPiece[i][j];
            }
        }
        // 반환값
        return rotated;
    }

    // 패턴이 같은지 검사하기
    private boolean checkPattern(int sy, int sx, int[][] pattern) {
        // sy, sx: 전체 지도에서 검사 시작할 위치
        // pattern: 검사할 회전된 조각 지도
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                if (pattern[i][j] != 0) { // 조각 지도에서 보물 있으면
                    // 전체 지도의 해당 위치에 보물 없으면 불일치인 것
                    if (fullMap[sy + i][sx + j] != 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public Solution.Result findTreasureChest(int Pieces[][]) {
        Solution.Result res = new Solution.Result();
        res.y = res.x = 0;

        // 2. 조각지도, 전체지도 비교
        // 2-1. 회전 : 90, 180, 270도 회전하는 각 경우마다 -> makeRotations
        // 2-2. 매칭 : 조각지도의 9, 1 들이 전체지도의 1들 위치와 일치해야 함 -> checkPattern

        // 조각지도 4가지 방향 만들기 - makeRotations는 3차원배열 반환
        int[][][] rotations = makeRotations(Pieces);

        // 기준보물 좌표 (r,c)
        int[][] basis = new int[4][2];
        // basis[0][0] = 0도에서 기준보물 r좌표
        // basis[0][1] = 0도에서 기준보물 c좌표
        // basis[1] -> 90도

        // 각 회전된 조각에서 기준 보물(9)의 위치 저장하기
        // -> 이중for문 돌려서 찾기??
        // 아니지 rotated변수가 3차원이니까 3중포문....
        for (int r = 0; r < 4; r++) { // r: rotated의 첫 row - 회전 각도별로 순회하기
            for (int i = 0; i < M; i++) { // x축
                for (int j = 0; j < M; j++) { // y축
                    if (rotations[r][i][j] == 9) {
                        basis[r][0] = i; // 현재 각도에서 기준보물 y좌표 (row) 저장
                        basis[r][1] = j; // ~~ x좌표(col)
                    }
                }
            }
        }


        // 전체 지도를 순회하면서
        for (int y = 0; y <= N - M; y++) {
            for (int x = 0; x <= N - M; x++) { // cf. 마지막 인덱스도 포함해야 전체 순회 가능....ㅠ
                // 각 위치에서 회전된 4가지 경우에 대해
                for (int r = 0; r < 4; r++) { /* 회전된 4가지 각 조각지도 */
                    // 패턴 일치 여부 체크하기
                    // 만약 현재 위치에서 패턴 일치하면??
                    if (checkPattern(y, x, rotations[r])) {
                        // 기준 보물 전체 지도에서의 좌표 반환하기
                        res.y = y + basis[r][0];
                        res.x = x + basis[r][1];
                        return res;
                    }
                }
            }
        }
        return res;
    }
}
