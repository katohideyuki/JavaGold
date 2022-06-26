package practiceExam_Q08;

/** Q.08
      - クラスが定義するメソッドとインターフェースのデフォルトメソッドが重複した場合 */
public interface Test {

    /* インターフェースのデフォルトメソッド */
    public default void execute(String str) {
        System.out.println("A");
    }
}
