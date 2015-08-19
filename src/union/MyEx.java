package union;

/**
 * Created by trierra on 6/24/15.
 */
public class MyEx extends RuntimeException{

    public static void main(String[] args) {
        int N = 20;
        int[][] grid = new int[N][N];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                grid[i - 1][j - 1] = ((i - 1) * N + j - 1) * -1;
                System.out.print(" " + grid[i - 1][j - 1]);
            }
            System.out.println();
        }
    }

}
