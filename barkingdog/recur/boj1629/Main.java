package barkingdog.recur.boj1629;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(func(sc.nextInt(), sc.nextInt(), sc.nextInt()));
    }

    // A를 B번 곱하되, C로 나눈 나머지를 구하는 프로그램
    // int로는 수가 작을 땐 잘 나오지만, 수 커지면 int 오버플로우 나서 long으로 선언해주어ㅑ 됨
    public static long func(long A, long B, long C){
        // 1. 종료조건
        // B가 1 되면 마지막 나머지 반환
        if (B == 1) return A % C;
        // 2. 재귀 호출
        long val = func(A, B/2, C); // 2로 나눈 지수로 결과 먼저 구하기(재귀)
        val = val * val % C; // 처음부터 나머지에다가,,,
        // 3. B가 홀수면 A한 번 더 곱해줌
        if (B%2 == 0) return val; // 짝수면 그대로 리터
        return val * A % C; // 홀수면 한 번 더 A 곱함
    }
}
