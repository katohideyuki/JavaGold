package chapter_03;

import java.util.Optional;

/**
 * 汎用とコレクション<br>
 * リフレクション/Classクラス/getAnnotationメソッド/アノテーションの保有期間<br>
 */
public class TestItem {
  public static void main(String[] a) {
    getItemInfo();
  }

  /**
   * Itemクラスに定義されている注釈パラメータを取得<br>
   * - getAnnnotation<br>
   * --- 取得したい定義情報を持つアノテーションのクラスリテラル(クラス名.class)を渡す<br>
   */
  private static void getItemInfo() {
    Class<Item> clazz = Item.class; // Itemクラスの定義情報を扱うインスタンスの参照取得
    Optional<Test> testOp = Optional.ofNullable(clazz.getAnnotation(Test.class)); // Itemクラスに付与されたTestアノテーション情報を取得
    testOp.ifPresent(test -> { /* Testアノテーションの情報を取得できた（nullじゃない）なら処理継続 */
      String name = test.name();
      int price = test.price();
      Item item = new Item(name, price);

      System.out.printf("name : %s, price : %d", item.getName(), item.getPrice());
    });
  }
}
