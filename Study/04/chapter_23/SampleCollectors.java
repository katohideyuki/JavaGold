package chapter_23;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * ストリームAPI<br>
 * - Collectorsクラス/toList/toSet/toMapメソッド<br>
 *
 */
public class SampleCollectors {

  private static final List<Item> ITEM_LIST = Arrays.asList(
      new Item(1, ItemType.BOOK, "java", 1980),
      new Item(2, ItemType.BOOK, "Lambda", 2980),
      new Item(3, ItemType.MAGAZINE, "Software", 3980),
      new Item(4, ItemType.MAGAZINE, "Test", 4980),
      new Item(5, ItemType.BOOK, "GO", 5980));

  // filter用のラムダ式 再利用したいため（itemTypeがBOOKの要素のみになるよう絞り込む）
  private static final Predicate<Item> FILTERING = item -> item.getItemType() == ItemType.BOOK;

  public static void main(String[] args) {
    executeList();
    executeSet();
    executeMap();
  }

  /**
   * itemListストリームに対して、Collectors.toListメソッド実行<br>
   * - filterで絞り込んだ結果のみで構成された新しいリストを作る<br>
   */
  private static void executeList() {
    System.out.println("▼ executeListメソッド");

    List<Item> bookList = ITEM_LIST.stream().filter(FILTERING).collect(Collectors.toList());
    bookList.forEach(x -> System.out.println(x));
  }

  /**
   * itemListストリームに対して、Collectors.toSetメソッド実行<br>
   * - filterで絞り込んだ結果のみで構成された新しいセットを作る<br>
   */
  private static void executeSet() {
    System.out.println("▼ executeSetメソッド ※順番がListと違う");
    Set<Item> bookSet = ITEM_LIST.stream().filter(FILTERING).collect(Collectors.toSet());
    bookSet.forEach(x -> System.out.println(x));
  };

  /**
   * itemListストリームに対して、Collectors.toMapメソッド実行<br>
   * - ItemオブジェクトのitemNameをKeyとして、自分自身をValueとする<br>
   * --- keyの値を出力<br>
   */
  private static void executeMap() {
    System.out.println("▼ executeMapメソッド");
    Map<String, Item> bookMap = ITEM_LIST.stream().collect(Collectors.toMap(
        itemKey -> itemKey.getName(), // getNameの戻り値(名前）がキーになる
        itemValue -> itemValue) // 引数で受け取ったitemをそのまま戻すことで、それがvalueになる
    );
    bookMap.keySet().stream().forEach(x -> System.out.println("key : " + x));
  }

}
