package org.example.boj1874;

import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        System.out.println(in.nextInt());
        int N = in.nextInt(); // 정수 개수
        Stack<Integer> stack = new Stack<>(); // 숫자들 담을 배열(스택)
        ArrayList<String> result = new ArrayList<>(); // push, pop 연산 저장할 리스트

        int cur = 1; // 1부터 N까지 push 할 떄 사용하자

        // 숫자 N개 반복하면서 수열 입력받기
        for(int i = 0; i < N; i++) {
            int num = in.nextInt();

            // 입력받은 수열 만드려면 cur부터 num까지 push 해야 됨
            while (cur <= num) {
                stack.push(cur);
                result.add("+");
                cur++;
            }

            // 스택 top에 입력받은 수 없으면? 수열 못 만든다
            if(stack.peek() != num) {
                System.out.println("NO");
                return;
            }

            // 스택에서 수 pop
            stack.pop();
            result.add("-");
        }

        // 여기까지 오면 정상적으로 수열을 만들 수 있는 것
        for (String res : result) {
            System.out.println(res);
        }
    }
}
