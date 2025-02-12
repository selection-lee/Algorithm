package barkingdog.bfs.boj1697;

import java.io.*;
import java.util.*;

/*
1. 입력받기
 1.1 수빈 위치 N, 동생 위치 K
2. bfs 탐색 (while로 큐 isEmpty true 될 때까지)
 2.1 시작점은 N
 2.2 델타배열 필요 한가?
  2.2.1 nr = cr + 1, cr - 1, cr * 2 로 각각 보내면 되는 거 아닌가? 그럼 dfs인가?
  2.2.3 bfs 내에서 선언해도 충분함
 */

public class Main {
    static int N, K; // 시작, 도착 좌표

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int line = Integer.parseInt(br.readLine()); => 처음부터 parseInt x , split 이후에!
        // 문자열 배열로 input 받아오기
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        K = Integer.parseInt(line[1]);

        // 목표지점 도달 가장 빠른 시간 몇 초 후 출력
        System.out.println(bfs(N,K));
    }

    // s 시작점, e 도착점
    public static int bfs(int s,int e) {
        // 1. 초기 변수 세팅
        // visited 필요한가? 굳이..? 흠 일단 보류
        // => 안그럼 무한루프 걸릴 수도 있어서 안 됨!!!
        // 큐도 사실 int 값 하나씩만 넣으면 되니까 상관없지않나?
//        Queue<Integer> queue = new LinkedList<>();
        // => 걸린 시간을 출력해야 해서 ㄴㄴ
        // 물론 이렇게 쓰고 time 배열 따로 쓰면 메모리는 더 써도 큐가 더 가볍긴 함
        // 나는 추가 배열 안 쓸 것이다
        Queue<int[]> queue = new LinkedList<>(); // [위치, 시간] 삽입할 것
        boolean[] visited = new boolean[100001]; // 점 범위가 0~100,000 이라서

        queue.offer(new int[]{s, 0}); // {시작점, 걸린시간} 큐에 삽입
        visited[s] = true; // 시작점 방문처리

        // 2. 큐 빌 때까지 탐색
        while(!queue.isEmpty()) {
            // 2.1 현재 위치 꺼내기
            int[] cur = queue.poll();
            int now = cur[0], sec = cur[1];

            if (now == e) return sec; // 도착하면 초 반환

            // 델타배열 대신,, 현재위치 기준으로
            int[] nextPosition = {now - 1, now + 1, now * 2};
            // 순회하면서 가능한 경우 좌표 넣고 방문처리
            for(int nx: nextPosition) { // for-each 문-> for(타입 변수명 : 배열 or 컬렉션) { ~ }
                // 범위 내에 있다면, 방문 안 했다면 ㄱㄱ
                if (nx < 0 || nx > 100000 || visited[nx]) continue; // 범위 밖, 방문했으면 패스
                // 여기 오면 가능한거니까 삽입하고 방문처리
                queue.offer(new int[]{nx, sec + 1});
                visited[nx] = true;
            }
        }
        return -1; // 이 문제에서는 항상 목표지점 도달 가능해서 여기까지 올 일이 없음
    }
}
