package chapter_13;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * セキュアコーディング<br>
 * 「シリアライズ・プロキシ」デザインパターン<br>
 */
public class Main {
  static final String FILE_NAME = "NotUseProxy.ser";

  public static void main(String[] args) {
    NotUseProxyExe();
    UseProxyExe();
  }

  /**
   * 「シリアライズ・プロキシ」デザインパターンを利用しない<br>
   * - デシリアライズする際に、コンストラクタを使わずにインスタンス生成される<br>
   * - そのため、不正値を持ったインスタンスが生成される恐れがある<br>
   */
  private static void NotUseProxyExe() {
    System.out.println("Main.NotUseProxyExe()-----------------");
    SerializExe(false);
    NotUseProxy notProxy = DeserializExe();
    System.out.println("name = " + notProxy.getName() + ", price = " + notProxy.getPrice()); // String.formatだとエラーになる
  }

  /**
   * 「シリアライズ・プロキシ」デザインパターンを利用する<br>
   * - デシリアライズする際でも、コンストラクタを使ってインスタンスが生成される<br>
   * - そんため、不正値チェックが毎回機能する<br>
   */
  private static void UseProxyExe() {
    System.out.println("Main.UseProxyExe()-----------------");
    SerializExe(true);
    UseProxy useProxy = DeserializExe();
    System.out.println("name = " + useProxy.getName() + ", price = " + useProxy.getPrice());
  }

  /**
   * シリアライズ化<br>
   * - 悪意ある内容に書き換えられた体で、事前にフィールド値をnullに変えてシリアライズ化する<br>
   * - 引数によって、どのオブジェクトを生成するか分岐する<br>
   *
   * @param UsePorxyオブジェクト: true, NotUsePrixyオブジェクト:false
   */
  private static void SerializExe(Boolean bool) {
    try {
      ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
      try (out) {
        if (bool) {
          // UseProxyをシリアライズ化
          UseProxy proxy = new UseProxy("UseProxy : apple", 100);
          proxy.setName(null);
          out.writeObject(proxy);
        } else {
          // NotUseProxyをシリアライズ化
          NotUseProxy proxy = new NotUseProxy("NotUseProxy : banana", 200);
          proxy.setName(null);
          out.writeObject(proxy);
        }
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * デシリアライズ化<br>
   *
   * @return デシリアライズされたオブジェクト
   */
  private static <T> T DeserializExe() {
    try {
      ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME));
      try (in) {
        @SuppressWarnings("unchecked")
        var proxy = (T) in.readObject();
        return proxy;
      }
    } catch (IOException | ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
}
