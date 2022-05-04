package chapter_15;

import java.util.HashMap;
import java.util.Map;

/**
 * 汎用とコレクション<br>
 * Map.Entryインナーインタフェース<br>
 */
public class SampleEntry {
  public static void main(String[] args) {
    entryExe();
    question();
  }

  /**
   * Entryインナーインタフェース<br>
   * - key, valueのペアを管理する<br>
   * --- entyrSetメソッドで、[key, value]の1ペアを取り出す<br>
   * putメソッドであれば、順序は保証される<br>
   */
  private static void entryExe() {
    System.out.println("entryExe-------------------");
    Map<String, Integer> map = new HashMap<>();
    map.put("A", 1);
    map.put("B", 2);
    map.put("C", 3);

    map.entrySet().stream().forEach((Map.Entry<String, Integer> entry) -> {
      String key = entry.getKey();
      Integer val = entry.getValue();
      System.out.printf("%s : %d %n", key, val);
    });
  }

  /**
   * Q.15<br>
   */
  private static void question() {
    System.out.println("question-------------------");
    var a = Map.entry(1, "A");
    var b = Map.entry(2, "B");
    var c = Map.entry(3, "C");
    Map<Integer, String> map = Map.ofEntries(a, b, c);

    for (Map.Entry<Integer, String> enrty : map.entrySet()) {
      System.out.printf("%d : %s %n", enrty.getKey(), enrty.getValue());
    }
  }
}
