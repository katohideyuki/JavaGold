package chapter_04;

import java.util.function.Consumer;

/** Consumer を使用した Builder パターン - Builder を持つクラス */
public class ItemBuilder {
  private final int id;      // 商品ID
  private final String name; // 名前
  private final int price;   // 値段

  /* コンストラクタ - Builder を使用しないと、コンストラクタが呼べない */
  private ItemBuilder(Builder builder) {
    id    = builder.id;
    name  = builder.name;
    price = builder.price;
  }

  /* debug */
  @Override
  public String toString() {
    return String.format("Item[id=%s, name=%s, price=%s]", id, name, price);
  }

  /* ItemBuilder と同じフィールドを持つ、ネストされた static な Builder クラス */
  public static class Builder {
    // 必須パラメータ
    private int id;
    // オプションパラメータ
    public String name;
    public int price;

    /* Builder のコンストラクタ - id が必須 */
    public Builder(int id) {
      this.id = id;
    }

    /* 値がセットされた自分自身(Builder インスタンス)を返しているから、メソッドチェーンできる */
    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public Builder setPrice(int price) {
      this.price = price;
      return this;
    }

    /* オプションパラメータにセットする Consumer のラムダ式を受け取り、
       値をセットしたあと、自分自身(Builder インスタンス)を返却する */
    public Builder with(Consumer<Builder> consumer) {
      consumer.accept(this); // 自分自身への参照(Builder インスタンス)
      return this;
    }

    /* 自分自身(Builder インスタンス)を ItemBulder クラスのコンストラクタに渡す */
    public ItemBuilder build() {
      return new ItemBuilder(this);
    }
  }
}

/**
 * <pre>
 * ※1
 * ネストした static な Builder クラス (static なので、インナークラスとは言わない)
 *   - ItemBuilder クラスのコンストラクタの代わりに、setter メソッドを使う
 *   - ItemBuilder クラスのインスタンス初期化に必要な値を受け取る
 *   - build メソッドで、自分自身のインスタンスを ItemBuilder クラスのコンストラクタに渡す
 * </pre>
 */