package chapter_10;

/**
 * アサーションの使用例<br>
 * - assert 条件式 : メッセージ ; <br>
 * --- 条件式でtrueを返せば、何事もなく処理を継続<br>
 * --- falseを返せば、メッセージを持ったAssertionErrorをスローする<br>
 */
public class SampleItem {
  private String name;
  private int price;

  public SampleItem(String name, int price) {
    this.name = name;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    assert name != null : "name is null"; // 引数がnullであれば、処理しない
    this.name = name;
    System.out.printf("セット完了 : %s %n", name);
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    assert price > 0 : "invalid price : " + price; // 引数が0以下であれば、処理しない
    this.price = price;
    System.out.printf("セット完了 : %d %n", price);
  }

}
