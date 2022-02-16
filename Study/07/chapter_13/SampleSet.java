package chapter_13;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 汎用とコレクション<br>
 * TreeSet/HashSetクラス<br>
 */
public class SampleSet {
  public static void main(String[] args) {
    setExe();
  }

  /**
   * TreeSet, HashSetコレクション<br>
   * - TreeSetは順序を保証する<br>
   * - HashSetは順序を保証しない<br>
   * 文字を追加したあと、1~100の整数をさらに追加し、出力<br>
   */
  private static void setExe() {
    // TreeSetは順序を保証する ※要素の並べ替えの仕方が不明。。
    Set<String> set = new TreeSet<>();
    Collections.addAll(set/* 格納するリスト */, "B", "A", "E", "D", "A", "C"/* 要素 可長変 */);
    for (int i = 0; i < 100; i++) {
      set.add(String.valueOf(i));
    }
    System.out.println("TreeSet------------------------");
    set.stream().forEach(x -> System.out.println(x));

    // HashSetは順序を保証しない
    HashSet<String> setList = new HashSet<>();
    Collections.addAll(setList, "c", "a", "b", "e", "d", "a");
    for (int i = 0; i < 100; i++) {
      setList.add(String.valueOf(i));
    }
    System.out.println("HashSet------------------------");
    setList.stream().forEach(x -> System.out.println(x));
  }
}
