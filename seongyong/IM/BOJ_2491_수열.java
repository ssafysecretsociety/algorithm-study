// https://www.acmicpc.net/problem/2491

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2491_수열 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int decrease = 0;
        int increase = 0;

        int dec = 1;
        int inc = 1;
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == pre) {
                dec++;
                inc++;
            }
            if (nums[i] < pre) {
                dec++;
                inc = 1;
            }

            if (nums[i] > pre) {
                inc++;
                dec = 1;
            }
            decrease = Math.max(decrease, dec);
            increase = Math.max(increase, inc);
            pre = nums[i];
        }

        if (N == 1)
            System.out.println(1);
        else
            System.out.println(Math.max(decrease, increase));
    }
}
