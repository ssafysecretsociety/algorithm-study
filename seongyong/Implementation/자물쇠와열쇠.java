// https://programmers.co.kr/learn/courses/30/lessons/60059
public class 자물쇠와열쇠 {
    static int map[][];
    static int n, m;

    public static boolean solution(int[][] key, int[][] lock) {
        n = lock.length;
        m = lock[0].length;

        // 패딩
        map = new int[3 * lock.length][3 * lock[0].length];

        // lock 을 가운데에 삽입
        for (int i = 0; i < lock.length; i++) {
            for (int j = 0; j < lock[i].length; j++)
                map[i + lock.length][j + lock[i].length] = lock[i][j];
        }

        int[][] tmp = copy(map);
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                for (int t = 0; t < 4; t++) {
                    try {
                        key = rotate(key);
                        tmp = sumArr(tmp, key, i, j);
                        if (check(tmp))
                            return true;
                    } catch (IndexOutOfBoundsException e) {
                        continue;
                    } finally {
                        tmp = copy(map);
                    }
                }
            }
        }

        return false;
    }

    // check
    public static boolean check(int[][] tmp) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tmp[i+n][j+m] != 1)
                    return false;
            }
        }
        return true;
    }

    public static int[][] rotate(int[][] nkey) {
        int n = nkey.length;
        int m = nkey[0].length;
        int[][] tmp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tmp[j][n - 1 - i] = nkey[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nkey[i][j] = tmp[i][j];
            }
        }

        return nkey;
    }

    public static int[][] sumArr(int[][] tmp, int[][] key, int r, int c) {
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key[0].length; j++) {
                tmp[i + r][j + c] += key[i][j];
            }
        }
        return tmp;
    }

    public static int[][] copy(int[][] tmp) {
        int[][] copy = new int[tmp.length][tmp[0].length];
        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp[i].length; j++) {
                copy[i][j] = tmp[i][j];
            }
        }
        return copy;
    }

}
