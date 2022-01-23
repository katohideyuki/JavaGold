package chapter_26;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * ストリームAPI<br>
 * - partitioningByメソッド<br>
 *
 */
public class SamplePartitioningBy {

  private static final List<Item> ITEM_LIST = Arrays.asList(new Item(1, ItemType.BOOK, "java", 1980),
      new Item(2, ItemType.BOOK, "Lambda", 2980), new Item(3, ItemType.MAGAZINE, "Software", 3980),
      new Item(4, ItemType.MAGAZINE, "Test", 4980), new Item(5, ItemType.BOOK, "GO", 5980));

  public static void main(String[] args) {
    executePartitioningBy();
  }

  /**
   * listストリームに対して、partitioningByメソッド実行<br>
   * -  partitioningByメソッドの戻り値としてマップを戻す<br>
   * -  マップのキーは条件に合致したかどうかのtrue/false<br>
   * -  バリューは要素<br>
   */
  private static void executePartitioningBy() {
    System.out.println("▼ executePartitioningByメソッド");

    Map<Boolean, List<Item>> partitionMap = ITEM_LIST.stream()
        .collect(Collectors.partitioningBy(item -> item.getPrice() > 3000));
    System.out.println(partitionMap);
  }

}
