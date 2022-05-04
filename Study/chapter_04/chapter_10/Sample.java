package chapter_10;

import java.util.List;

/**
 * ストリームAPI<br>
 * - forEachメソッド<br>
 */
public class Sample {
  public static void main(String[] args) {
    executeStream();
  }

  /**
   * ストリームAPIの使用例<br>
   * - リストからストリームを作る<br>
   * --- streamメソッド<br>
   * - 生成したストリームに対して、終端操作forEachメソッドを実行<br>
   */
  public static void executeStream() {
    List<Integer> list = List.of(1, 2, 3, 4, 5);
    list.stream().forEach(System.out::println);
  }
}
