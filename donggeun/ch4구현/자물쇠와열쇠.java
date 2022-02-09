// p.325 자물쇠와 열쇠
// 프로그래머스 60059
// https://programmers.co.kr/learn/courses/30/lessons/60059

package ch4구현;

public class 자물쇠와열쇠 {

    public static void main(String[] args) {
        int[][] key = {{1}};
        int[][] lock = {{0}};
        System.out.println(new 자물쇠와열쇠().solution(key, lock));
    }

    public static int[][] turnArr(int[][] arr) {
        int[][] newArr = new int[arr.length][arr.length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                newArr[i][j] = arr[arr.length - j - 1][i];
            }
        }
        return newArr;
    }

    public static boolean checkOpen(int[][] arr) {
        int length = arr.length / 3;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (arr[length + i][length + j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int[][] arrCopy(int[][] origin) {
        int[][] copy = new int[origin.length][origin.length];
        for (int i = 0; i < origin.length; i++) {
            copy[i] = origin[i].clone();
        }
        return copy;
    }

    public boolean solution(int[][] key, int[][] lock) {
        int lockLength = lock.length;
        int[][] bigLock = new int[lockLength * 3][lockLength * 3];

        for (int i = 0; i < lockLength; i++) {
            for (int j = 0; j < lockLength; j++) {
                bigLock[lockLength + i][lockLength + j] = lock[i][j];
            }
        }

        for (int k = 0; k < 4; k++) {
            key = turnArr(key);
            for (int i = 0; i < bigLock.length - key.length; i++) {
                for (int j = 0; j < bigLock.length - key.length; j++) {
                    int[][] bl = arrCopy(bigLock);
                    for (int x = 0; x < key.length; x++) {
                        for (int y = 0; y < key.length; y++) {
                            bl[i + x][j + y] += key[x][y];
                        }
                    }
                    if (checkOpen(bl)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
