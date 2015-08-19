import union.MyEx;

/**
 * Created by trierra on 7/16/15.
 */
public class alg {
    public static void main(String[] args) {
        for (int N = 1; N < 1000000; N = 10 * N) {
            int sum = 0;
            for (int i = 1; i*i <= N; i = i*4)
                for (int j = 0; j < i; j++)
                    sum++;

            System.out.println(N  +  " " + sum);
        }
        throw new MyEx();
    }

}
