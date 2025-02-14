package barkingdog.deque.boj10866;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringBuilder로 한 번에 출력하면 시간 절약 가능
        StringBuilder sb = new StringBuilder();

        // LinkedList로 덱 구현: 양방향 연결리스트라서 앞뒤 삽입,삭제가 O(1)
        Deque<Integer> deque = new LinkedList<>();

        int N = Integer.parseInt(br.readLine()); // throws IOException 있어야 함

        while (N-- > 0) {
            // 공백 기준으로 명령어 분리하기
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push_front":
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    // 비어있으면 -1, 아니면 첫 번째 요소 제거 후 반환
                    sb.append(deque.isEmpty() ? -1 : deque.pollFirst()).append('\n');
                    break;
                case "pop_back":
                    sb.append(deque.isEmpty() ? -1 : deque.pollLast()).append('\n');
                    break;
                case "size":
                    sb.append(deque.size()).append('\n');
                    break;
                case "empty":
                    sb.append(deque.isEmpty() ? 1 : 0).append('\n');
                    break;
                case "front":
                    sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append('\n');
                    break;
                case "back":
                    sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }
}
