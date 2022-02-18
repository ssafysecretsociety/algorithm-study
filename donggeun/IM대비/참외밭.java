package IM대비;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 참외밭 {

    static int[] values;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        int r = 0;
        int c = 0;
        int rowMaxIndex = 0, colMaxIndex = 0;

        // 6번의 명령을 읽으며, 가장 긴 R과 C의 값과 인덱스를 저장해둠
        values = new int[6];
        StringTokenizer st = null;
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            values[i] = value;

            if (dir <= 2) {
                if (value > r) {
                    rowMaxIndex = i;
                    r = value;
                }
            } else {
                if (value > c) {
                    colMaxIndex = i;
                    c = value;
                }
            }
        }

        int bigSquare = r * c;

        // 그림으로 이해하기
        // 가장 큰 변의 양옆 인덱스에는 가장 큰 변과 짧은 변이 제공된다. (둘다 높이 or 길이)
        int smallR = Math.abs(getValue(colMaxIndex - 1) - getValue(colMaxIndex + 1));
        int smallC = Math.abs(getValue(rowMaxIndex - 1) - getValue(rowMaxIndex + 1));
        int smallSquare = smallR * smallC;

        System.out.println((bigSquare - smallSquare) * K);


    }

    private static int getValue(int index) {
        if (index == -1) {
            return values[5];
        }

        if (index == 6) {
            return values[0];
        }

        return values[index];
    }


}
