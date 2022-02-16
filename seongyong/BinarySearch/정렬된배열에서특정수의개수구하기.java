import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정렬된배열에서특정수의개수구하기 {
    static int cnt = 0, resultIdx, nums[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        resultIdx = search(target, 0, nums.length - 1);
        if (resultIdx == -1) {
            System.out.println(-1);
        } else {
            count(resultIdx);
            System.out.println(cnt);
        }
    }

    static int search(int target, int start, int end) {
        if (start > end)
            return -1;

        int mid = (start + end) / 2;

        if (nums[mid] == target)
            return mid;
        else if (nums[mid] > target)
            return search(target, start, mid - 1);
        else
            return search(target, mid + 1, end);

    }

    static void count(int idx) {
        int origin = idx;
        cnt++;
        while (nums[--idx] == nums[resultIdx])
            cnt++;

        idx = origin;
        while (nums[++idx] == nums[resultIdx])
            cnt++;
    }
}
