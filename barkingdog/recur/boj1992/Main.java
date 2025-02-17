package barkingdog.recur.boj1992;

import java.util.*;

public class Main {
    // 흑백 이미지를 저장할 2차원 배열
    // 0은 흰색, 1은 검은색을 나타냄
    public static int[][] img;

    // 결과를 저장할 StringBuilder
    // String을 직접 더하는 것보다 성능이 좋음
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // N x N 크기의 영상을 입력받음 (N은 2의 제곱수)
        int N = in.nextInt();
        img = new int[N][N];

        // 영상 데이터 입력받기
        // 입력은 0과 1로 구성된 문자열 형태로 주어짐
        for(int i = 0; i < N; i++) {
            String str = in.next();
            for(int j = 0; j < N; j++) {
                // 문자 '0'이나 '1'을 숫자로 변환하여 저장
                // 예: '0' - '0' = 0, '1' - '0' = 1
                img[i][j] = str.charAt(j) - '0';
            }
        }

        // 전체 영상에 대해 쿼드트리 압축 시작
        QuadTree(0, 0, N);

        // 압축 결과 출력
        System.out.println(sb);
    }

    /**
     * 쿼드트리 압축을 수행하는 재귀 함수
     * @param x 현재 검사할 영역의 시작 x좌표
     * @param y 현재 검사할 영역의 시작 y좌표
     * @param size 현재 영역의 한 변의 길이
     */
    public static void QuadTree(int x, int y, int size) {
        // 현재 영역이 모두 같은 색으로 이루어져 있는지 확인
        if(isPossible(x, y, size)) {
            // 같은 색이면 해당 색상값만 추가
            sb.append(img[x][y]);
            return;
        }

        // 압축이 불가능한 경우 영역을 4등분
        int newSize = size / 2;

        // 분할된 영역의 시작을 표시하는 '(' 추가
        sb.append('(');

        // 4개의 부분으로 나누어 재귀적으로 압축 수행
        // 순서는 왼쪽 위, 오른쪽 위, 왼쪽 아래, 오른쪽 아래
        QuadTree(x, y, newSize);                       // 왼쪽 위
        QuadTree(x, y + newSize, newSize);            // 오른쪽 위
        QuadTree(x + newSize, y, newSize);            // 왼쪽 아래
        QuadTree(x + newSize, y + newSize, newSize);  // 오른쪽 아래

        // 분할된 영역의 끝을 표시하는 ')' 추가
        sb.append(')');
    }

    /**
     * 주어진 영역이 모두 같은 색인지 확인하는 함수
     * @param x 검사할 영역의 시작 x좌표
     * @param y 검사할 영역의 시작 y좌표
     * @param size 검사할 영역의 한 변의 길이
     * @return 모든 픽셀이 같은 색이면 true, 다른 색이 있으면 false
     */
    public static boolean isPossible(int x, int y, int size) {
        // 영역의 첫 번째 픽셀 값을 기준으로 삼음
        int value = img[x][y];

        // 영역 내 모든 픽셀을 검사
        for(int i = x; i < x + size; i++) {
            for(int j = y; j < y + size; j++) {
                // 기준 값과 다른 값이 있으면 압축 불가능
                if(value != img[i][j]) {
                    return false;
                }
            }
        }
        // 모든 픽셀이 같은 값이면 압축 가능
        return true;
    }
}