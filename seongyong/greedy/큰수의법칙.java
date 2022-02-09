import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 큰수의법칙 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        sc.nextLine();

        // input
        Integer[] nums = new Integer[N];
        for (int i = 0; i < nums.length; i++)
            nums[i] = sc.nextInt();

        // reverse sort
        Arrays.sort(nums, Collections.reverseOrder());

        // first, second
        int one = nums[0];
        int two = nums[1];

        // 첫번째 K개 + 두번째 1개가 한 묶음
        int quot = M / (K + 1);     // 몫
        int remain = M % (K + 1);   // 나머지
        int result = (one * K * quot) + (two * quot) + (one * remain);

        System.out.println(result);

    }
}
