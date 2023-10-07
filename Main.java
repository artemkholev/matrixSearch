import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Main {
  public static long measureTime(Runnable codeToMeasure) {
    long startTime = System.nanoTime();
    codeToMeasure.run();
    return (System.nanoTime() - startTime);
  }
  static void first(int N, int M, int[][] matrix, int target) {
    String answer = "";
    int i = 0, j = N - 1;

    while (i < M && j >= 0) {
      if (matrix[i][j] == target) {
        answer = String.valueOf(i) + j;
        break;
      } else if (matrix[i][j] < target) {
        i++;
      } else if (matrix[i][j] > target) {
        j--;
      }
    }
//    System.out.println(!answer.isEmpty() ? "Yes" : "False");
  }

  static void second(int N, int M, int[][] matrix, int target) {
    String answer = "";
    for (int i = 0; i < M && answer.isEmpty(); i++) {
      int first = 0, last = N - 1;
      while(first <= last) {
        int middle = (first + last) / 2;
        if (matrix[i][middle] == target) {
          answer = String.valueOf(i) + middle;
          break;
        } else if (matrix[i][middle] < target) {
          first = middle + 1;
        } else if (matrix[i][middle] > target)
          last = middle - 1;
      }
    }
//    System.out.println(!answer.isEmpty() ? "Yes" : "False");
  }

  long Third() {
    long startTime = System.currentTimeMillis();
    long endTime = System.currentTimeMillis();
    return endTime - startTime;
  }
  public static void main(String[] args) {
    ArrayList<String> time = new ArrayList<String>();

    for (int k = 10; k <= Math.pow(2, 14); k += Math.pow(2, 6)) {
      final int M = k - k / 2 - k / 3,
                N = k;
      int[][] matrix = new int[M][N];
      int target = 2 * N + 1;
      for (int i = 0; i < M; i++) {
        for (int j = 0; j < N; j++) {
          matrix[i][j] = (N / M * i + j) * 2;
        }
      }

//      for (int i = 0; i < M; i++) {
//        for (int j = 0; j < N; j++) {
//          System.out.print(matrix[i][j] + " ");
//        }
//        System.out.println();
//      }
//      System.out.println(target);
//      long process = measureTime(() -> { first(N, M, matrix, target); });
      long process = measureTime(() -> { second(N, M, matrix, target); });
      time.add(N + " " + M + ", " + process + "\n");
    }
    System.out.println(time);
  }
}