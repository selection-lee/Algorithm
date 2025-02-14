package barkingdog.bfs.boj2178;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M; // 미로의 크기 (N x M)
    static int[][] maze; // 미로를 저장할 2차원 배열
    static int[][] distance; // 각 칸까지의 최단 거리를 저장할 배열
    // 델타배열
    static int[] dx = {-1, 1, 0, 0}; 
    static int[] dy = {0, 0, -1, 1}; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 미로의 크기 입력 받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 미로와 거리 배열 초기화
        maze = new int[N][M];
        distance = new int[N][M];

        // 미로 정보 입력 받기
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = line.charAt(j) - '0';
                distance[i][j] = -1; // 방문하지 않은 칸은 -1로 초기화
            }
        }

        // BFS로 최단 경로 찾기
        bfs(0, 0);

        // 도착점까지의 최단 거리 출력 (시작점도 포함하므로 +1)
        System.out.println(distance[N-1][M-1]);
    }

    // BFS로 최단 경로를 찾는 메소드
    static void bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        distance[startX][startY] = 1; // 시작 위치의 거리는 1

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            // 상하좌우 네 방향에 대해 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 새로운 위치가 미로 범위 내에 있고
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    // 이동할 수 있는 칸(1)이며 아직 방문하지 않은 곳(-1)이라면
                    if (maze[nx][ny] == 1 && distance[nx][ny] == -1) {
                        queue.offer(new int[]{nx, ny});
                        // 이전 칸까지의 거리 + 1을 현재 칸의 거리로 저장
                        distance[nx][ny] = distance[x][y] + 1;
                    }
                }
            }
        }
    }
}
