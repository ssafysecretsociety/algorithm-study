package ch8다이나믹프로그래밍;

import java.util.Scanner;

public class 일로만들기 {

    static int[] d;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        int X = sc.nextInt();

        for (int X = 1; X <= 30; X++) {
            d = new int[X + 1];


            for (int i = 0; i < X + 1; i++) {
                d[i] = Integer.MAX_VALUE;
            }

            d[X] = 0;
            dp(X);

            System.out.print(d[1] + " ");
        }

    }

    private static void dp(int n) {
        int count = d[n];
        int value = 0;

        // 수들이 i로 나누어질 경우,
        // count + 1과 d[n / i]를 비교, 더 좋은 경우에만 갱신해준다.

        if (n % 5 == 0) {
            value = n / 5;
            if (count + 1 < d[value]) {
                d[value] = count + 1;
                dp(value);
            }
        }

        if (n % 3 == 0) {
            value = n / 3;
            if (count + 1 < d[value]) {
                d[value] = count + 1;
                dp(value);
            }
        }

        if (n % 2 == 0) {
            value = n / 2;
            if (count + 1 < d[value]) {
                d[value] = count + 1;
                dp(value);
            }
        }

        if (n > 1) {
            value = n - 1;
            if (count + 1 < d[value]) {
                d[value] = count + 1;
                dp(value);
            }
        }
    }
}
