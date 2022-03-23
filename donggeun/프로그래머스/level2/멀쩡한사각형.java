// Summer/Winter Coding(2018)
// https://programmers.co.kr/learn/courses/30/lessons/62048

package 프로그래머스.level2;

public class 멀쩡한사각형 {
    public static void main(String[] args) {
        System.out.println(new 멀쩡한사각형().solution(8, 12));
    }

    static int getGcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return getGcd(b, a % b);
    }

    public long solution(int w, int h) {
        return (long) w * h - (w + h - getGcd(w, h));
    }
}
