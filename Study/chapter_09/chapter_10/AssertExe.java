package chapter_10;

/**
 * 例外とアサーション<br>
 * assert/assertionError<br>
 * アサーションを有効にしてから、AssertExeを実行すること<br>
 * - https://www.zunouissiki.com/entry/2018/12/02/163855/<br>
 */
public class AssertExe {
  static SampleItem item = new SampleItem("apple", 100);

  public static void main(String[] args) {
    item.setName("banana");
    item.setName(null); // AssertionError
//    item.setPrice(-1); // AssertionError
  }
}
