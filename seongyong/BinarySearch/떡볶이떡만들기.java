import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 떡볶이떡만들기 {
    static int result = 0;
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // input
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 떡 input
        int[] ddeok = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N ; i++) {
            ddeok[i] = Integer.parseInt(st.nextToken());
        }

        // sort
        Arrays.sort(ddeok);
        cut(ddeok, M, ddeok[0], ddeok[ddeok.length-1]);
        System.out.println(result);
    }

    public static int cut(int[] arr, int target, int start, int end){
        if (start >= end)
            return -1;

        int mid = (start + end) / 2;

        int sum = 0;
        for (int i = 0; i < arr.length ; i++) {
            sum += ((arr[i] - mid) < 0 ? 0 : (arr[i] - mid));
            if(sum > target)
                break;
        }
        if (sum < target)
            return cut(arr, target, start, mid - 1);
        else{
            result = mid;
            return cut(arr, target, mid + 1, end);
        }
    }
}
/*
4 6
19 15 10 17
 */
