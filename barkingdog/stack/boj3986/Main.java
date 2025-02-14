package barkingdog.stack.boj3986;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄에서 단어의 개수 N을 입력받음
        int N = Integer.parseInt(br.readLine());

        // 좋은 단어의 개수를 카운트할 변수
        int goodWords = 0;

        // N개의 단어에 대해 반복
        for(int i = 0; i < N; i++) {
            // 현재 검사할 단어를 한 줄 읽어옴
            String word = br.readLine();

            // 문자를 담을 스택 생성
            Stack<Character> stack = new Stack<>();

            // 단어의 각 문자를 순회
            for(int j = 0; j < word.length(); j++) {
                // 현재 검사할 문자
                char currentChar = word.charAt(j);

                // 스택이 비어있지 않고, 스택의 top 문자가 현재 문자와 같다면
                if(!stack.isEmpty() && stack.peek() == currentChar) {
                    // 매칭되므로 스택에서 제거 (pop)
                    stack.pop();
                } else {
                    // 매칭되지 않으므로 현재 문자를 스택에 추가
                    stack.push(currentChar);
                }
            }

            // 모든 문자 처리 후 스택이 비어있다면 좋은 단어
            if(stack.isEmpty()) {
                goodWords++;
            }
        }

        // 좋은 단어의 총 개수 출력
        System.out.println(goodWords);
    }
}
