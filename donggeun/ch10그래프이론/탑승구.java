package ch10그래프이론;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class 탑승구 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);

        int G = sc.nextInt();
        int P = sc.nextInt();

        boolean isDocked[] = new boolean[G + 1];

        int count = 0;
        boolean ok = false;
        for (int i = 0; i < P; i++) {
            int max = sc.nextInt();
            ok = false;

            // 수를 입력 받은 뒤, 끝에서부터 채워 넣음
            for (int j = max; j >= 1; j--) {
                if (!isDocked[j]) {
                    isDocked[j] = true;
                    count++;
                    ok = true;
                    break;
                }
            }

            // 만약 끝 공항부터 첫 공항까지 모두 탐색해도 넣을 곳이 없다면 종료
            if (!ok) {
                break;
            }
        }
        System.out.println(count);


    }
}
