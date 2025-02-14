package barkingdog.deque.boj1021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 큐의 크기
        int M = Integer.parseInt(st.nextToken()); // 뽑을 수의 개수

        // LinkedList로 덱 구현하기
        LinkedList<Integer> deque = new LinkedList<>();

        // 1부터 N까지 덱에 넣기
        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        // 뽑아야 할 수의 위치들
        st = new StringTokenizer(br.readLine());
        int count = 0; // 2,3번 연산 의 총 횟수,,

        for (int i = 0; i < M; i++ ) {
            int target = Integer.parseInt(st.nextToken());
            int targetIdx = deque.indexOf(target);

            // 왼쪽 이동할지 오른쪽으로 이동할지 결정
            // 덱의 크기의 절반보다 작으면 왼쪽으로, 크면 오른쪽으로
            if (targetIdx <= deque.size() / 2) {
                // 왼쪽으로 이동
                while (deque.peekFirst() != target) {
                    deque.addLast(deque.pollFirst());
                    count++;
                }
            } else {
                // 오른쪽으로 이동
                while (deque.peekFirst() != target) {
                    deque.addFirst(deque.pollLast());
                    count++;
                }
            }

            // 여기까지 오면 원하는 수를 찾은 것 -> 제거하기
            deque.pollFirst();
        }
        System.out.println(count);
    }
}
