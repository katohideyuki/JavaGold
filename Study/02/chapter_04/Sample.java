package chapter_04;

/**
 * ItemクラスのインナークラスBuilderを使うSampleクラス<br>
 *
 */
public class Sample {
  public static void main(String[] args) {
    excuteBuilder();
  }

  /**
   * Builderクラスを経由して、Itemクラスのインスタンスを生成<br>
   *  - Builderインスタンス生成<br>
   *    - setName, setPriceメソッドでBuilderフィールドに値をセット<br>
   *      - buildメソッドでBuilderクラスのインスタンスをItemクラスのコンストラクタに渡す<br>
   *        - Itemクラスのインスタンス生成完了<br>
   */
  public static void excuteBuilder() {
    Item item = new Item.Builder(100).setName("apple").setPrice(120).build();
    System.out.println(item);
  }

}
