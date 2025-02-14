package barkingdog.bfs.boj1012;

import java.io.*;
import java.util.*;

public class Main {
    static int M, N, K; // 배추밭의 가로길이(M), 세로길이(N), 배추 위치의 개수(K)
    static int[][] field; // 배추밭을 나타내는 2차원 배열
    static boolean[][] visited; // 방문 여부를 체크하는 2차원 배열
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우 이동을 위한 x좌표 변화량
    static int[] dy = {0, 0, -1, 1}; // 상하좌우 이동을 위한 y좌표 변화량

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

        // 각 테스트 케이스 처리
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 배추밭의 가로길이
            N = Integer.parseInt(st.nextToken()); // 배추밭의 세로길이
            K = Integer.parseInt(st.nextToken()); // 배추의 위치 개수

            // 배추밭과 방문 배열 초기화
            field = new int[M][N];
            visited = new boolean[M][N];

            // 배추 위치 입력 받기
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                field[x][y] = 1; // 배추가 있는 위치는 1로 표시
            }

            int count = 0; // 필요한 지렁이의 수

            // 전체 배추밭을 탐색하면서 배추 군집 찾기
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    // 배추가 있고 아직 방문하지 않은 위치라면
                    if (field[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j); // BFS로 연결된 배추 탐색
                        count++; // 하나의 군집을 찾았으므로 지렁이 수 증가
                    }
                }
            }

            System.out.println(count); // 필요한 지렁이의 수 출력
        }
    }

    // BFS로 연결된 배추들을 탐색하는 메소드
    static void bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>(); // BFS를 위한 큐 생성
        queue.offer(new int[]{startX, startY}); // 시작 위치를 큐에 삽입
        visited[startX][startY] = true; // 시작 위치 방문 처리

        // 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            int[] current = queue.poll(); // 현재 위치
            int x = current[0];
            int y = current[1];

            // 상하좌우 네 방향에 대해 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i]; // 새로운 x좌표
                int ny = y + dy[i]; // 새로운 y좌표

                // 새로운 좌표가 배추밭 범위 내에 있고
                if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                    // 배추가 있으며 아직 방문하지 않은 위치라면
                    if (field[nx][ny] == 1 && !visited[nx][ny]) {
                        queue.offer(new int[]{nx, ny}); // 큐에 새로운 위치 삽입
                        visited[nx][ny] = true; // 방문 처리
                    }
                }
            }
        }
    }
}
