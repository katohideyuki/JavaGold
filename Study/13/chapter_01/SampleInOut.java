package chapter_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 総仕上げ<br>
 * BufferedReader/InputStreamReader<br>
 */
public class SampleInOut {
  public static void main(String[] a) {
    OutputInputed();
  }

  private static void OutputInputed() {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      System.out.println("in : ");
      String input = br.readLine();
      System.out.printf(" out: %s%n", input);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}

