package chapter_07;

import debug.Debug;

/** try-with-resources の使用例 - リソースの閉じる順番 */
public class CloseOrder {
    public static void main(String[] args) throws Exception {
        resourcesCloseAtCBA();
        resourcesCloseAtABC();
    }

    /* C, B, A の順にリソースを閉じていく */
    private static void resourcesCloseAtCBA() throws Exception {
        Debug.log("resourcesCloseAtCBA");
        Close_A a = new Close_A();
        Close_B b = new Close_B();
        Close_C c = new Close_C();
        try (a; b; c) {
            System.out.println("something was done");
        }
    }

    /* C, B, A の順にリソースを閉じていく - インスタンス生成の順番は関係なし */
    private static void resourcesCloseAtABC() throws Exception {
        Debug.log("resourcesCloseAtABC");
        Close_C c = new Close_C();
        Close_B b = new Close_B();
        Close_A a = new Close_A();
        try (a; b; c) {
            System.out.println("something was done");
        }
    }
}

/**
 * <pre>
 * try-with-resources のクローズされていく順番
 *   - try ブロックの処理が終了すると、宣言したときと逆の順番で自動的に閉じていく
 *     - try (a, b, c) 内に記述したのと逆の順番で閉じていく
 *     　　　 <-------- 閉じていく順番
 * </pre>
 */
