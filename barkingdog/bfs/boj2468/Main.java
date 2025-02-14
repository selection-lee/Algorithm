package barkingdog.bfs.boj2468;

import java.io.*;
import java.util.*;

/*
1. 입력 받기 ( N*N 지역, N개 줄에 N행 높이 정보)
2. 필요한 변수 선언 (visited, 델타배열, 큐, ...)
3. for문으로 1~100까지 높이에 대해서 탐색
 3.1 각 높이별 탐색 시작 시 visited 초기화
 3.2 안정영역 개수 계산
 3.3 max 갱신
 */

public class Main {
    static int N;
    static boolean[][] visited; // 이건 for문 안에서 선언하면서 초기화해도 될 듯 => 안되네??
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int[][] map;
    static int maxCnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 영역 크기 N*N
        N = Integer.parseInt(br.readLine());

        // 지도 입력받기
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            // String[] Line = br.readLine().split(" "); // 문자열 입력받아서 공백 기준으로 배열에 넣기
            // ST가 더 속도가 빠르다고 함
            StringTokenizer st = new StringTokenizer(br.readLine()); // 6 8 2 입력 =>  ["6"]["8"]["2"] 이렇게 토큰 갖게 됨
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()); // 토큰(문자)을 하나씩 순서대로 가져옴. 순자로 변환. map 배열에 저장.
            }
        }

        // 높이별 탐색
        for (int height = 0; height <= 100; height++) {
            visited = new boolean[N][N]; // 전부 false로 초기화
            int cnt = 0;

            // N*N 탐색
            for(int r = 0; r < N; r++) {
                for(int c = 0; c < N; c++) {
                    // 미방문, 현재높이보다 높으면? bfs 시작하고 cnt++
                    if (!visited[r][c] && map[r][c] > height) {
                        bfs(r,c,height);
                        cnt++; // 안전영역 하나 발견
                    }
                }
            }

            if (maxCnt < cnt) maxCnt = cnt;
        }

        // 영역 갯수 최댓값 출력
        System.out.println(maxCnt);
    }

    public static int bfs(int r, int c, int height){
        // 1. 큐에다 좌표를 담아야 함
        Queue<int[]> queue = new LinkedList<>(); // 좌표 외에 추가 정보를 저장해야 할 때 Integer로 해서 래퍼클래스로 객체로 포장
        // 2. 첫 좌표 큐에 넣고 방문처리
        queue.offer(new int[]{r,c});
        visited[r][c] = true;
        // new int[] 새로운 int 배열 생성
        // {r,c} r,c값을 가진 배열 만들기
        // queue에 이 배열 삽입
        // 파이썬과 달리 자바에서는 좌표쌍을 큐에 넣으려면 반드시 배열이나 객체 형태로 만들어서 넣어야 함

        // 3. 큐 빌 때까지 탐색
        while (!queue.isEmpty()) {
            // 3.1 현재 좌표 꺼내기
            int[] cur = queue.poll();
            int cr = cur[0]; // 현재 row
            int cc = cur[1]; // 현재 col
            // 3.2 상하좌우 탐색
            // 3.2.1 좌표 유효하면 큐에 넣고 방문처리
            for (int d = 0; d < 4; d++){
                int nr = cr +dr[d];
                int nc = cc + dc[d];
                // 다음좌표가 범위 내에 있고 방문x이고 현재 높이보다 높으면
                if(nr >=0 && nr < N && nc >=0 && nc<N && !visited[nr][nc] && map[nr][nc] > height) {
                    // 유효하니까 큐에 넣고 방문처리
                    queue.offer(new int[]{nr,nc});
                    visited[nr][nc] = true;
                }
            }
        }
        return 0;
    }
}
