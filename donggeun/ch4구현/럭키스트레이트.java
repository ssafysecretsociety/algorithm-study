// p.321 럭키스트레이트
// bj 18406
// https://www.acmicpc.net/problem/18406

package ch4구현;

import java.util.Scanner;

public class 럭키스트레이트 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String score = sc.nextLine();

        long leftSum = 0;
        long rightSum = 0;

        // index가 절반보다 작다면 leftSum, 크다면 rightSum에 더해줌
        for (int i = 0; i < score.length(); i++) {
            if (i < score.length() / 2) {
                leftSum += score.charAt(i) - '0';
            } else {
                rightSum += score.charAt(i) - '0';
            }
        }

        if (leftSum == rightSum) {
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }
    }
}
