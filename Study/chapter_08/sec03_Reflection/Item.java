package sec03_Reflection;

/** リフレクション
      - Testアノテーションを扱う */
@Test(name = "apple", price = 100)
public class Item {

    private String name;
    private int price;

    /* コンストラクタ */
    public Item(String name, int price) {
        this.name  = name;
        this.price = price;
    }

    /* getter */
    public String getName() { return name; }
    public int getPrice()   { return price; }
}
