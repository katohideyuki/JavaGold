package sec03_Reflection;

import debug.Debug;

/** リフレクション */
public class UseTestAndItem {
    public static void main(String[] args) {
        getDefinitionInfo();
    }

    /* Item クラスの定義情報をから、Test アノテーションの定義情報を取得 */
    private static void getDefinitionInfo() {
        Debug.log("getDefinitionInfo");
        Class<Item> clazz = Item.class;               // Item クラスの定義情報を取得
        Test test = clazz.getAnnotation(Test.class);  // Item クラスに付与された Test アノテーション情報を取得

        // Test アノテーションが取得できなければ、処理終了
        if (test == null)
            return;

        // Test アノテーションから値を取得し、Item　インスタンスを生成
        Item item = new Item(test.name(), test.price());
        System.out.printf("name  : %s%n", item.getName());
        System.out.printf("price : %s%n", item.getPrice());
    }
}

/**
 * <pre>
 * リフレクション
 *   - インスタンスの元なるクラスがどのような定義情報を持っているかを調べ、
 *     その定義情報に基づいてインスタンスを操作する技術
 *     - リフレクションを利用するためのパッケージ : lang.reflect
 *
 * lang.Class
 *   - クラスがどのように定義されているのかという情報を扱うクラス
 *
 * クラス名.class
 *   - クラスの定義情報を取得 ※ クラスリテラルと呼ぶ
 *
 * Class.getAnnotation(アノテーションクラス)
 *   - 定義情報から、そのクラスが持つアノテーションを取得
 * </pre>
 */
