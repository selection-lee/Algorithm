package barkingdog.bfs.boj1926;

import java.io.*;
import java.util.*;

/*
1. 도화지 크기 n,m 이랑 그림 정보 입력받기
2. 도화지 전체 순회하면서 그림(1) 찾기
3. 그림 발견 시 BFS로 넓이 계산하기
 3.1 큐에 시작점 넣고 방문처리
 3.2 큐가 빌 떄까지 상하좌우 탐색
 3.3 방문하지 않은 그림 영역 발견 시 큐에 삽입
4. 그림 개수, 최대 넓이 출력하기
 */
public class Main {
    // 도화지 크기(n×m), 도화지 배열, 방문체크 배열
    static int n, m;
    static int[][] paper;
    static boolean[][] visited;
    // 4방향 탐색을 위한 델타배열 (상하좌우)
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1. 입력 처리
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        paper = new int[n][m];
        visited = new boolean[n][m];

        // 도화지 정보 입력
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;  // 그림의 총 개수
        int maxArea = 0;  // 가장 큰 그림의 넓이

        // 2. 도화지 전체 순회
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 방문하지 않은 그림(1) 발견시 BFS 시작
                if (!visited[i][j] && paper[i][j] == 1) {
                    count++;  // 그림 개수 증가
                    maxArea = Math.max(maxArea, bfs(i, j));  // 최대 넓이 갱신
                }
            }
        }

        // 4. 결과 출력
        System.out.println(count);
        System.out.println(maxArea);
    }

    // 3. BFS로 그림의 넓이 계산
    static int bfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});  // 시작점 큐에 추가
        visited[r][c] = true;  // 방문 처리
        int area = 1;  // 그림의 넓이 (시작점 포함)

        // 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();  // 현재 위치

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nr = curr[0] + dr[i];  // 새로운 행 위치
                int nc = curr[1] + dc[i];  // 새로운 열 위치

                // 도화지 범위 내이고
                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    // 방문하지 않은 그림 영역이면
                    if (!visited[nr][nc] && paper[nr][nc] == 1) {
                        queue.offer(new int[]{nr, nc});  // 큐에 추가
                        visited[nr][nc] = true;  // 방문 처리
                        area++;  // 넓이 증가
                    }
                }
            }
        }
        return area;  // 계산된 넓이 반환
    }
}
