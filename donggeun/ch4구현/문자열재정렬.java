// p.322 문자열 재정렬

package ch4구현;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 문자열재정렬 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();

        int sum = 0;
        ArrayList<Character> arr = new ArrayList<>();

        // 문자가 숫자라면 sum에 더해주고, 알파벳이라면 ArrayList에 추가
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (Character.isDigit(c)) {
                sum += c - '0';
            } else {
                arr.add(c);
            }
        }

        Collections.sort(arr);

        // 정렬 후, 알파벳 순서대로 StringBuilder에 append
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            sb.append(c);
        }

        // 입력에 숫자가 없을 경우 숫자 출력 X
        if (arr.size() < line.length()) {
            sb.append(sum);
        }

        System.out.println(sb.toString());
    }
}
