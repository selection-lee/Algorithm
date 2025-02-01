package barkingdog.stack;

import java.util.Scanner;
import java.util.Stack;

class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Stack<Integer> stack = new Stack<Integer>();

        // K개의 줄, 정수 1개씩 주어짐
        int K = in.nextInt();

        for (int i = 0; i < K; i++) {
            int num = in.nextInt();

            // 0이면 가장 최근에 쓴 수 지우기
            // 즉, 스택 top 지우기
            if (num == 0) {
                stack.pop();
            } else {
                // 0이 아닌 경우는 그 수를 스택에 원소 추가
                stack.add(num);
            }
        }
        int sum = 0;

        for (int o : stack) {
            sum += o;
        }
        System.out.println(sum);
    }
}
