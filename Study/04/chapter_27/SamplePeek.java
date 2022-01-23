package chapter_27;

import java.util.Arrays;
import java.util.List;

/**
 * ストリームAPI<br>
 * - peekメソッド<br>
 *
 */
public class SamplePeek {
  public static void main(String[] args) {
    executePeek();
    executeQestion();
  }

  /**
   * listストリームに対して、peekメソッド実行<br>
   * - デバッグなどの目的でストリーム・パイプラインの途中でどのような状態になっているか確認<br>
   * - 結果が混在しているのは、要素が一つずつ渡されているから<br>
   * - stream -> map -> peek -> filter -> forEach -> map -> peek ->...省略<br>
   */
  private static void executePeek() {
    System.out.println("▼ executePeekメソッド");
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
    list.stream()
    .map(x -> x * 3) // 処理
        .peek(x -> System.out.println("debug : " + x)) // いまのストリームの状態を確認
        .filter(x -> x % 2 == 0) // 絞り込み
        .forEach(x -> System.out.println("value : " + x));
  }

  /**
   * Q.27<br>
   */
  private static void executeQestion() {
    System.out.println("▼ executeQestionメソッド");
    List<String> list = Arrays.asList("banana", "apple", "orange");
    list.stream().filter(str -> str.length() > 5) // 処理1
        .peek(str -> System.out.println(str + " ")) // いまのストリームの状態を確認
        .map(str -> str.toUpperCase()) // 処理2
        .peek(str -> System.out.println(str + " ")) // いまのストリームの状態を確認
        .forEach(str -> System.out.println(str));
  }
}
