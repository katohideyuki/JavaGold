package chapter_04;

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
   * - インナークラスBuilderを使用しないと、コンストラクタが呼べない<br>
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
   * ItemクラスのインナークラスBuilder<br>
   * - Itemクラスのコンストラクタの代わりに、setterメソッドを使う<br>
   * - Itemクラスのインスタンス初期化に必要な値を受け取る<br>
   *   - buildメソッドで、自分自身のインスタンスをItemクラスのコンストラクタに渡す<br>
   */
  public static class Builder {
    private int id;
    private String nameString;
    private int price;

    /**
     * インナークラスBuilderのコンストラクタ<br>
     *  - idが必須<br>
     */
    public Builder(int id) {
      this.id = id;
    }

    public Builder setName(String nameString) {
      this.nameString = nameString;
      return this;
    }

    public Builder setPrice(int price) {
      this.price = price;
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
