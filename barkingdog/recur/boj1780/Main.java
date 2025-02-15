package barkingdog.recur.boj1780;

import java.io.*;

/*
1. 입력 받기
2. 종료 조건 찾기
3. 재귀 호출
  - 인자와 종료조건이 제일 중요!!
  3.1 종료 조건
    - 주어진 영역이 모두 같은 숫자인지 어떻게 확인?
  3.2 현재 단계에서 수행할 로직 (필요 시)
  3.3 재귀 호출(문제를 더 작은 문제로 나누기)
    - 동일한 사이즈로 9개로 나누려면?
    - 9개 영역의 시작점은 어떻게 계산?
 */
public class Main {
    static int N;
    static int[][] paper;
    // 결과로 출력할 것: -1,0,1로 채워진 각 종이 개수
    static int minus = 0;
    static int zero = 0;
    static int plus = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 종이 N*N 사이즈
        N = Integer.parseInt(br.readLine());
        // 종이 숫자
        paper = new int[N][N]; // 종이 초기화
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(line[j]);
            }
        }
        cut(0, 0, N);
//        System.out.println(Arrays.deepToString(paper));
        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);
    }

    // 시작 좌표, 현재 검사할 종이의 크기를 인자로 받아야 함
    public static void cut(int row, int col, int size) {
        // 1. 시작점부터 size 영역 검사하는데
        // 만약 첫 번째 숫자와 다른 숫자가 나오면 바로 false 리턴
        // 단, 종이 같은숫자 여부 검사는 함수 분리하는 게 좋음
        // 1.1 현재 영역이 모두 같은 숫자인지 체크
        if (isNumSame(row, col, size)) {
            // 같은 숫자일 경우 그 숫자 종이 개수 ++
            int num = paper[row][col];
            if (num == -1) minus++;
            else if (num == 0) zero++;
            else plus++;
            return;
        }
        // 여기까지 오면 종이 안 숫자가 다른 것
        // 2. 종이를 9개로 나누기 (3*3 형태로 반복해야 함)
        int newSize = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // 새로운 시작점 계산해야 함
                // row + (i*newSize) : 새로운 행 시작점
                cut(row + (i * newSize), col + (j * newSize), newSize);
            }
        }
    }

    // 종이 내부 숫자 같은지
    public static boolean isNumSame(int row, int col, int size) {
        // 첫 번째 숫자를 기준값으로 설정
        int start = paper[row][col];

        // 입력 내 모든 숫자를 기준값이랑 비교
        for (int r = row; r < row + size; r++) {
            for (int c = col; c < col + size; c++) {
                if (paper[r][c] != start) return false;
            }
        }
        // 여기까지 오면 종이의 모든 숫자 같은 거
        return true;
    }
}
