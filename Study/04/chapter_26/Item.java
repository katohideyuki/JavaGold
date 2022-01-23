package chapter_26;

/**
 * ID、アイテムタイプ、名前、値段を持ったクラス<br>
 *
 */
public class Item {
  private int id;
  private ItemType itemType;
  private String name;
  private int price;

  /**
   * コンストラクタ<br>
   * - フィールドを初期化<br>
   *
   * @param id
   * @param itemType
   * @param name
   * @param price
   */
  public Item(int id, ItemType itemType, String name, int price) {
    super();
    this.id = id;
    this.itemType = itemType;
    this.name = name;
    this.price = price;
  }

  // getter
  public int getId() {
    return id;
  }

  public ItemType getItemType() {
    return itemType;
  }

  public String getName() {
    return name;
  }

  public int getPrice() {
    return price;
  }

  /**
   * 結果出力用<br>
   */
  @Override
  public String toString() {
    return "Item[id=" + id + ", itemType=" + itemType + ", name=" + name + ", price=" + price + "]";
  }
}
