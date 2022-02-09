// https://programmers.co.kr/learn/courses/30/lessons/60057

public class 문자열압축 {
    public static int solution(String s) {
        int answer = s.length();

        // 문자열 길이의 반을 넘어가면 압축할 수 없다.
        for (int i = 1; i <= s.length() / 2; i++) {
            int cnt = 1;    // 반복 개수
            int total = s.length(); // 초기 전체 개수
            String pre = s.substring(0, i);

            // 자르는 개수 단위(i)개 만큼 증가하며 문자열 검사
            for (int j = i; j < s.length(); j += i) {
                int end = j+i;
                if(j + i > s.length())
                    end = s.length();

                // 앞의 문자열과 반복 된다면 cnt 증가
                if (pre.equals(s.substring(j, end)))
                    cnt++;

                    // 앞의 문자열과 반복되지 않는다면 반복을 멈추고
                    // 압축된 문자열의 길이만큼 전체 개수에서 빼서 변경된 개수를 초기화
                else {
                    if (cnt > 1) {
                        // String.valueOf(cnt).length() -> cnt의 개수가 두자리를 넘어가면
                        // 자리수가 추가로 빠지기 때문에 string으로 환산하여 자리수 계산
                        total -= (i * (cnt - 1) - String.valueOf(cnt).length());
                        cnt = 1;
                    }
                    pre = s.substring(j, end);
                }
            }

            // 남은 압축이 있는지 체크
            if (cnt > 1)
                total -= (i * (cnt - 1) - String.valueOf(cnt).length());

            if (answer > total)
                answer = total;
        }
        return answer;
    }
}
