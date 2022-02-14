// p.178 위에서 아래로

package ch6정렬;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 위에서아래로 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Integer[] arr = new Integer[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        // int[]는 불가능함에 유의하자
        Arrays.sort(arr, Comparator.reverseOrder());

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

    }
}
