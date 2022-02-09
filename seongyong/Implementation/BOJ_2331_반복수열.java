import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_2331_반복수열 {
    static int A, P;
    static ArrayList<Integer> nums = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        P = sc.nextInt();

        // 초기값
        nums.add(A);

        int result = 0;
        int idx = 0;
        while (true) {
            int num = calc(nums.get(idx++));
            if (nums.contains(num)) {
                result = nums.indexOf(num);
                break;
            } else
                nums.add(num);
        }

        System.out.println(result);
    }

    public static int calc(int n) {
        int cal = 0;

        String num = String.valueOf(n);
        for (int i = 0; i < num.length(); i++) {
            int tmp = 1;
            int digit = num.charAt(i) - '0';
            for (int j = 0; j < P; j++) {
                tmp *= digit;
            }
            cal += tmp;
        }
        return cal;
    }
}
