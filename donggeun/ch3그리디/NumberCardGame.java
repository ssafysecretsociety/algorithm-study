// p96. 숫자 카드 게임

package ch3그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NumberCardGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] smallNumber = new int[n];
        for (int i = 0; i < n; i++) {
            Arrays.sort(arr[i]);
            smallNumber[i] = arr[i][0];
        }

        Arrays.sort(smallNumber);

        System.out.println(smallNumber[n - 1]);
    }
}
