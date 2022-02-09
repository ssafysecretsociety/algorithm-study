import java.util.Scanner;

public class 일이될때까지 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int cnt = 0;
        while (N != 1) {
            cnt++;
            if (N / K != 0) {
                N /= K;
                continue;
            } else
                N -= 1;
        }
        System.out.println(cnt);
    }
}
