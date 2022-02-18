package IM대비;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수열 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int max = 1;
        int upCount = 1;
        int downCount = 1;
        

        for (int i = 1; i < N; i++) {

            // 배열의 인접한 값이 같다면 둘다 증가
            if (numbers[i] == numbers[i - 1]) {
                upCount++;
                downCount++;
            } else if (numbers[i] > numbers[i - 1]) { // 뒷 값이 더 크다면, downCount 초기화
                upCount++;
                downCount = 1;
            } else {                                  // 앞 값이 더 크다면, upCount 초기화
                upCount = 1;
                downCount++;
            }
            max = Math.max(max, Math.max(upCount, downCount));
        }
        System.out.println(max);

    }
}
