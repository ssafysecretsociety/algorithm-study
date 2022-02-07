// p.311 곱하기 혹은 더하기

package ch3Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class MultiOrPlus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] charArr = sc.nextLine().toCharArray();

        int[] numbers = new int[charArr.length];
        for (int i = 0; i < charArr.length; i++) {
            numbers[i] = charArr[i] - '0';
        }

        Arrays.sort(numbers);

        int multi = 1;

        if (numbers[numbers.length - 1] == 0) {
            System.out.println(0);
        } else {
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] == 0) {
                    continue;
                }
                multi *= numbers[i];
            }

            System.out.println(multi);
        }


    }
}
