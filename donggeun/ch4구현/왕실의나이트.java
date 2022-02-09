// p.115 왕실의 나이트

package ch4구현;

import java.util.Scanner;

public class 왕실의나이트 {
    public static void main(String[] args) {

        // 이동배열
        int[] dx = {-2, -2, -1, 1, 2, 2, -1, 1};
        int[] dy = {-1, 1, 2, 2, -1, 1, -2, -2};

        Scanner sc = new Scanner(System.in);
        String loc = sc.nextLine();

        // x, y 좌표를 용도에 맞게 파싱
        int y = loc.charAt(0) - 'a';
        int x = loc.charAt(1) - '1';

        int sum = 0;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 갈 수 있는 칸이라면 sum++;
            if (0 <= nx && nx < 8 && 0 <= ny && ny < 8) {
                sum++;
            }
        }
        System.out.println(sum);


    }
}
