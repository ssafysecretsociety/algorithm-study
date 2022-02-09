import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2012_등수매기기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int tmp[] = new int[N];
        for (int i = 0; i < N; i++)
            tmp[i] = Integer.parseInt(br.readLine());

        Arrays.sort(tmp);

        long result = 0;
        for (int i = 1; i < N + 1; i++) {
            result += Math.abs(i - tmp[i - 1]);
        }
        System.out.println(result);
    }
}
