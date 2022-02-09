// p.312 문자열 뒤집기
// bj 1439

package ch3그리디;

import java.util.Scanner;

public class TurnString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        int count = 0;
        char now = str.charAt(0);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != now) {
                now = str.charAt(i);
                if (now != str.charAt(0)) {
                    count++;
                }
            }
        }

        System.out.println(count);

    }
}
