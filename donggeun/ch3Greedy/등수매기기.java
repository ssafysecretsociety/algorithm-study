package ch3Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class 등수매기기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] predicts = new int[N];
        for (int i = 0; i < N; i++) {
            predicts[i] = sc.nextInt();
        }

        Arrays.sort(predicts);

        long dissatisfied = 0;
        for (int i = 0; i < N; i++) {
            dissatisfied += Math.abs(predicts[i] - (i + 1));
        }

        System.out.println(dissatisfied);


    }
}
