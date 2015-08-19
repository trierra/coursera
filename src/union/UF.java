package union;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by trierra on 6/23/15.
 */
public class UF {
    private int[] id;
    private int count;


    public UF(int N) {
        this.count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    void union(int p, int q) {


    }

    int find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }

    boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    int count() {
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        UF uf = new UF(N);

        int i = 0;
        while (i < N) {
            int p = sc.nextInt();
            int q = sc.nextInt();
            if (uf.connected(p, q)) {
                continue;
            } else {
                uf.union(p, q);
                System.out.println(p + " " + q);
            }
            i++;
        }
        System.out.println(uf.count() + "  components");
    }

}
