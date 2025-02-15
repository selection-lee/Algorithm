package barkingdog.recur.boj2630;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] paper;
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursive(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }

    static void recursive(int x, int y, int size) {
        int sum = 0;
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                sum += paper[i][j];
            }
        }

        if (sum == size * size) {
            blue++;
        } else if (sum == 0) {
            white++;
        } else {
            int newSize = size / 2;
            recursive(x, y, newSize);                    // 1사분면
            recursive(x, y + newSize, newSize);         // 2사분면
            recursive(x + newSize, y, newSize);         // 3사분면
            recursive(x + newSize, y + newSize, newSize); // 4사분면
        }
    }
}
