package barkingdog.boj1475;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 다솜이 방 번호 N <= 1,000,000
        int N = in.nextInt();

        // 0~9 숫자 필요한 개수 저장할 배열 선언
        int[] numCnt = new int[10];

        // 방 번호 각 자리마다 카운트해서 배열에 추가
        while (N>0) {
            numCnt[N%10]++;
            N/=10;
        }

        // 단, 6이랑 9는 바꿔쓸 수 있으니까 합쳐서 계산
        int sixNine = (numCnt[6] + numCnt[9] + 1) / 2;
        numCnt[6] = numCnt[9] = sixNine; // 실제 필요한 개수

        // 최댓값 찾기
        // 파이썬처럼 max 딸깍 안 됨...
        int max = 0;
        for (int count : numCnt) {
            max = Math.max(max, count);
        }
        System.out.println(max);
    }

    // 일단 배열에서 이미 쓴 숫자는 -1로 처리
    // 6이나 9는 없으면 9나 6 확인
    // 찾는 숫자가 -1이면 세트 하나 추가해서 거기서 가져와서 -1 처리
    // 헉!!! 그냥 숫자 쓰인 갯수를 카운트하는 게 빠르고 효율적이다!!
}
