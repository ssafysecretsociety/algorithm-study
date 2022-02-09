// p.329 기둥과 보 설치
// 프로그래머스 60061
// https://programmers.co.kr/learn/courses/30/lessons/60061

package ch4구현;

import java.util.ArrayList;

public class 기둥과보설치 {
    public static void main(String[] args) {
        int n = 5;
        int[][] build_frame = {{1, 0, 0, 1}, {1, 1, 1, 1}, {2, 1, 0, 1}, {2, 2, 1, 1}, {5, 0, 0, 1}, {5, 1, 0, 1}, {4, 2, 1, 1}, {3, 2, 1, 1}};
//        System.out.println(new 기둥과보설치().solution(n, build_frame));
        System.out.println("D");
        ArrayList<int[]> test = new ArrayList<>();
        test.add(new int[]{1, 2});

        System.out.println(test.indexOf(new int[]{1, 2}));

    }

    public static boolean valid(ArrayList<int[]> builds) {
        for (int[] build : builds) {
            int x = build[0];
            int y = build[1];
            int a = build[2];

            if (a == 0) {
                if (y == 0 || builds.indexOf(new int[]{x - 1, y, 1}) > 0 || builds.indexOf(new int[]{x, y - 1, 0}) > 0 || builds.indexOf(new int[]{x, y, 1}) > 0) {
                    continue;
                }
            }

        }

        return true;

    }

    public int[][] solution(int n, int[][] build_frame) {
        ArrayList<int[]> arr = new ArrayList<>();
        for (int[] frame : build_frame) {
            int x = frame[0];
            int y = frame[1];
            int a = frame[2];
            int b = frame[3];

            if (b == 0) {

            }

        }

        return null;
    }
}
