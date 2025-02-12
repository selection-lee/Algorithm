package barkingdog.bfs.boj2468;

import java.io.*;
import java.util.*;

/*
1. 지역의 높이 정보를 2차원 배열로 입력받기
2. 가능한 모든 비의 양(높이)에 대해 반복
   - 최소 높이부터 최대 높이까지 각각의 경우 확인
3. 각 높이별로 안전 영역 개수 계산
   - DFS로 잠기지 않는 영역 탐색
4. 안전 영역의 최대 개수 출력
*/

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    // 상하좌우 이동을 위한 방향 배열
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 지역의 크기 N 입력
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        // 지역의 높이 정보 입력받기
        int maxHeight = 0; // 최대 높이 저장
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }

        // 각 높이별로 안전 영역 개수 계산
        int maxSafeArea = 1; // 아무 지역도 물에 잠기지 않는 경우 기본값 1

        // 높이 0부터 최대 높이까지 반복
        for(int height = 0; height < maxHeight; height++) {
            visited = new boolean[N][N];
            int safeArea = 0;

            // 모든 지점을 확인하며 안전 영역 탐색
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    // 방문하지 않았고, 현재 높이보다 높은 지점에서 DFS 시작
                    if(!visited[i][j] && map[i][j] > height) {
                        dfs(i, j, height);
                        safeArea++;
                    }
                }
            }

            // 최대 안전 영역 개수 갱신
            maxSafeArea = Math.max(maxSafeArea, safeArea);
        }

        System.out.println(maxSafeArea);
    }

    // DFS로 안전 영역 탐색
    static void dfs(int x, int y, int height) {
        visited[x][y] = true;

        // 상하좌우 네 방향 탐색
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 배열 범위 내에 있고
            if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
                // 방문하지 않았으며, 현재 높이보다 높은 지점이라면 계속 탐색
                if(!visited[nx][ny] && map[nx][ny] > height) {
                    dfs(nx, ny, height);
                }
            }
        }
    }
}
