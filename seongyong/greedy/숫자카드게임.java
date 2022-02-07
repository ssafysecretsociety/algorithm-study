import java.util.Arrays;
import java.util.Scanner;

public class 숫자카드게임 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        // 결과 값
        int result = 0;

        for (int i = 0; i< N; i++){
            String [] cards = sc.nextLine().split(" ");

            // String으로 바로 sort
            Arrays.sort(cards);
            if(result < Integer.parseInt(cards[0]))
                result = Integer.parseInt(cards[0]);

        }

        System.out.println(result);

    }
}
