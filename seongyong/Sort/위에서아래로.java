import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 위에서아래로 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] nums = new int[100001];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            nums[Integer.parseInt(st.nextToken())]++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nums.length ; i++) {
            while(nums[i]-- > 0)
                sb.append(i + " ");
        }

        System.out.println(sb);
    }
}
