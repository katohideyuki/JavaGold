package useRecode;

import debug.Debug;

/** record の使用例 */
public class UseBook {
    public static void main(String[] args) {
        creBook();
    }

    /* record をあれこれ使ってみる */
    private static void creBook() {
        Debug.log("creBook");
        Book book = new Book("java", 1000);
        System.out.println(book);
        System.out.printf("Book title : %s%n", book.title());
        System.out.printf("Book price : %s%n", book.price());
    }
}
