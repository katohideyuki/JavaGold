package chapter_17;

/**
 * Comparableを実現したクラス<br>
 * - getter,setterは省略<br>
 */
public class Items implements Comparable<Items> {
  private String name;
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  private int price;

  public Items(String name, int price) {
    this.name = name;
    this.price = price;
  }

  /**
   * priceが低い方を前に戻す<br>
   */
  @Override
  public int compareTo(Items item) {
    if (this.price < item.price) {
      return -1;
    } else if (item.price < this.price) {
      return 1;
    }
    return 0;
  }

  @Override
  public String toString() {
    return String.format("Items [ name = %s , price = %d ]", name, price);
  }

}
