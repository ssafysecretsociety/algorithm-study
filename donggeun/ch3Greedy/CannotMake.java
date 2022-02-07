// p.314 만들 수 없는 금액

package ch3Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class CannotMake {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] data = new int[N];

        for (int i = 0; i < N; i++) {
            data[i] = sc.nextInt();
        }

        // 1 1 2 3 9
        Arrays.sort(data);

        int target = 1;
        for (int x : data) {
            if (target < x) {
                break;
            }
            target += x;
        }

        System.out.println(target);

    }
}
