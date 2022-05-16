package sec17_Stream;

/** Stream.sorted の使用例
      - 自然順序で並び替えができないクラスの例 */
public class Item {
    private String name;

    public Item(String name) {
        this.name = name;
    }

    public String getName()  { return name; }
    @Override /* debug */
    public String toString() { return name; }
}
