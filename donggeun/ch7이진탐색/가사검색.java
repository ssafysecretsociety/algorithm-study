package ch7이진탐색;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 가사검색 {
    public static void main(String[] args) {
        String[] words = new String[]{"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = new String[]{"fro??", "????o", "fr???", "fro???", "pro?"};
        System.out.println(Arrays.toString(new 가사검색().solution(words, queries)));
//        (new StringBuffer(word)).reverse().toString()
    }

    public static int binarySearch(String[] words, String query) {

        int left = Arrays.binarySearch(words, query);

        query = query.replace('?', 'z') + 'z';
        int right = Arrays.binarySearch(words, query);

        return Math.abs(right - left);
    }

    public int[] solution(String[] words, String[] queries) {
        ArrayList<String>[] wordsByLength = new ArrayList[10001];
        ArrayList<String>[] wordsByLengthReverse = new ArrayList[10001];

        int wordLength = 0;
        for (String word : words) {
            wordLength = word.length();
            if (wordsByLength[wordLength] == null) {
                wordsByLength[wordLength] = new ArrayList<>();
                wordsByLengthReverse[wordLength] = new ArrayList<>();
            }
            wordsByLength[wordLength].add(word);
            wordsByLengthReverse[wordLength].add(new StringBuffer(word).reverse().toString());
        }


        for (int i = 0; i < wordsByLength.length; i++) {
            if (wordsByLength[i] != null) {
                Collections.sort(wordsByLength[i]);
                Collections.sort(wordsByLengthReverse[i]);
            }
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

            String[] wordsWithSameLength = null;

            // 1. 뒤가 ??인 경우 (fro??)
            if (query.charAt(0) != '?') {
                wordsWithSameLength = wordsByLength[queryLength].toArray(new String[wordsByLength[queryLength].size()]);
            } else {
                query = new StringBuffer(query).reverse().toString();
                wordsWithSameLength = wordsByLengthReverse[queryLength].toArray(new String[wordsByLength[queryLength].size()]);
            }

            result[i] = binarySearch(wordsWithSameLength, query);
        }

        return result;
    }
}
