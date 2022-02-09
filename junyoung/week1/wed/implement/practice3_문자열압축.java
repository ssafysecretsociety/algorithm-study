package junyoung.week1.wed.implement;

// https://programmers.co.kr/learn/courses/30/lessons/60057
public class practice3_문자열압축 {

	public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        int length = s.length();

        for (int i=1; i<=length; i++) {
            StringBuilder sb = new StringBuilder();
            String prev = s.substring(0, i);
            int start = i;
            int cnt = 1;
            
            while (true) {
                if (start+i > length) break;
                String now = s.substring(start, start+i);
                if (prev.equals(now)) {
                    cnt += 1;
                } else {
                    if (cnt > 1) sb.append(cnt);
                    sb.append(prev);
                    prev = now;
                    cnt = 1;
                }
                start += i;
            }
            
            if (cnt > 1) sb.append(cnt);
            sb.append(prev);
            sb.append(s.substring(start, length));
        
            answer = Integer.min(answer, sb.toString().length());
        }
        return answer;
	}
}