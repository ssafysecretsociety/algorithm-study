import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 문자열재정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();

        Arrays.sort(str);

        String result = "";
        int sum = 0;

        for (int i = 0; i < str.length; i++) {
            if(Character.isDigit(str[i]))
                sum += (str[i] - '0');
            else
                result += str[i];
        }

        System.out.println(result += String.valueOf(sum));
    }
}
