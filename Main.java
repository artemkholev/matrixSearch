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
  static boolean firstAlgorithm(int N, int M, int[][] matrix, int target) {
    int i = 0, j = N - 1;
    while (i < M && j >= 0) {
      if (matrix[i][j] == target) {
        return true;
      } else if (matrix[i][j] < target) {
        i++;
      } else if (matrix[i][j] > target) {
        j--;
      }
    }
    return false;
  }

  static boolean secondAlgorithm(int N, int M, int[][] matrix, int target) {
    String answer = "";
    for (int i = 0; i < M && answer.isEmpty(); i++) {
      int first = 0, last = N - 1;
      answer = binarySearch(first, last, i, target, matrix);
    }
    return !answer.isEmpty();
  }

  static boolean thirdAlgorithm(int N, int M, int[][] matrix, int target) {
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
        return true;
      }
    }
    return false;
  }



  public static void main(String[] args) {
    ArrayList<String> time = new ArrayList<String>();
    for (int k = 10; k <= Math.pow(2, 14); k += Math.pow(2, 6)) {
      GenerateMatrix matrix = new GenerateMatrix(k);

//      int target = matrix.getFirstTarget();
//      matrix.addDataFirst();

      matrix.addDataSecond();
      int target = matrix.getSecondTarget();

//      long process = TimeWork.measureTime(() -> { firstAlgorithm(matrix.N, matrix.M, matrix.matrix, target); });
//      long process = TimeWork.measureTime(() -> { secondAlgorithm(matrix.N, matrix.M, matrix.matrix, target); });
      long process = TimeWork.measureTime(() -> { thirdAlgorithm(matrix.N, matrix.M, matrix.matrix, target); });
      time.add(matrix.N + " " + matrix.M + ", " + process);
    }
    for (int i = 0; i < time.size(); i++) {
      System.out.println(time.get(i));
    }
  }
}