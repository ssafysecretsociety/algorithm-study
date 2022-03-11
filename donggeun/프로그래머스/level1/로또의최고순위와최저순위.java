// 2021 Dev-Matching: 웹 백엔드 개발자
// https://programmers.co.kr/learn/courses/30/lessons/77484

package 프로그래머스.level1;

import java.util.Arrays;

public class 로또의최고순위와최저순위 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new 로또의최고순위와최저순위().solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19})));
    }

    // 맞은 갯수를 입력 받아 순위를 리턴
    static int getRank(int count) {
        if (count >= 6) {
            return 1;
        } else if (count == 5) {
            return 2;
        } else if (count == 4) {
            return 3;
        } else if (count == 3) {
            return 4;
        } else if (count == 2) {
            return 5;
        } else {
            return 6;
        }
    }

    public int[] solution(int[] lottos, int[] win_nums) {
        int correct = 0;
        int zero = 0;

        // 입력 받은 숫자 하나씩 검색
        for (int number : lottos) {
            // 숫자가 0이라면 zero++
            if (number == 0) {
                zero++;
                continue;
            }
            // 0이 아니라면, 정답 배열에서 일치하는 숫자가 있는지 검사
            for (int answer : win_nums) {
                if (number == answer) {
                    correct++;
                    break;
                }
            }
        }

        // 최저 순위와 최고 순위 계산
        int low = correct;
        int high = correct + zero;

        int[] answer = new int[2];
        answer[0] = getRank(high);
        answer[1] = getRank(low);

        return answer;


    }
}
