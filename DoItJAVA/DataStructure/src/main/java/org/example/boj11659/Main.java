package org.example.boj11659;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // N(수 개수), M(합 계산 횟수) 인풋받고 
        int N, M;
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();

        // N개의 수
        // => 누적합 먼저 구하자
        // N개의 수를 저장할 배열 선언
        int[] sumArr = new int[N + 1];
        sumArr[0] = 0; // 시작 인덱스를 위한 0 설정
        for (int i = 1; i <= N; i++) {
            sumArr[i] = sumArr[i - 1] + in.nextInt(); // 이전까지의 누적합 + 현재 수
        }

        // 합을 구해야 하는 구간 i j 가 M개 들어옴
        for (int k = 0; k < M; k++) {
            int i = in.nextInt();
            int j = in.nextInt();
            System.out.println(sumArr[j] - sumArr[i - 1]); // 구간합 = j까지의 누적합 - (i-1)까지의 누적합
        }
    }
}