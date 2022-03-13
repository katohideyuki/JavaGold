package chapter_13;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * シリアライズ・プロキシを利用したクラス<br>
 */
public class UseProxy implements Serializable {
  private String name;
  private int price;

  public UseProxy(String name, int price) {
    if (name == null || price < 0) { /* 不正値チェック */
      System.out.println("不正な値です。name = " + name + ", price = " + price);
      throw new IllegalArgumentException();
    }
    this.name = name;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public int getPrice() {
    return price;
  }

  public void setName(String name) {
    this.name = name;
  }

  /**
   * シリアライズされるときに自動的に呼び出される<br>
   * - UseProxyの代わりに、SeriSerializationProxyがシリアライズされる<br>
   *
   * @return UseProxyオブジェクトと同じフィールド値を持ったSerializationProxyオブジェクト
   */
  private Object writeReplace() {
    System.out.println("writeReplaceが実行されました"); // debug用
    return new SerializationProxy(name, price);
  }

  /* ネストしたstaticなクラス */
  private static class SerializationProxy implements Serializable {
    private final String name;
    private final int price;

    public SerializationProxy(String name, int price) {
      this.name = name;
      this.price = price;
    }

    /**
     * デシリアライズされるときに自動的に呼び出される<br>
     * - デシリアライズ時でも、コンストラクタを使って初期化されるため、不正値チェックが機能する<br>
     *
     * @return 復元されたSeriSerializationProxyオブジェクトと同じフィールド値を持ったUseProxyオブジェクトを戻す
     */
    private Object readResolve() {
      System.out.println("readResolveが実行されました"); // debug用
      return new UseProxy(name, price);
    }

  }

}
