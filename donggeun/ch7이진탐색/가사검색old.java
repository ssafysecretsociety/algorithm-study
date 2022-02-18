package ch7이진탐색;

import java.util.ArrayList;
import java.util.Arrays;

public class 가사검색old {
    public static void main(String[] args) {
        String[] words = new String[]{"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = new String[]{"fro??", "????o", "fr???", "fro???", "pro?"};
        System.out.println(Arrays.toString(new 가사검색old().solution(words, queries)));
    }

    public static int binarySearch(String[] words, String leftKey, String rightKey) {
        int left = Arrays.binarySearch(words, leftKey);
        int right = Arrays.binarySearch(words, rightKey);

        return right - left - 1;
    }

    public int[] solution(String[] words, String[] queries) {
        ArrayList<String>[] wordsByLength = new ArrayList[10001];
        ArrayList<String>[] wordsByLengthReverse = new ArrayList[10001];

        StringBuilder sb = null;
        for (String word : words) {
            if (wordsByLength[word.length()] == null) {
                wordsByLength[word.length()] = new ArrayList<>();
                wordsByLengthReverse[word.length()] = new ArrayList<>();
            }
            wordsByLength[word.length()].add(word);
            wordsByLengthReverse[word.length()].add(new StringBuilder().append(word).reverse().toString());
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            // 각각의 쿼리에 대하여
            String query = queries[i];
            int queryLength = query.length();

            if (wordsByLength[queryLength] == null) {
                result[i] = 0;
                continue;
            }

            ArrayList<String> wordsWithSameLength = new ArrayList<>();

            // 1. 뒤가 ??인 경우 (fro??)
            if (query.charAt(0) != '?') {
                wordsWithSameLength.addAll(wordsByLength[queryLength]);


            } else {
                query = new StringBuilder().append(query).reverse().toString();
                wordsWithSameLength.addAll(wordsByLengthReverse[queryLength]);
            }

            wordsWithSameLength.add(query);

            String newQuery = query.replace('?', 'z') + "z";
            wordsWithSameLength.add(newQuery);
            String[] addedWords = wordsWithSameLength.toArray(new String[wordsWithSameLength.size()]);
            Arrays.sort(addedWords);

            result[i] = binarySearch(addedWords, query, newQuery);
        }

        return result;
    }
}
