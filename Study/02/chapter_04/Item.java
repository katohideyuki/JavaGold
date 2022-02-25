package chapter_04;

import java.util.function.Consumer;

/**
 * ビルダーを持つItemクラス<br>
 *
 */
public class Item {
  private int id;
  private String name;
  private int price;

  /**
   * Itemクラスのコンストラクタ<br>
   * - Builderを使用しないと、コンストラクタが呼べない<br>
   *
   * @param builder
   */
  private Item(Builder builder) {
    this.id = builder.id;
    this.name = builder.nameString;
    this.price = builder.price;
  }

  /**
   * Itemインスタンスのフィールド出力用<br>
   * - 確認のためSampleクラスで使用<br>
   */
  @Override
  public String toString() {
    return "Item[id=" + id + ",name=" + name + ",price=" + price + "]";
  }

  /**
   * ネストしたstaticクラスBuilderクラス（staticクラスなので、インナークラスとは言わない）<br>
   * - Itemクラスのコンストラクタの代わりに、setterメソッドを使う<br>
   * - Itemクラスのインスタンス初期化に必要な値を受け取る<br>
   * - buildメソッドで、自分自身のインスタンスをItemクラスのコンストラクタに渡す<br>
   */
  public static class Builder {
    private int id;
    public String nameString;
    public int price;

    /**
     * ネストしたBuilderクラスのコンストラクタ<br>
     * - idが必須<br>
     */
    public Builder(int id) {
      this.id = id;
    }

    // ▼ Consumerを使用することで、不要
//    public Builder setName(String nameString) {
//      this.nameString = nameString;
//      return this;
//    }
//    public Builder setPrice(int price) {
//      this.price = price;
//      return this;
//    }

    /**
     * Sampleクラスからラムダ式で直接、Builderクラスのフィールドにセットする<br>
     *
     * @param consumer
     * @return this
     */
    public Builder with(Consumer<Builder> consumer) {
      consumer.accept(this); // Builderのインスタンス自身への参照
      return this;
    }

    /**
     * 自分自身(Builderクラス)のインスタンスをItemクラスのコンストラクタに渡す<br>
     *
     * @return
     */
    public Item build() {
      return new Item(this);
    }

  }

}
