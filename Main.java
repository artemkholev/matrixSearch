import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Main {
  public static String binarySearch(int start, int end, int row, int target, int[][] matrix) {
    while(start <= end) {
      int middle = (start + end) / 2;
      if (matrix[row][middle] == target) {
        return String.valueOf(row) + middle;
      } else if (matrix[row][middle] < target) {
        start = middle + 1;
      } else if (matrix[row][middle] > target)
        end = middle - 1;
    }
    return "";
  }
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
      answer = binarySearch(first, last, i, target, matrix);
    }
//    System.out.println(!answer.isEmpty() ? "Yes" : "False");
  }

  static void third(int N, int M, int[][] matrix, int target) {
    String answer = "";
    int i = 1, j = N - 1;
    while (i < M && matrix[i][j] < target) {
      i *= 2;
    }

    int find_pos_start = i / 2, find_pos_end = Math.min(i, M - 1);
    for (int k = find_pos_start; k <= find_pos_end; k++){
      i = 1;
      while (i < N && matrix[k][i] < target) {
        i *= 2;
      }
      int first = i / 2, last = Math.min(i, N - 1);
      answer = binarySearch(first, last, k, target, matrix);
      if (!answer.isEmpty()) {
//        System.out.println("Yes");
        return;
      }
    }
//    System.out.println("False");
  }

  public static void main(String[] args) {
    ArrayList<String> time = new ArrayList<String>();

    for (int k = 10; k <= Math.pow(2, 14); k += Math.pow(2, 6)) {
//      int k = 10;
      final int M = k - k / 2 - k / 3,
                N = k;
      int[][] matrix = new int[M][N];
      //first target
      int target = 2 * N + 1;
      //second target
//      int target = 16 * N + 1;
      for (int i = 0; i < M; i++) {
        for (int j = 0; j < N; j++) {
          //first matrix
          matrix[i][j] = (N / M * i + j) * 2;
          //second matrix
//          matrix[i][j] = (N / M * i * j) * 2;
        }
      }

//      for (int i = 0; i < M; i++) {
//        for (int j = 0; j < N; j++) {
//          System.out.print(matrix[i][j] + " ");
//        }
//        System.out.println();
//      }
//      System.out.println(target);

      long process = measureTime(() -> { first(N, M, matrix, target); });
//      long process = measureTime(() -> { second(N, M, matrix, target); });
//      long process = measureTime(() -> { third(N, M, matrix, target); });
      time.add(N + " " + M + ", " + process + "\n");
    }
    System.out.println(time);
  }
}