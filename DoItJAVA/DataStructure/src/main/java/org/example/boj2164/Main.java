package org.example.boj2164;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // 카드 개수 N

        // 큐 선언
        // LinkList는 큐 인터페이스를 구현한 구현체!!
        Queue<Integer> cards = new LinkedList<>();

        // 카드 큐 (1~N)
        for (int i = 1; i <= N; i++) {
            cards.offer(i); // 파이썬으로 치면 append - 큐의 맨 뒤에 삽입
        }

        // 맨 마지막 카드는 남겨야돼서 N-1번만 반복
        for (int i = 1; i < N; i++) {
            // 제일 위의 카드 버리기
            cards.poll(); // 파이썬 popleft
            // 버리고 남은 제일 위의 카드를 바닥으로 옮기기
            cards.offer(cards.poll()); // 파이썬 cards.append(cards.popleft());
        }
        // 여기까지 왔으면 카드가 하나만 남아있을 것.
        System.out.println(cards.peek()); // cards[0]은 안 됨: 배열만 가능. 큐는 배열 x, 인터페이스 o
        // popleft는 poll, 그냥 cards[0]는 .peek()
    }
}
