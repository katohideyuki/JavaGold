package sec01_Optional;

/**
 * getFromArrayメソッドの使用例<br>
 * - 要素数を超えた要素番号を指定してArrayIndexOutOfBoundsException発生<br>
 *
 */
public class OldTest {
  public static void main(String[] a) {
    executeFromArray();
  }

  private static void executeFromArray() {
    try {
      String result = getFromArray(new String[] { "A", "B", null }, 3);
      // 空チェック
      if (result == null) {
        System.out.println("empty");
        return;
      }
      System.out.println(result);
    } catch (IllegalArgumentException e) {
      System.out.println("Exception発生");
    }
  }

  /**
   * 引数の配列がnull,または引数のインデックスが配列の要素数を超えていれば<br>
   * - IllegalArgumentException<br>
   *
   * @param <T>       <br>
   * @param array<br>
   * @param index<br>
   * @return array配列の要素<br>
   */
  private static <T> T getFromArray(/* 配列 */T[] array, /* 要素番号 */int index) {
    // nullチェック
    if (array == null) {
      System.out.println("配列がnull");
      throw new IllegalArgumentException();
    }
    try {
      return array[index];
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println(e);
      throw new IllegalArgumentException();
    }

  }
}
