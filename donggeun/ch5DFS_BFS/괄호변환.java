package ch5DFS_BFS;

import java.util.Stack;

public class 괄호변환 {


    public static void main(String[] args) {
        System.out.println(new 괄호변환().solution("(()())()"));
    }


    public static boolean isRight(String p) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                stack.add('(');
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }

    public static String convert(String p) {
        if (p.equals("")) {
            return p;
        }

        String[] divided = divide(p);
        String u = divided[0];
        String v = divided[1];

        if (isRight(u)) {
            return u + convert(v);
        }

        String newString = "(" + convert(v) + ")";
        u = u.substring(1, u.length() - 1);
        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == '(') {
                newString += ')';
            } else {
                newString += '(';
            }
        }

        return newString;
    }

    public static String[] divide(String p) {
        int left = 0;
        int right = 0;

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                break;
            }
        }

        return new String[]{p.substring(0, left + right), p.substring(left + right)};

    }

    public String solution(String p) {
        return convert(p);
    }
}
