package IM대비;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 직사각형 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = null;
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            int fx1 = Integer.parseInt(st.nextToken());
            int fy1 = Integer.parseInt(st.nextToken());
            int fx2 = Integer.parseInt(st.nextToken());
            int fy2 = Integer.parseInt(st.nextToken());

            int sx1 = Integer.parseInt(st.nextToken());
            int sy1 = Integer.parseInt(st.nextToken());
            int sx2 = Integer.parseInt(st.nextToken());
            int sy2 = Integer.parseInt(st.nextToken());

            // 점이 겹치는 경우
            if ((sx1 == fx2 && sy1 == fy2) || (sx2 == fx1 && sy2 == fy1) || (sx1 == fx2) && (sx2 == fy1) || (sx1 == fx2) && (sy2 == fy1)) {
                System.out.println('c');
            }

            // 공통 부분이 없음
            else if (sy1 == fy2 || sy2 == fy1 || fx2 == sx1) {

            }
        }

    }
}
