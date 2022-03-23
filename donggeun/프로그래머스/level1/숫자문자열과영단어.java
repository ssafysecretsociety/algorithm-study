// 2021 카카오 채용연계형 인턴십
// https://programmers.co.kr/learn/courses/30/lessons/81301

package 프로그래머스.level1;

public class 숫자문자열과영단어 {

    public static void main(String[] args) {
        System.out.println(new 숫자문자열과영단어().solution("one4seveneight"));
    }

    public int solution(String s) {
        String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i = 0; i < 10; i++) {
            s = s.replace(numbers[i], i + "");
        }

        return Integer.parseInt(s);
    }
}
