package chapter_16;

/**
 * Comparableを実現したクラス<br>
 * - getter,setterは省略<br>
 */
public class Item implements Comparable<Item> {
  private String name;
  private int price;

  public Item(String name, int price) {
    this.name = name;
    this.price = price;
  }

  /**
   * priceが低い方を前に戻す<br>
   */
  @Override
  public int compareTo(Item item) {
    if (this.price < item.price) {
      return -1;
    } else if (item.price < this.price) {
      return 1;
    }
    return 0;
  }

  @Override
  public String toString() {
    return String.format("Item [ name = %s , price = %d ]", name, price);
  }

}
