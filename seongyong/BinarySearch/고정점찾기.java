import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 고정점찾기 {
    static int[] nums;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(search(0, nums.length-1));
    }

    static int search(int start, int end) {
        if (start > end)
            return -1;

        int mid = (start + end) / 2;

        if (nums[mid] == mid)
            return mid;
        else if (nums[mid] > mid)
            return search(start, mid - 1);
        else
            return search(mid + 1, end);

    }
}
