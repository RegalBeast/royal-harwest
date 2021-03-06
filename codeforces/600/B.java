import java.util.Scanner;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int aLen = scanner.nextInt();
    int bLen = scanner.nextInt();

    Integer[] a = new Integer[aLen];
    for (int i = 0; i < aLen; i++) {
      a[i] = scanner.nextInt();
    }

    int[] b = new int[bLen];
    for (int i = 0; i < bLen; i++) {
      b[i] = scanner.nextInt();
    }

    int[] solutionArr = getSolutionArr(a, b);
    for (var num : solutionArr) {
      System.out.print(num + " ");
    }
    System.out.println();
  }

  static int[] getSolutionArr(Integer[] a, int[] b) {
    Arrays.sort(a);
    int[] solutionArr = new int[b.length];
    
    for (int i = 0; i < solutionArr.length; i++) {
      solutionArr[i] = getValue(a, b[i]);
    }
    return solutionArr;
  }

  static int getValue(Integer[] a, int bi) {
    int left = 0;
    int right = a.length-1;
    int ans = 0;

    while (left <= right) {
      int mid = (left + right) >> 1;
      if (a[mid] <= bi) {
        left = mid + 1;
        ans = left;
      } else {
        right = mid - 1;
      }
    }
    return ans;
  }
}