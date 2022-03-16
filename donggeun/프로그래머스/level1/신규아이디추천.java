// 2021 KAKAO BLIND RECRUITMENT
// https://programmers.co.kr/learn/courses/30/lessons/72410

package 프로그래머스.level1;

public class 신규아이디추천 {

    public static void main(String[] args) {
        System.out.println(new 신규아이디추천().solution("=.="));
    }

    public String solution(String new_id) {
        String answer = new_id;

        // step 1: 소문자로 변경
        answer = answer.toLowerCase();

        // step 2: 조건에 맞는 문자만 남기기
        StringBuilder sb = new StringBuilder();
        for (char c : answer.toCharArray()) {
            if (('a' <= c && c <= 'z') || ('0' <= c && c <= '9') || c == '-' || c == '_' || c == '.') {
                sb.append(c);
            }
        }
        answer = sb.toString();

        // step 3: 연속된 점 제거
        sb = new StringBuilder();
        for (int i = 1; i < answer.length(); i++) {
            if (answer.charAt(i - 1) == '.' && answer.charAt(i) == '.') {
                continue;
            }
            sb.append(answer.charAt(i - 1));
        }
        sb.append(answer.charAt(answer.length() - 1));

        // step 4: 좌우 끝 점 제거
        if (sb.charAt(0) == '.') {
            sb.deleteCharAt(0);
        }
        while (sb.length() > 0 && sb.charAt(sb.length() - 1) == '.') {
            sb.deleteCharAt(sb.length() - 1);
        }

        // step 5: 빈문자열 처리
        if (sb.length() == 0) {
            sb.append('a');
        }

        // step 6: 16자 이상 정리
        if (sb.length() >= 16) {
            sb = sb.delete(15, sb.length());
        }
        if (sb.charAt(sb.length() - 1) == '.') {
            sb.deleteCharAt(sb.length() - 1);
        }

        // step 7: 2자 이하 처리
        while (sb.length() < 3) {
            sb.append(sb.charAt(sb.length() - 1));
        }

        return sb.toString();
    }
}
