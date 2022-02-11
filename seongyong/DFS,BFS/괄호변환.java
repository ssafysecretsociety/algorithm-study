// https://programmers.co.kr/learn/courses/30/lessons/60058

import java.util.Stack;

public class 괄호변환 {
    public String solution(String p) {
        return bracket(p);
    }

    public static String bracket(String str) {
        if (str.equals(""))
            return "";

        int idx = balance(str);
        System.out.println(idx);
        String u = str.substring(0, idx);
        String v = str.substring(idx);

        if (correct(u))
            return u + bracket(v);
        else {
            String tmp = "(" + bracket(v) + ")";

            String reverse = u.substring(1, u.length() - 1);
            reverse = reverse.replaceAll("\\(", ",");
            reverse = reverse.replaceAll("\\)", "(");
            reverse = reverse.replaceAll(",", ")");

            return tmp + reverse;
        }
    }

    public static int balance(String str) {
        // 균형잡힌 문자열
        int left = 0, right = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(')
                left++;
            else if (ch == ')')
                right++;

            if (left == right)
                return i + 1;
        }
        return 0;
    }

    public static boolean correct(String str) {
        // 올바른 괄호 문자열
        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            try {
                if (ch == '(')
                    stk.push(ch);
                else if (ch == ')')
                    stk.pop();
            }
            // 만약 스택이 비었는데 pop 이 실행되어 나오는 오류를 막는다
            catch (Exception e) {
                return false;
            }
        }

        // stack 에러가 없으며, stack의 size가 0 일때
        // 올바르고 균형잡힌 문자열
        if (stk.size() == 0)
            return true;

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new 괄호변환().solution("()))((()"));
    }
}
