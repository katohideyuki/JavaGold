package chapter_24;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import chapter_23.Item;
import chapter_23.ItemType;

/**
 * ストリームAPI<br>
 * - groupingByメソッド<br>
 *
 */
public class SampleGroupingBy {

  private static final List<Item> ITEM_LIST = Arrays.asList(new Item(1, ItemType.BOOK, "java", 1980),
      new Item(2, ItemType.BOOK, "Lambda", 2980), new Item(3, ItemType.MAGAZINE, "Software", 3980),
      new Item(4, ItemType.MAGAZINE, "Test", 4980), new Item(5, ItemType.BOOK, "GO", 5980));

  public static void main(String[] args) {
    executeGroupingBy();
  }

  /**
   * ITEM_LISTストリームに対して、groupingByメソッド実行<br>
   * - ItemTypeをキーにしたMapが戻り、itemTypeフィールド値によってグルーピングされる<br>
   */
  private static void executeGroupingBy() {
    System.out.println("▼ executeGroupingByメソッド");

    // ItemType
    Map<ItemType, List<Item>> groupMap = ITEM_LIST.stream().collect(Collectors.groupingBy(item -> item.getItemType()));
    System.out.println(groupMap);
  }
}
