package org.example.boj11286;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        System.out.println(in.nextInt());
        // 연산 개수 N개 <= 100,000
        int N = in.nextInt();

//        ArrayList<Integer> arr = new ArrayList<>();
//        int least = 2^31; // 최솟값 저장할 변수
        // ArrayList VS PriorityQueue
        // 넣은 순서대로 저장하는 동적 배열 vs 자동으로 정렬 상태 유지
        // pq 생성: 절댓값 기준으로 정렬하되, 절댓값 같으면 실제 값 작은 게 우선
        PriorityQueue<Integer>pq = new PriorityQueue<>((n1, n2) -> {
            // 두 수 절댓값 계산
            int abs1 = Math.abs(n1);
            int abs2 = Math.abs(n2);

            if (abs1 == abs2) {
                return n1 - n2; // 절댓값 같으면 원본 값 비교해서 음수가 앞으로가도록
            }
            return abs1 - abs2; // 절댓값 다르면 절댓값끼리만 비교
        });


        // 연산 정보 나타내는 정수 x가 N번 들어옴
        // x != 0 : 배열에 x 넣기
        // x == 0 : 배열에서 절댓값 가장 작은 값 pop하고 print
        for (int i = 0; i < N; i++) {
            int x = in.nextInt();
//            int abs = Math.abs(x); // 절댓값 제일 작은 수 저장

            if (x != 0) {
                pq.offer(x); // add같은건데 우선순위 큐에는 자동으로 정렬됨
            } else {
                // 큐 비어있으면 0 출력
                // else 가장 절댓값 작은 앞에꺼 출력
                System.out.println(pq.isEmpty() ? 0: pq.poll()); // poll: 파이썬 pop 같은거
            }
        }
        in.close();
        // scanner 자원 해제: 코테에서는 main 메소드 끝나면 프로그램도 종료되고 그럼 모든 리소스 정리되니까 상관 없지만,
        // 실제 플젝에서는 리소스 관리가 중요함(특히 파일이나 네트워크 연결 다룰 때)
        // 사실 파이썬은 파일 with open('file.txt') as f: 이런식으로 하면 자동으로 close됨
        // 그래서 실제 플젝에서는 try (Scanner in = new Scanner(System.in)) { ~~~} 으로 쓰는 게 좋다고..! try 끝나면 자동으로 close 되니까
    }
}
