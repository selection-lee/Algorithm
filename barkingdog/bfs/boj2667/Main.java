package barkingdog.bfs.boj2667;

import java.io.*;
import java.util.*;

/*
1. 입력받기 : 지도크기 N (N*N 정사각형), 자료 N줄(0 or 1)
2. 지도 전체 돌면서 1(집) 찾기
3. 집 발견하면 BFS로 단지 찾아서 번호 붙이기
 3.1 큐에 시작점 넣고 방문처리
 3.2 단지 크기 카운트 시작 (cnt = 1)
 3.3 큐가 빌 때까지 상하좌우 탐색
 3.4 방문 안 한 집 발견 시 큐에 삽입, 단지 크기 cnt++
 3.5 최종 단지 크기 반환
4. 단지 크기 리스트 오름차순 정렬, 총 단지수 출력, 단지 크기 출력
 */

public class Main {
    // 필요한 변수 선언
    static int N;
    static int[][] map;
    static boolean[][] visited;
    // 델타배열
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,-1,1};
    // 각 단지 집 개수 저장
    static ArrayList<Integer> complexSizes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // 1. 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // readLine : 예외처리 필수

        map = new int[N][N];
        visited = new boolean[N][N];

        // 지도 정보 입력(한 줄씩 문자열로 받아서 처리)
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j<N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        // 2. 전체 지도 탐색하기
        for (int i = 0; i <N; i++){
            for(int j = 0; j<N; j++){
                if(!visited[i][j] && map[i][j] == 1) {
                    complexSizes.add(bfs(i,j)); // 단지 크기 저장
                }
            }
        }

        // 4. 결과 출력하기
        Collections.sort(complexSizes); // 단지 크기 오름차순 정렬
        System.out.println(complexSizes.size());
        for(int size: complexSizes) { // 각 단지 집 개수
            System.out.println(size);
        }
    }

    // 3. BFS로 단지 내 집 수 계산하기
    static int bfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r,c});
        visited[r][c] = true;
        int cnt = 1; // 현재 단지의 집 개수

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];

                if (nr>=0 && nr<N && nc>=0 && nc<N) {
                    if(!visited[nr][nc] && map[nr][nc] == 1) {
                        queue.offer(new int[]{nr,nc});
                        visited[nr][nc] = true;
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}
