package chapter_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 入出力<br>
 * System.inフィールド/Console.console/readPasswordメソッド<br>
 *
 */
public class SampleConsole {
  public static void main(String[] args) {
    systemIn(); //  入力できる
//    executeConsole(); // 入力できずnullが返却される（なぜか入力待ちにならない）
//    usePassword(); // 入力できずnullが返却される（なぜか入力待ちにならない）
  }

  /**
   * System.inを使った例<br>
   * コンソールに入力された値を出力<br>
   * - 出力値とは別に、入力した値も表示される<br>
   */
  private static void systemIn() {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 入力した値が、一旦表示される
    try (br) {
      String input = br.readLine();
      System.out.println(input); // 入力した値が、出力値として表示される
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * consoleを使った例<br>
   * コンソールに入力された値を出力<br>
   * - 出力値とは別に、入力した値も表示される<br>
   */
  private static void executeConsole() {
    try {
      String console = System.console().readLine();
      System.out.println(console);
    } catch (NullPointerException e) {
      e.printStackTrace();
      System.out.println("入力待ちにならず、nullが返却されました");
    }
  }

  /**
   * コンソールに入力された値を出力<br>
   * - 出力値のみ表示される(入力値は出力されない）<br>
   */
  private static void usePassword() {
    try {
      char[] password = System.console().readPassword();
      System.out.println(String.valueOf(password));
    } catch (NullPointerException e) {
      e.printStackTrace();
      System.out.println("入力待ちにならず、nullが返却されました");
    }
  }
}
