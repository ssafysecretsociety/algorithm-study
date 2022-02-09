import java.util.Scanner;

public class 곱하기혹은더하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nums = sc.next().split("");

        int sum = Integer.parseInt(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int tmp = Integer.parseInt(nums[i]);
            if (tmp <= 1 || sum <= 0)
                sum += tmp;
            else
                sum *= tmp;
        }
        System.out.println(sum);
    }
}
