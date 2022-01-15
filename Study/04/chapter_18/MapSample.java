package chapter_18;

import java.util.Arrays;
import java.util.List;

/**
 * ストリームAPI<br>
 * - mapメソッド<br>
 *
 */
public class MapSample {
  public static List<String> list = Arrays.asList("apple", "orange", "banana");

  public static void main(String[] args) {
    executeMap();
    executeValueOf();
  }

  /**
   * listストリームに対して、mapメソッドを実行<br>
   * - Function型のラムダ式を受け取り、ストリーム内の要素を処理する<br>
   */
  private static void executeMap() {
    System.out.println("▼ executeMapメソッド");
    list.stream().map(x -> x.toUpperCase()).forEach(x -> System.out.println(x));
  }

  /**
   * listストリームに対して、mapメソッドを実行<br>
   * - Function型のラムダ式を受け取り、ストリーム内の要素を処理する<br>
   * --- Function型なので、引数の型と戻り値の型が異なってもよい<br>
   */
  private static void executeValueOf() {
    System.out.println("▼ executeValueOfメソッド");
    list.stream().map(x -> x.length()).forEach(x -> System.out.println(x));
  }
}
