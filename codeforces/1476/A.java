import java.io.*;
import java.util.*;
 
public class Main {
  static final FastReader FR = new FastReader();
  static final PrintWriter PW = new PrintWriter(new OutputStreamWriter(System.out));
 
  public static void main(String[] args) {
    StringBuilder solution = new StringBuilder();
    int tests = 1;
    tests = FR.nextInt();
    for (int t = 0; t < tests; ++t) {
      int elementCount = FR.nextInt();
      int sumModulo = FR.nextInt();
      int maxElement = getMaxElement(elementCount, sumModulo);
      solution.append(maxElement + "\n");
    }
		PW.print(solution.toString());
    PW.close();
  }

  static int getMaxElement(int elementCount, int sumModulo) {
    if (elementCount < sumModulo) {
      return LIG(sumModulo, elementCount);
    } else {
      return elementCount % sumModulo == 0 ? 1: 2;
    }
  }

  static int LIG(int numerator, int denominator) {
    return (numerator+denominator-1) / denominator;
  }
 
  static class FastReader {
    BufferedReader br;
    StringTokenizer st;
  
    public FastReader() {
      br = new BufferedReader(new InputStreamReader(System.in));
    }
  
    String next() {
      while (st == null || !st.hasMoreElements()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException  e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }
  
    int nextInt() {
      return Integer.parseInt(next());
    }
  
    long nextLong() {
      return Long.parseLong(next());
    }
  
    double nextDouble() {
      return Double.parseDouble(next());
    }
 
    String nextLine() {
      String str = "";
      try {
        str = br.readLine();
      } catch (IOException e)  {
        e.printStackTrace();
      }
      return str;
    }
  }
}