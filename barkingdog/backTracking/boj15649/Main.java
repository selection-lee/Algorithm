package barkingdog.backTracking.boj15649;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    // 파이썬 전역변수를 java에서는 클래스의 멤버변수로 선언
    static int N, M;
    static boolean[] visited;

    public static void main(String[] args) {
        // 파이썬 input().split() -> 스캐너로 대체
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        visited = new boolean[N + 1]; // 파이썬 v = [0]*(N+1)

        // 초기 호출 시 빈 ArrayList 전달
        dfs(0, new ArrayList<Integer>());

        sc.close();
    }

    // 파이썬으로 풀 때는 list였는데 java로 arrayList로 대체
    static void dfs(int n, ArrayList<Integer> sub) {
        // 1. 종료조건 - 가능한 n에 관련되게! 
        if (n == M) {
            // 정답 처리: 선택한 숫자들을 출력
            for (int i = 0; i < sub.size(); i++) {
                System.out.print(sub.get(i));
                if (i < sub.size() - 1) System.out.print(" ");
            }
            System.out.println();
            return;
        }

        // 2. 재귀호출
        for (int j = 1; j <= N; j++) {
            if (!visited[j]) {
                // 방문 안했으면
                visited[j] = true;
                // 다음 단계는 무조건 가는데, j 넣어준 후에!
                // 파이썬이었으면: dfs(n + 1, sub + [j]) # 새로운 리스트 만들어서 전달
                sub.add(j); // 현재 리스트에 j 추가
                dfs(n + 1, sub); // 같은 리스트를 재귀 호출에 사용해버림
                sub.remove(sub.size() - 1); // 백트래킹 시 마지막 요소 빼는 것 (이번 재귀 호출 끝났으니까 좀 전에 넣은 j를 제거하는 것)
                visited[j] = false;
            }
        }

    }
}
