package barkingdog.queue.boj10845;

import java.io.*;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        // Scanner 쓰니까 시간초과 ㅠㅠㅠ
        // 입력을 위한 BufferedReader 선언
        // InputStreamReader를 통해 바이트 스트림을 문자 스트림으로 변환
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 출력을 저장할 StringBuilder
        // System.out.println()을 여러번 쓰는 것보다 한번에 출력하는 것이 효율적
        StringBuilder sb = new StringBuilder();

        // LinkedList로 큐 구현
        // LinkedList는 Queue 인터페이스를 구현하고 있어 큐로 사용 가능
        LinkedList<Integer> queue = new LinkedList<>();

        // 첫 번째 줄에서 명령어의 수 n을 입력받음
        // br.readLine()으로 한 줄을 읽고 Integer.parseInt로 정수로 변환
        int n = Integer.parseInt(br.readLine());

        // n번 만큼 명령어를 처리
        while (n-- > 0) {
            // 한 줄을 읽어서 공백을 기준으로 분리
            // ex) "push 1" -> command[0]="push", command[1]="1"
            String[] command = br.readLine().split(" ");

            // 명령어(command[0])에 따라 다른 동작 수행
            switch (command[0]) {
                case "push":
                    // push 명령어: 큐의 뒤에 새로운 정수 추가
                    // command[1]을 정수로 변환하여 큐에 추가
                    queue.offer(Integer.parseInt(command[1]));
                    break;

                case "pop":
                    // pop 명령어: 큐의 가장 앞에 있는 정수를 빼고 출력
                    // 큐가 비어있으면 -1 출력
                    // poll(): 큐의 첫 번째 요소를 제거하고 반환
                    sb.append(queue.isEmpty() ? -1 : queue.poll()).append('\n');
                    break;

                case "size":
                    // size 명령어: 큐에 들어있는 정수의 개수 출력
                    sb.append(queue.size()).append('\n');
                    break;

                case "empty":
                    // empty 명령어: 큐가 비어있으면 1, 아니면 0 출력
                    // isEmpty(): 큐가 비어있는지 확인하는 메서드
                    sb.append(queue.isEmpty() ? 1 : 0).append('\n');
                    break;

                case "front":
                    // front 명령어: 큐의 가장 앞에 있는 정수 출력
                    // 큐가 비어있으면 -1 출력
                    // peek(): 큐의 첫 번째 요소를 제거하지 않고 반환
                    sb.append(queue.isEmpty() ? -1 : queue.peek()).append('\n');
                    break;

                case "back":
                    // back 명령어: 큐의 가장 뒤에 있는 정수 출력
                    // 큐가 비어있으면 -1 출력
                    // getLast(): LinkedList의 마지막 요소 반환
                    sb.append(queue.isEmpty() ? -1 : queue.getLast()).append('\n');
                    break;
            }
        }

        // StringBuilder에 저장된 모든 결과를 한번에 출력
        System.out.print(sb);

        // 입력 스트림 닫기
        br.close();
    }
}
