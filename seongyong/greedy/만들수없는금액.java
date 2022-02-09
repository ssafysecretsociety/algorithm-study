import java.util.ArrayList;
import java.util.Scanner;

public class 만들수없는금액 {
    static ArrayList<Integer> combinations = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] coins = new int[N];
        int max = 0;
        boolean[] visited = new boolean[N];

        for (int i = 0; i < coins.length; i++) {
            coins[i] = sc.nextInt();
            max += coins[i];
        }

        int[] nums = new int[max + 1];

        // 모든 coins 조합
        for (int i = 1; i <= N; i++)
            combination(coins, visited, 0, N, i);

        // coin 조합들의 합에 해당하는 수가 존재하면 +1
        for (int i = 0; i < combinations.size(); i++) {
            nums[combinations.get(i)]++;
        }

        // 만약 나올 수 있는 최대값 아래의 모든 수가 가능하다면 max+1
        int result = max + 1;
        for (int i = 1; i <= max; i++) {
            if (nums[i] == 0) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }


    // 조합
    static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            print(arr, visited, n);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    static void print(int[] arr, boolean[] visited, int n) {
        int sum = 0;

        // 모든 조합 요소의 합을 array에 저장
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                sum += arr[i];
            }
        }
        combinations.add(sum);
    }
}
