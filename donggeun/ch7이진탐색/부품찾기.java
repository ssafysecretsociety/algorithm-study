package ch7이진탐색;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class 부품찾기 {

    // 시간 복잡도 생각해보자
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] tools = new int[N];
        for (int i = 0; i < N; i++) {
            tools[i] = sc.nextInt();
        }
        Arrays.sort(tools);

        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            if (Arrays.binarySearch(tools, sc.nextInt()) < 0) {
                System.out.print("no ");
            } else {
                System.out.print("yes ");
            }
        }
        System.out.println();
    }
}
