package 프로그래머스.level2;

import java.util.*;

public class 메뉴리뉴얼 {

    static Map<String, Integer> map;
    static int max;


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new 메뉴리뉴얼().solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4})));
    }

    private static String sortStr(String origin) {
        char[] result = origin.toCharArray();
        Arrays.sort(result);
        return new String(result);
    }

    public static void combination(int cnt, int start, int end, String order, String oneCase) {

        if (cnt == end) {
            String sorted = sortStr(oneCase);
            if (map.get(sorted) == null) {
                map.put(sorted, 1);
            } else {
                int next = map.get(sorted) + 1;
                map.replace(sorted, next);
                max = Math.max(max, next);
            }
            return;
        }

        for (int i = start; i < order.length(); i++) {
            combination(cnt + 1, i + 1, end, order, oneCase + order.charAt(i));
        }

    }

    public String[] solution(String[] orders, int[] course) {

        List<String> result = new ArrayList<>();

        for (int menuCount : course) {
            map = new HashMap<>();
            max = 0;
            for (String order : orders) {
                combination(0, 0, menuCount, order, "");
            }

            if (max < 2) {
                continue;
            }

            for (String key : map.keySet()) {
                if (map.get(key) == max) {
                    result.add(key);
                }
            }
        }

        Collections.sort(result);

        return result.toArray(new String[result.size()]);
    }


}
