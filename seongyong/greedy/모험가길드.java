import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 모험가길드 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] people = new int[N];
        for(int i = 0; i<N; i++)
            people[i] = sc.nextInt();

        Arrays.sort(people);

        int cnt = 0;
        List<Integer> group  = new ArrayList<>();
        for (int p : people){
            group.add(p);
            if (group.size() >= p){
                cnt++;
                group.clear();
            }
        }

        System.out.println(cnt);

    }
}
