// https://programmers.co.kr/learn/courses/30/lessons/60060

import java.util.Arrays;

public class 가사검색 {
    public static int[] solution(String[] words, String[] queries) {
        int[] answer = {};

        Arrays.sort(words);
        System.out.println(Arrays.toString(words));

        for (int i = 0; i < queries.length; i++) {

        }
        return answer;
    }

    public static void main(String[] args) {
        solution(new String[]{"frodo", "front", "frost", "frozen", "frame", "kakao"},
                new String[]{"fro??", "????o", "fr???", "fro???", "pro?"});
    }
}
