package org.example.boj2018;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 입력받을 자연수 N (1 ≤ N ≤ 10,000,000)
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        // 연속된 자연수의 합으로 N을 만드는 가지수를 카운트할 변수
        int count = 0;

        // start: 연속된 수의 시작점
        // end: 연속된 수의 끝점
        // sum: start부터 end까지의 합
        int start = 1;
        int end = 1;
        int sum = 1;

        // 투 포인터 알고리즘 사용
        while (start <= N) {
            if (sum == N) {
                // sum이 N과 같으면 카운트 증가하고
                // end를 늘려서 다음 경우의 수 탐색
                count++;
                end++;
                sum += end;
            } else if (sum > N) {
                // sum이 N보다 크면
                // start를 빼고 start를 한칸 이동
                sum -= start;
                start++;
            } else {
                // sum이 N보다 작으면
                // end를 늘려서 합을 키움
                end++;
                sum += end;
            }
        }

        // 결과 출력
        System.out.println(count);
    }
}