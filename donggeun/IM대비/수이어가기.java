package IM대비;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class 수이어가기 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        ArrayList<Integer> list = null;
        ArrayList<Integer> longList = null;

        int max = Integer.MIN_VALUE;


        for (int i = 0; i <= N; i++) {
            // 각 반복문 = 1, 2, 3 ...
            list = new ArrayList<>();
            list.add(N);
            list.add(i);
            int size = 2;
            
            while (true) {
                int next = list.get(size - 2) - list.get(size - 1);
                if (next < 0) {
                    // size 비교
                    if (size > max) {
                        max = size;
                        longList = list;
                    }
                    break;
                }
                list.add(next);
                size++;
            }
        }

        System.out.println(max);
        for (int i : longList) {
            System.out.print(i + " ");
        }


    }
}
