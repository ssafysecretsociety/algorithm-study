// https://www.acmicpc.net/problem/18406

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 럭키스트레이트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();

        int sum = 0;
        for (int i = 0; i < num.length() / 2; i++) {
            int tmp = num.length() % 2 == 1 ? i + num.length() / 2 + 1
                    : i + num.length() / 2;

            sum += (num.charAt(i) - '0');   // left
            sum -= (num.charAt(tmp) - '0'); // right
        }

        if (sum == 0)
            System.out.println("LUCKY");
        else
            System.out.println("READY");
    }
}
