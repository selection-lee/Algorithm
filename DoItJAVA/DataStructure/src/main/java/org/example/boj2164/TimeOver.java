package org.example.boj2164;

import java.util.ArrayList;
import java.util.Scanner;

public class TimeOver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        // 카드 배열 (1~N)
//        int[] cards = new int[N+1]; 배열 말고 리스트로 풀자
        ArrayList<Integer> cards = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            cards.add(i);
        }
//        System.out.println(cards);
        for (int i = 1; i < N; i++) { // 맨 마지막 카드는 남겨야돼서 N-1번만 반복
            // 제일 위의 카드 버리기
            cards.remove(0);
            // 버리고 남은 제일 위의 카드를 바닥으로 옮기기
            int temp = cards.get(0); // 옮길 카드
            cards.remove(0); // 앞에서 빼서
            cards.add(temp); // 바닥에 넣기
            // 만약 카드 배열 길이 == 1 되면 남은 값 return
                // -> 아니면 그냥 result 변수 놓고 거기다가 top을 매번 갱신할까?
                // -> 이 문제는 조건이 명확해서 N-1번 안에 끝나서 그럴필요 없음
        }

        System.out.println(cards.get(0)); // cards[0]은 안 됨: List 인터페이스는 배열 접근 연산자 []를 직접 지원하지 않음
    }
}
