package chapter_25;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * ストリームAPI<br>
 * - summingInt/summingLong/summingDoubleメソッド<br>
 * --- 型が違うだけ<br>
 *
 */
public class SampleSummingInt {

  private static final List<Item> ITEM_LIST = Arrays.asList(
      new Item(1, ItemType.BOOK, "java", 1980),
      new Item(2, ItemType.BOOK, "Lambda", 2980),
      new Item(3, ItemType.MAGAZINE, "Software", 3980),
      new Item(4, ItemType.MAGAZINE, "Test", 4980),
      new Item(5, ItemType.BOOK, "GO", 5980));

  public static void main(String[] args) {
    executeSummingInt();
  }

  /**
   * listストリームに対して、summingIntメソッド実行<br>
   * - Map型のインスタンス生成し、その参照値が戻る<br>
   * - キーにはgroupingByメソッドの戻り値型であるItemType型の値<br>
   * - バリューにはsummingIntメソッドの戻り値型であるInteger型の値<br>
   */
  private static void executeSummingInt() {
    System.out.println("▼ executeSummingIntメソッド");
    Map<ItemType, Integer> groupMap = ITEM_LIST.stream().collect(Collectors.groupingBy(
        item -> item.getItemType(), // グループの基準となる値(ItemType)
        Collectors.summingInt(item -> item.getPrice()) // グループ内の指定した要素の合計値
    ));
    System.out.println(groupMap);
  }
}
