package barkingdog.queue.boj10845;

import java.util.Scanner;
//import java.util.Queue;
import java.util.LinkedList;

public class TimeOver {
    public static void main(String[] args) {
        // Scanner 객체 생성
        Scanner sc = new Scanner(System.in);

        // Queue 인터페이스를 구현하는 LinkedList 생성
        LinkedList<Integer> queue = new LinkedList<>();

        // 명령어 개수 입력 받기
        int n = sc.nextInt();

        // nextInt() 후의 개행문자 처리
        sc.nextLine();

        while (n-- > 0) {
            // 명령어 입력 받기
            String command = sc.nextLine();

            // 공백을 기준으로 명령어 분리
            String[] parts = command.split(" ");

            switch (parts[0]) {
                case "push":
                    // push 명령어: 큐에 값 추가
                    queue.offer(Integer.parseInt(parts[1]));
                    break;

                case "pop":
                    // pop 명령어: 큐가 비어있으면 -1, 아니면 첫 번째 값 출력 후 제거
                    System.out.println(queue.isEmpty() ? -1 : queue.poll());
                    break;

                case "size":
                    // size 명령어: 큐의 현재 크기 출력
                    System.out.println(queue.size());
                    break;

                case "empty":
                    // empty 명령어: 큐가 비어있으면 1, 아니면 0 출력
                    System.out.println(queue.isEmpty() ? 1 : 0);
                    break;

                case "front":
                    // front 명령어: 큐가 비어있으면 -1, 아니면 첫 번째 값 출력
                    System.out.println(queue.isEmpty() ? -1 : queue.peek());
                    break;

                case "back":
                    // back 명령어: 큐가 비어있으면 -1, 아니면 마지막 값 출력
                    System.out.println(queue.isEmpty() ? -1 : queue.getLast());
                    break;
            }
        }

        sc.close();
    }
}
