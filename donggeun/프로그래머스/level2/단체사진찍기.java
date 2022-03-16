// 2017 카카오코드 본선
// https://programmers.co.kr/learn/courses/30/lessons/1835

package 프로그래머스.level2;

import java.util.HashMap;
import java.util.Map;

public class 단체사진찍기 {

    // 전역변수 초기화 이슈...
    static int[] orders = new int[8];
    static int okCount = 0;
    static char[] characters = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};

    public static void main(String[] args) {
        System.out.println(new 단체사진찍기().solution(2, new String[]{"N~F=0", "R~T>2" }));
    }

    // 순열을 돌리다가 cnt == 8이 된 시점에 옳은지 검사해줌
    static void permutation(int cnt, int flag, String[] data) {
        if (cnt == 8) {
            if (isOk(orders, data)) okCount++;
            return;
        }

        for (int i = 0; i < 8; i++) {
            if ((flag & 1 << i) != 0) continue;
            orders[cnt] = i;
            permutation(cnt + 1, flag | 1 << i, data);
        }
    }

    // order
    // [0, 4, 2, 3, 7, 1, 5, 6]
    // [map['A'] = 0]
    // [map['C'] = 4]
    static boolean isOk(int[] orders, String[] data) {
        // character 순서대로 넣어주고, 번호는 순열에 따름
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 8; i++) {
            map.put(characters[i], orders[i]);
        }

        // 주어진 커맨드와 거리가 일치하는지 확인
        for (String req : data) {
            char memberOne = req.charAt(0);
            char memberTwo = req.charAt(2);
            char cmd = req.charAt(3);
            int reqDist = req.charAt(4) - '0';

            int dist = Math.abs(map.get(memberOne) - map.get(memberTwo)) - 1;

            if (cmd == '=') {
                if (dist != reqDist) return false;
            } else if (cmd == '<') {
                if (dist >= reqDist) return false;
            } else {
                if (dist <= reqDist) return false;
            }
        }

        // 모든 명령을 통과했을 때만 true return
        return true;
    }

    public int solution(int n, String[] data) {

        orders = new int[8];
        okCount = 0;
        permutation(0, 0, data);


        return okCount;
    }
}

