package barkingdog.stack.boj9012;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력 데이터 개수
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            System.out.println(isVPS(line) ? "YES" : "NO");
        }

    }

    public static boolean isVPS(String str) {
        Stack<Character> stack = new Stack<>();
        // 문자열 각 문자 순회
        for (char c: str.toCharArray()) {
            // 여는괄호면 스택에 추가
            if (c == '(') stack.push(c);
            else { // 닫는괄호
                // 비어있으면 not vps
                if (stack.isEmpty()) return false;
                // stack top에 있는 괄호랑 짝 체크
                char top = stack.pop();
                // 짝 검사
                if (c == ')' && top != '(') return false;
            }
        }
        // 모든 문자 처리 끝 -> 스택 비어있어야 함
        return stack.isEmpty();
    }
}
