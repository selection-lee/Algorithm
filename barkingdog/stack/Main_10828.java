package barkingdog.stack;

import java.util.Scanner;

class Main_10828 {
//    private static Scanner sc;

    //    스택으로 쓸 배열 선언
//    메모리 사이즈 변수 선언
    public static int[] stack;
    public static int size = 0;

    public static void main(String[] args) {
        // 인풋 받기
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        // 명령의 수 N
        int N = in.nextInt();

        stack = new int[N]; // 선언한 스택 길이 지정

        for (int i = 0; i < N; i++) {
            String str = in.next();

            switch (str) {
                case "push":
                    push(in.nextInt());
                    break;
                case "pop":
                    sb.append(pop()).append('\n');
                    break;
                case "size":
                    sb.append(size()).append('\n');
                    break;
                case "empty":
                    sb.append(empty()).append('\n');
                    break;
                case "top":
                    sb.append(top()).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }

    // 정수 item을 스택에 넣기
    public static void push(int item) {
        stack[size] = item;
        size++;
    }

    // 스택에서 가장 위에 있는 정수를 빼고, 그 수 출력 . 없으면 -1
    public static int pop() {
        if (size == 0) {
            return -1;
        } else {
            int result = stack[size - 1];
            stack[size - 1] = 0;
            size--;
            return result;
        }
    }

    // stack에 들어있는 정수 개수 출력
    public static int size() {
        return size;
    }

    // 스택이 비어있으면 1, 아니면 0 출력
    public static int empty() {
        if (size == 0) {
            return 1;
        }
        return 0;
    }

    // 스택 가장 위의 정수 출력. 없으면 -1
    public static int top() {
        if (size == 0) {
            return -1;
        }
        return stack[size - 1];
    }
}
