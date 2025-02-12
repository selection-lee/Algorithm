package barkingdog.bfs.boj5014;

import java.io.*;
import java.util.*;

/*
1. BFS를 위한 Queue 생성 및 방문 체크용 배열 생성
2. 현재 위치(S)를 시작점으로 BFS 탐색 시작
3. 현재 위치에서 위로(U) 또는 아래로(D) 이동 가능한 경우 탐색
4. 목표 층(G)에 도달하면 버튼 클릭 횟수 반환
5. 도달 x -> "use the stairs" 출력
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력값 받기
        int F = Integer.parseInt(st.nextToken()); // 건물의 총 층수
        int S = Integer.parseInt(st.nextToken()); // 현재 위치
        int G = Integer.parseInt(st.nextToken()); // 목표 층
        int U = Integer.parseInt(st.nextToken()); // 위로 이동 가능한 층수
        int D = Integer.parseInt(st.nextToken()); // 아래로 이동 가능한 층수

        // BFS 실행
        int result = bfs(F, S, G, U, D);

        // 결과 출력
        System.out.println(result == -1 ? "use the stairs" : result);
    }

    static int bfs(int F, int S, int G, int U, int D) {
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[F + 1]; // 방문 체크 및 버튼 클릭 횟수 저장

        // 시작점 설정
        queue.offer(S);
        visited[S] = 1; // 시작 위치 방문 표시 (1부터 시작하여 나중에 1을 빼줌)

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // 목표 층에 도달한 경우
            if (current == G) {
                return visited[current] - 1; // 시작점을 1로 시작했으므로 1을 빼줌
            }

            // 위로 이동하는 경우
            if (current + U <= F && visited[current + U] == 0) {
                queue.offer(current + U);
                visited[current + U] = visited[current] + 1;
            }

            // 아래로 이동하는 경우
            if (current - D > 0 && visited[current - D] == 0) {
                queue.offer(current - D);
                visited[current - D] = visited[current] + 1;
            }
        }

        return -1; // 목표 층에 도달할 수 없는 경우
    }
}
