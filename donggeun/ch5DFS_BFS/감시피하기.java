package ch5DFS_BFS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 감시피하기 {

    static int N;
    static char[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static ArrayList<int[]> blank = new ArrayList<>();
    static ArrayList<int[]> cases = new ArrayList<>();
    static int[] numbers = new int[3];
    static boolean isSafe;
    static String msg = "";

    public static void combination(int cnt, int start) {
        if (cnt == 3) {
            cases.add(Arrays.copyOf(numbers, numbers.length));
            return;
        }

        for (int i = start; i < blank.size(); i++) {
            numbers[cnt] = i;
            combination(cnt + 1, i + 1);
        }
    }

    public static void teacherBeam(int x, int y) {
        // 탐색과정에서 학생 만나면 바로 isSafe = false;

        int firstX = x;
        int firstY = y;
        for (int i = 0; i < 4; i++) {
            x = firstX;
            y = firstY;
            while (true) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    break;
                }

                if (map[nx][ny] == 'O') {
                    break;
                }

                if (map[nx][ny] == 'S') {
                    isSafe = false;
                    break;
                }

                x = nx;
                y = ny;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        StringTokenizer st = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().charAt(0);
                if (map[i][j] == 'X') {
                    blank.add(new int[]{i, j});
                }
            }
        }

        combination(0, 0);

        for (int[] oneCase : cases) {
            // 케이스 정보...
            // [7,8,9]

            isSafe = true;

            // 1. map에 장애물 설치 (idx -> O)
            for (int i : oneCase) {
                int[] buildLoc = blank.get(i);
                map[buildLoc[0]][buildLoc[1]] = 'O';
            }


            // 2. 선생이라면 dfs (T를 만나면 즉시 종료)
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 'T') {
                        teacherBeam(i, j);
                    }
                }
            }

            // 3. 만약 safety -> 바로 끝 / 끝까지 아니라면 리턴
            if (isSafe) {
                msg = "YES";
                break;
            }

            // map에 장애물 제거 (idx -> X)
            for (int i : oneCase) {
                int[] buildLoc = blank.get(i);
                map[buildLoc[0]][buildLoc[1]] = 'X';
            }

        }

        if (msg.equals("")) {
            msg = "NO";
        }
        System.out.println(msg);


    }
}
