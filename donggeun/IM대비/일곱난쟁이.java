package IM대비;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class 일곱난쟁이 {

    static int[] numbers, smalls;
    static boolean ok = false;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);

        smalls = new int[9];
        for (int i = 0; i < 9; i++) {
            smalls[i] = sc.nextInt();
        }

        Arrays.sort(smalls);
        numbers = new int[7];
        combination(0, 0, 0);
    }

    public static void combination(int cnt, int start, int sum) {

        // 정답이 여러개인 경우 처리해주자
        if (ok) {
            return;
        }

        if (cnt == 7) {
            if (sum == 100) {
                for (int small : numbers) {
                    System.out.println(small);
                }
                ok = true;
            }
            return;
        }

        if (sum > 100) {
            return;
        }

        for (int i = start; i < 9; i++) {
            numbers[cnt] = smalls[i];
            combination(cnt + 1, i + 1, sum + smalls[i]);
        }

    }
}
