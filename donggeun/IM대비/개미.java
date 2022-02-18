package IM대비;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 개미 {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(br.readLine());

        // 왕복하는 거리 제외
        int timeX = time % (R * 2);
        int timeY = time % (C * 2);


        int dx = 1;
        int dy = 1;

        while (timeX > 0) {
            int nx = x + dx;

            if (nx < 0 || nx > R) {
                dx = -dx;
                continue;
            }

            timeX--;
            x = nx;

        }


        while (timeY > 0) {
            int ny = y + dy;

            if (ny < 0 || ny > C) {
                dy = -dy;
                continue;
            }

            timeY--;
            y = ny;

        }
        System.out.println(x + " " + y);


    }
}
