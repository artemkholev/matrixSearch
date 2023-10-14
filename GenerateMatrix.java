public class GenerateMatrix {
    int[][] matrix;
    public final int M, N;
    public GenerateMatrix(int k) {
        this.M = k - k / 2 - k / 3;
        this.N = k;
        this.matrix = new int[this.M][this.N];
    }

    public void addDataFirst() {
        for (int i = 0; i < this.M; i++) {
            for (int j = 0; j < this.N; j++)
                this.matrix[i][j] = (this.N / this.M * i + j) * 2;
        }
    }

    public void addDataSecond() {
        for (int i = 0; i < this.M; i++) {
            for (int j = 0; j < this.N; j++)
                this.matrix[i][j] = (this.N / this.M * i * j) * 2;
        }
    }

    public int getFirstTarget() {
        return 2 * this.N + 1;
    }

    public int getSecondTarget() {
        return 16 * this.N + 1;
    }

    public void printMatrix() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }
}
