package sec25_StreamCollectors;

/** Collectors.summingInt の使用例 - 設問25 */
public class Book {
    private String title;
    private int price;

    /* コンストラクタ */
    public Book(String title, int price) {
        this.title = title;
        this.price = price;
    }
    // 各 getter
    public String getTitle() { return title; }
    public int getPrice()    { return price; }
}
