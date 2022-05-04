package chapter_01;

import java.util.Optional;

/**
 * Optionalクラスの使用例<br>
 * - newでインスタンス生成できない<br>
 *
 */
public class Test {
  public static void main(String[] a) {
    executeOptional();
  }

  /**
   * getFromArrayの結果<br>
   * - 空のOptionalインスタンスの参照であれば、emptyを出力<br>
   * - 正常な処理結果であれば、その結果を出力<br>
   */
  private static void executeOptional() {
    Optional<String> result = getFromArray(new String[] { "A", "B", null }, 3);
    // 空チェック
    if (result.isEmpty()) {
      System.out.println("empty");
      return;
    }
    System.out.println(result.get()); // 正常な処理結果を受け取る
  }

  /**
   * 以下の場合、空のOptionalインスタンスの参照を戻す<br>
   * - 1.引数の配列がnull<br>
   * - 2.引数のインデックスが配列の要素数を超えている<br>
   * - 3.指定した要素がnull<br>
   *
   * @param <T>       <br>
   * @param array<br>
   * @param index<br>
   * @return array配列の要素 or 空のOptionalインスタンスの参照<br>
   */
  private static <T> Optional<T> getFromArray(T[] array, int index) {
    // nullチェック
    if (array == null) {
      System.out.println("配列がnull");
      return Optional.empty(); // 1
    }
    try {
      return Optional.ofNullable(array[index]); // array配列の要素を戻す(null許容 3)
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println(e);
      return Optional.empty(); // 2
    }
  }

}
