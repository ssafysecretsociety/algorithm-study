import java.util.Scanner;

public class 왕실의나이트 {
    public static void main(String[] args) {
        int[] dx = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = new int[]{-1, -2, -2, -1, 1, 2, 2, 1};

        Scanner sc = new Scanner(System.in);
        String location = sc.next();
        int row = location.charAt(1) - '1';
        int col = location.charAt(0) - 'a';

        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            int nx = dx[i] + row;
            int ny = dy[i] + col;

            if (nx < 0 || ny < 0 || nx >= 8 || ny >= 8)
                continue;
            else
                cnt++;
        }
        System.out.println(cnt);
    }
}
