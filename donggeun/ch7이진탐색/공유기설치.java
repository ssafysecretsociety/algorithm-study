package ch7이진탐색;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공유기설치 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] houses = new int[N];
        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);

        int start = 0;
        int end = houses[houses.length - 1];
        int max = -1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int count = 1;
            int now = houses[0];
            for (int i = 1; i < houses.length; i++) {
                if (houses[i] >= now + mid) {
                    now = houses[i];
                    count++;
                }
            }
            if (count >= C) {
                start = mid + 1;
                max = Math.max(max, mid);
            } else {
                end = mid - 1;
            }
        }

        System.out.println(max);
    }
}
