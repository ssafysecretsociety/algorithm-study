import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 부품찾기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 전체 물품
        int N = Integer.parseInt(st.nextToken());
        int[] all = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            all[i] = Integer.parseInt(st.nextToken());

        // 정렬
        Arrays.sort(all);

        // 오더
        st = new StringTokenizer(br.readLine());
        int N2 = Integer.parseInt(st.nextToken());
        int[] order = new int[N2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N2; i++)
            order[i] = Integer.parseInt(st.nextToken());

        StringBuilder sb= new StringBuilder();
        for (int i = 0; i < N2; i++) {
            if(search(all, order[i], 0, all.length-1) == -1)
                sb.append("no ");
            else
                sb.append("yes ");
        }
        System.out.println(sb);
    }

    static int search(int[] arr, int target, int start, int end) {
        if (start > end)
            return -1;

        int mid = (start + end) / 2;

        if (arr[mid] == target)
            return mid;
        else if (arr[mid] > target)
            return search(arr, target, start, mid - 1);
        else
            return search(arr, target, mid + 1, end);

    }
}

/*
5
8 3 7 9 2
3
5 7 9
 */