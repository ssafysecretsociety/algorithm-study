package IM대비;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 창고다각형 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] build = new int[1001];

        // 입력을 받으며 가장 큰 곳의 위치와 값을 받아옴
        int maxIndex = 0, maxHeight = Integer.MIN_VALUE;
        StringTokenizer st = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            build[L] = H;
            if (H > maxHeight) {
                maxIndex = L;
                maxHeight = H;
            }
        }

        // 넓이 값 초기화에 앞서 가장 큰 높이 * 1의 값으로 초기화 해줌
        int sum = maxHeight;

        // 왼쪽 -> maxIndex까지 탐색하며,
        // 높이를 계속 갱신해주고 더해준다.
        int height = 0;
        for (int i = 0; i < maxIndex; i++) {
            height = Math.max(height, build[i]);
            sum += height;
        }

        // 오른쪽 -> maxIndex까지 탐색하며,
        // 높이를 계속 갱신해주고 더해준다.
        height = 0;
        for (int i = 1000; i > maxIndex; i--) {
            height = Math.max(height, build[i]);
            sum += height;
        }

        System.out.println(sum);
    }
}
