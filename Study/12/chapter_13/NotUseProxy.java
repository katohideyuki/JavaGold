package chapter_13;

import java.io.Serializable;

/**
 * シリアライズ・プロキシを利用しないクラス<br>
 */
public class NotUseProxy implements Serializable  {
  private String name;
  private int price;

  public NotUseProxy(String name, int price) {
    if (name == null || price < 0) { /* 不正値チェック */
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
}
