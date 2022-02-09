import java.util.Scanner;

public class 문자열뒤집기 {
    public static void main(String[] args) {
        // 뒤집기의 최소가 되는 경우의 수는 가운데부터 뒤집는다면 성립
        // 부분 등차수열 ( 0 1 1 2 2 3 3...)

        Scanner sc = new Scanner(System.in);
        String num = sc.next();

        int cnt = 0;
        char pre = num.charAt(0);

        for (int i = 1; i < num.length(); i++) {
            // 앞의 수와 다를 경우 개수 +1
            if (pre != num.charAt(i))
                cnt++;
            pre = num.charAt(i);
        }

        // 꺾인 부분이 홀수 일 경우 /2, 짝수일 경우 /2 +1
        int result = cnt % 2 == 0 ? cnt / 2 : cnt / 2 + 1;

        // 꺾인 부분이 없을 경우
        if (cnt <= 0)
            System.out.println("0");
        else
            System.out.println(result);


    }
}
