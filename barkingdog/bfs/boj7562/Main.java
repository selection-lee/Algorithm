package barkingdog.bfs.boj7562;

import java.io.*;
import java.util.*;

/*
1. 입력: 테케 개수, 각 테케(3줄-한 변 길이, 현재 좌표, 목표 좌표)
 1.1 visited는 각 테케마다 l*l로 초기화해야 함
2. (r,c)에서부터 바로 BFS로 탐색 ㄱㄱ
 2.1 필요한 변수 선언
 2.2 델타배열로 간 다음 위치 - 목표좌표가 아니면? 방문 처리, 큐에 삽입
  2.2.1 cnt++, minCnt는 언제??
  -> bfs라서 dfs와 달리 무조건 cnt가 min인가? : YES !!!
 2.3 목표좌표라면? - cnt 출력
*/

public class Main {
    static int tc; // 테케 개수
    static int sr, sc, er, ec;
    static int l; // 체스판 크기
    // 델타배열
    static int[] dr = {-1,-2,-2,-1,1,2,2,1};
    static int[] dc = {-2,-1,1,2,2,1,-1,-2};

    // bfs함수에서 쓸 변수들
    static boolean[][] visited; // 방문 배열은 2차원 배열!!!

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tc = Integer.parseInt(br.readLine()); // 테케 개수

        for (int i = 0; i < tc; i++) {
            // 체스판 크기
            l = Integer.parseInt(br.readLine());

            // visited 초기화
            visited = new boolean[l][l]; // 기본값은 f
            
            // 자바에서는 파이썬처럼 한 줄에 여러 변수 할당 불가
            // 입력받은 줄을 split()으로 나눠서 각각 할당해야 함

            // 현재 좌표 입력받기
            String[] cur = br.readLine().split(" ");
            // split(" "): 괄호 안의 문자(여기서는 공백)을 기준으로 구분된 문자열을 배열로 만든다
            sr= Integer.parseInt(cur[0]);
            sc = Integer.parseInt(cur[1]);

            // 목표 좌표 입력받기
            String[] end = br.readLine().split(" ");
            er = Integer.parseInt(end[0]);
            ec = Integer.parseInt(end[1]);

            System.out.println(bfs(sr, sc, er, ec));
        }
    }

    // static으로 선언한 sr,sc, ... 는 클래스의 멤버 변수
    // 이 함수의 매개변수로 들어가는 sr, sc, ... 는 지역변수
    public static int bfs(int sr, int sc, int er, int ec){
        // 큐는 bfs함수 내에서만 사용되는 지역적인 자료구조
        // -> 각 bfs 호출마다 새로운 탐색 시작해야 함 - 빈 상태에서 시작해야 함
        // static으로도 선언은 가능하지만, 매번 clear() 해줘야 돼서 불편함
        
        // 2.1 초기 변수 세팅
        Queue<int[]> queue = new LinkedList<>(); // 큐 선언
        queue.offer(new int[]{sr, sc, 0}); // (cr, cc, cnt)
        visited[sr][sc] = true; // 시작점 방문처리
        
        // 2.2 bfs 탐색
        // 큐가 빌 때까지 반복
        while(!queue.isEmpty()) {
            // 2.3 현재 위치 좌표 꺼내기
            int[] cur = queue.poll();
            int r = cur[0]; // cr
            int c = cur[1]; // cc
            int cnt = cur[2]; // 현재까지의 이동 횟수

            // 2.4 목표지점 도달 여부 체크
            if(r == er && c == ec) return cnt;

            // 2.5 도달 x 라면 다음 위치 탐색
            for(int i = 0; i < 8; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                // 2.6 다음 위치 갈 수 있으면 큐에 위치랑 이동횟수 삽입
                // 범위 내에 있는지 + 방문여부
                if(nr >=0 && nr < l && nc >= 0 && nc < l && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc, cnt + 1});
                }
            }
        }
        return 0; // 목표지점 도달 불가일 경우 (이 문제에선 없다)
    }
}
