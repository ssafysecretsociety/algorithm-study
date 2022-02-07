// p99. 1이 될 때까지

package ch3Greedy;

import java.util.Scanner;

public class TillOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int count = 0;
        while (n != 1) {
            if (n % k == 0) {
                n /= k;
            } else {
                n -= 1;
            }
            count++;
        }

        System.out.println(count);

    }
}
