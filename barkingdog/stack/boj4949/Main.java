package barkingdog.stack.boj4949;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();

            // 입력 마지막에는 "." 하나만 있음 -> 종료
            if (line.equals(".")) break;

            System.out.println(isBalanced(line) ? "yes" : "no");
        }
        br.close();
    }

    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();
        // 문자열 각 문자 순회
        for (char c : str.toCharArray()) {
            // 여는 괄호일 경우 스택에 추가
            if (c == '(' || c == '[') stack.push(c);
            // 닫는 괄호일 때의 처리
            else if (c == ')' || c == ']') {
                if (stack.isEmpty()) return false;
                // 스택의 top에 있는 괄호와 현재 괄호 짝 맞는지 확인
                char top = stack.pop();

                // 소괄호 쌍 검사
                if (c == ')' && top != '(') return false;
                // 대괄호
                if (c == ']' && top != '[') return false;
            }
        }
        // 모든 문자 처리한 후 스택이 비어있어야 함
        return stack.isEmpty();
    }
}

