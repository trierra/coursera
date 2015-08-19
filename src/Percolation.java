import java.util.Random;

public class Percolation {
    private int N;
    private int[][] grid;
    private int max;

    public Percolation(int N) throws IllegalArgumentException {
        if (N <= 0) {
            throw new IllegalArgumentException();
        }
        this.N = N;
        grid = new int[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                grid[i - 1][j - 1] = ((i - 1) * N + j - 1) * -1;
            }
        }
        this.max = grid[N - 1][N - 1] * -1;
    }

    public void validate(int i) {
        if (i < 0 || i > N) {
            throw new IndexOutOfBoundsException();
        }
    }

    public void open(int i, int j) {
        validate(i);
        validate(j);
        if (isOpen(i, j)) {
            return;
        }
        Random random = new Random();
        grid[i][j] = random.nextInt(max);
        System.out.println(random.nextInt(max));
    }

    public boolean isOpen(int i, int j) {
        validate(i);
        validate(j);
        return grid[i][j] > 0;
    }

    public boolean isFull(int i, int j) {
        validate(i);
        validate(j);
        if (i == N - 1) {
            for (int k = 1; k < N + 1; k++) {
                if (find(1, k) == find(i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void findNeighbours(int i, int j) {
        int componentNum;
        if (grid[i - 1][j] > 0) {
            componentNum = grid[i - 1][j];
            union(i, j, componentNum);
        }
        if (grid[i + 1][j] > 0) {
            componentNum = grid[i + 1][j];
            union(i, j, componentNum);
        }
        if (grid[i][j - 1] > 0) {
            componentNum = grid[i][j - 1];
            union(i, j, componentNum);
        }
        if (grid[i][j + 1] > 0) {
            componentNum = grid[i][j + 1];
            union(i, j, componentNum);
        }
    }

    public void union(int i, int j, int componentNum) {
        int temp = grid[i][j];
        grid[i][j] = componentNum;
        for (int k = 1; k < N + 1; k++) {
            for (int p = 1; p < N + 1; p++) {
                if (grid[k][p] == temp) {
                    grid[k][p] = componentNum;
                }
            }
        }

    }

    public boolean percolates() {
        return false;
    }

    public int count() {
        return 0;
    }

    public int find(int i, int j) {
        validate(i);
        validate(j);
        return grid[i][j];
    }

    public static void main(String[] args) {
        Percolation percolation = new Percolation(20);
        Random random = new Random();
        percolation.open(random.nextInt(percolation.N), random.nextInt(percolation.N));
    }
}