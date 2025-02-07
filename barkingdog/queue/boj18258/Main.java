package barkingdog.queue.boj18258;

import java.io.*;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        /* 입출력 스트림 */
        // BufferedReader: Scanner보다 빠른 입력을 위해 사용
        // (Scanner는 정규식 파싱 해서 느림
        // : 공백 기준으로 문자열 나누는데, 스페이스, /t, /n, etc 모두 인식하는 거라서 이런 구분자 인식 위해 내부적으로 정규식 패턴 매칭 수행함
        // 즉, in.nextInt() 하면 정규식으로 파싱한 후에 숫자 추출을 해서 상대적으로 느리다는 것
        // br은 parseInt(br.readLine()) 하면 단순 문자열을 정수로 변환해서 더 빠름.
        // System.in(바이트스트림)을 InputStreamReader로 문자스트림으로 변환 후 버퍼링
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // StringBuilder: 문자열을 직접 더하는 것보다 효율적인 문자열 조작을 위해 사용
        // 매번 System.out.println()을 호출하는 대신 StringBuilder에 결과를 저장했다가 마지막에 한 번에 출력
        StringBuilder sb = new StringBuilder();

        /* 자료구조 초기화 */
        // LinkedList를 사용한 큐 구현
        // - LinkedList는 양방향 연결 리스트로 구현되어 있어 앞/뒤 요소 접근이 O(1)
        // - Queue 인터페이스를 구현하고 있어 큐의 모든 기능 사용 가능
        // - ArrayList와 달리 중간 삽입/삭제가 O(1)이며, 메모리를 동적으로 할당
        LinkedList<Integer> queue = new LinkedList<>();

        /* 입력 처리 시작 */
        // 첫 줄에서 명령어의 수 N을 입력받음 (1 ≤ N ≤ 2,000,000)
        // readLine()으로 한 줄을 읽고 Integer.parseInt로 정수로 변환
        int n = Integer.parseInt(br.readLine());

        // n번의 명령어를 처리하는 반복문
        while (n-- > 0) {
            // 한 줄을 읽어서 공백(" ")을 기준으로 분리
            // ex) "push 1" -> command[0]="push", command[1]="1"
            String[] command = br.readLine().split(" ");

            /* 명령어 분기 처리 */
            switch (command[0]) {
                case "push":
                    // push X: 정수 X를 큐에 넣는 연산
                    // command[1]을 정수로 변환하여 큐의 뒤에 추가
                    // offer() 메서드: add()와 비슷하지만, 용량 제한 시 예외 대신 false 반환
                    queue.offer(Integer.parseInt(command[1]));
                    break;

                case "pop":
                    // pop: 큐에서 가장 앞에 있는 정수를 빼고 출력
                    // poll() 메서드: 큐가 비어있으면 null 반환, remove()는 예외 발생
                    // 삼항 연산자 사용: (조건) ? (참일 때 값) : (거짓일 때 값)
                    sb.append(queue.isEmpty() ? -1 : queue.poll()).append('\n');
                    break;

                case "size":
                    // size: 큐에 들어있는 정수의 개수 출력
                    // size() 메서드: 컬렉션의 현재 요소 개수 반환
                    sb.append(queue.size()).append('\n');
                    break;

                case "empty":
                    // empty: 큐가 비어있으면 1, 아니면 0 출력
                    // isEmpty() 메서드: 컬렉션이 비어있으면 true 반환
                    sb.append(queue.isEmpty() ? 1 : 0).append('\n');
                    break;

                case "front":
                    // front: 큐의 가장 앞에 있는 정수 출력
                    // peek() 메서드: 첫 번째 요소를 반환하되 제거하지 않음, 비어있으면 null 반환
                    sb.append(queue.isEmpty() ? -1 : queue.peek()).append('\n');
                    break;

                case "back":
                    // back: 큐의 가장 뒤에 있는 정수 출력
                    // getLast() 메서드: LinkedList의 마지막 요소 반환
                    // LinkedList의 특성상 양끝 접근이 O(1)로 가능
                    sb.append(queue.isEmpty() ? -1 : queue.getLast()).append('\n');
                    break;
            }
        }

        /* 최종 출력 및 자원 정리 */
        // StringBuilder에 저장된 모든 결과를 한번에 출력
        // 마지막에 한 번에 출력하는 것이 매번 출력하는 것보다 효율적
        System.out.print(sb);

        // 사용한 입력 스트림 닫기 (리소스 해제)
        br.close();
    }
}
