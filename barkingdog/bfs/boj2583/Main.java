package barkingdog.bfs.boj2583;

import java.io.*;
import java.util.*;

/*
분리된 각 영역의 넓이가 얼마인지
1. 입력받기
 1.1 M:row, N:col, K: 벽 개수
 1.2 K개 직사각형 좌표
2. 필요한 변수 선언
 2.1 지도(벽은 1로 처리하고 빈공간은 0으로 처리할까)
 2.2 visited, N, M, K, 큐, cnt, ...
3. (M+1)*(N+1) 모눈종이 탐색 // 주의!!!
 3.1 for m, for n, if [m][n] == 0: bfs로 탐색, bfs 끝나면 영역개수++;
 3.2 각 영역 넓이는 어떻게 count? bfs 탐색 하면서 while문 안에서 범위안이고 !visited에 0(벽x)면 넓이 ++,
 3.3 넓이는 bfs 끝날 때마다 static 배열에 저장해놓고 맨 마지막에 출력하면 되겠다.
  3.3.1 근데 자동으로 오름차순 정렬 하는 자료형은???

 */
public class Main {
    static int M, N, K;
    static int[][] walls; // 직사각형 벽 좌표 저장할 배열
    static int[][] map;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static boolean[][] visited;
    static ArrayList<Integer> areas = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        M = Integer.parseInt(line[0]);
        N = Integer.parseInt(line[1]);
        K = Integer.parseInt(line[2]);
        // 전체 맵 0으로 초기화, 방문 배열 초기화
        map = new int[M][N]; // 좌표 점과 좌표 칸을 헷갈리지 말자... 여기서는 점은 0~M이지만, 칸은 0~M-1이 맞음,,
        visited = new boolean[M][N];

        // K개 벽 정보 입력받기
        for (int i = 0; i<K;i++) {
            String[] wall = br.readLine().split(" ");
            int c1 = Integer.parseInt(wall[0]);
            int r1 = Integer.parseInt(wall[1]);
            int c2 = Integer.parseInt(wall[2]);
            int r2 = Integer.parseInt(wall[3]); // 끝 점 좌표에서 -1 빼야 칸 좌표 됨

            // 벽 영역 map에 1로 표시
            // 왜 r,c가 반대로....??????
            // 아하 내가 input이 x,y라서 c,r로 받아야 하는데 순서를 바꿔서 받은 거였음,,,
            for (int r = r1; r < r2; r++){
                for (int c = c1; c < c2; c++) {
                    map[r][c] = 1; // 벽
                }
//                System.out.println("map "+ Arrays.toString(map[r]));
            }
        }


        // 전체 맵 탐색하면서 빈 영역 나오면 bfs ㄱㄱ
        int cnt = 0; //분리된 영역 개수
        for (int r = 0; r < M; r++) {
            for(int c = 0; c<N; c++) {
                if(map[r][c] == 0 && !visited[r][c]) {
                    bfs(r,c);
                    cnt++;
//                    System.out.println("중간 cnt: " + cnt);
                }
            }
        }

        // 출력
        Collections.sort(areas); // 영역 넓이 오름차순으로 정렬
        System.out.println(cnt); // 영역 개수 출력
//        System.out.println("areas" + areas);
        for(int area: areas) {
            System.out.print(area + " "); // 각 영역 넓이 출력
        }
    }
    public static void bfs(int r, int c) {
        // 1. 필요한 변수 선언
        Queue<int[]> queue = new LinkedList<>();
        int area = 1; // 현재 영역의 넓이
        // 2. 첫 항 삽입, 방문처리
        queue.offer(new int[]{r, c});
        visited[r][c] = true;
        // 3. 탐색 시작
        while (!queue.isEmpty()) {
            // 큐에서 현재 좌표 꺼내고
            int[] cur = queue.poll();

            // 상하좌우 탐색
            for(int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                // 다음 위치가 범위 내/ 방문 안했다면
                if (nr >= 0 && nr < M && nc >= 0 && nc < N && !visited[nr][nc] && map[nr][nc] == 0) {
                    queue.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                    area++; // 영역 넓이 ++
                }
            }
        }
        areas.add(area);
    }
}
