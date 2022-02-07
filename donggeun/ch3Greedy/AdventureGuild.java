// 모험가 길드

package ch3Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class AdventureGuild {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] horror = new int[n];

        for (int i = 0; i < n; i++) {
            horror[i] = sc.nextInt();
        }

        Arrays.sort(horror);

        int count = 0;
        int now = 0;

        for (int i = 0; i < n; i++) {
            now++;
            if (now >= horror[i]) {
                count++;
                now = 0;
            }

        }

        System.out.println(count);

    }
}
