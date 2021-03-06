// Author : RegalBeast

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class Main implements Runnable {
  static Input in = new Input();
  static PrintWriter out = Output();
  
  public static void main(String[] args) {
    new Thread(null, new Main(), String.join(
                                  "All that is gold does not glitter,",
                                  "Not all those who wander are lost;",
                                  "The old that is strong does not wither,",
                                  "Deep roots are not reached by the frost.",
                                  
                                  "From the ashes a fire shall be woken,",
                                  "A light from the shadows shall spring;",
                                  "Renewed shall be blade that was broken,",
                                  "The crownless again shall be king."
                                ), 1<<25).start();
  }

  public void run() {
    int studentCount = in.nextInt();
    int[] pointsAt = new int[studentCount];
    for (int s = 0; s < studentCount; s++) {
      pointsAt[s] = in.nextInt()-1;
    }

    int[] caughtArr = getCaughtArr(studentCount, pointsAt);
    for (var student : caughtArr) {
      out.print(student + " ");
    }
    in.close();
    out.close();
  }

  static int[] getCaughtArr(int studentCount, int[] pointsAt) {
    int[] caughtArr = new int[studentCount];
    boolean[] considered = new boolean[studentCount];

    for (int s = 0; s < studentCount; s++) {
      setCaught(caughtArr, s, pointsAt, considered);
    }
    return caughtArr;
  }

  static int setCaught(int[] caughtArr, int s, int[] pointsAt, boolean[] considered) {
    if (caughtArr[s] != 0) {
      return -1;
    }

    if (considered[s]) {
      caughtArr[s] = s+1;
      return s;
    }

    considered[s] = true;
    int nextSet = setCaught(caughtArr, pointsAt[s], pointsAt, considered);
    if (nextSet != -1) {
      caughtArr[s] = s+1;

      if (s == nextSet) {
        return -1;
      }
    } else {
      caughtArr[s] = caughtArr[pointsAt[s]];
    }
    return nextSet;
  }

  static PrintWriter Output() {
    return new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
  }
  
  static PrintWriter Output(String fileName) {
    PrintWriter pw = null;
    try {
      pw = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    return pw;
  }
}

class Input {
  BufferedReader br;
  StringTokenizer st;
  public Input() {
    br = new BufferedReader(new InputStreamReader(System.in));
  }

  public Input(String fileName) {
    try {
      br = new BufferedReader(new FileReader(fileName));
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  public String next() {
    while (st == null || !st.hasMoreElements()) {
      try {
        st = new StringTokenizer(br.readLine());
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
    return st.nextToken();
  }

  public int nextInt() {
    return Integer.parseInt(next());
  }

  public long nextLong() {
    return Long.parseLong(next());
  }

  public Float nextFloat() {
    return Float.parseFloat(next());
  }

  public Double nextDouble() {
    return Double.parseDouble(next());
  }

  public String nextLine() {
    if (st != null && st.hasMoreElements()) {
      StringBuilder sb = new StringBuilder();
      while (st.hasMoreElements()) {
        sb.append(next());
      }
      return sb.toString();
    }

    String str = null;
    try {
      str = br.readLine();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    return str;
  }

  public void close() {
    try {
      br.close();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}