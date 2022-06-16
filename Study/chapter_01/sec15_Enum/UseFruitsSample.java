package sec15_Enum;

import debug.Debug;

/** Enum の使用例 */
public class UseFruitsSample {
    public static void main(String[] args) {
        branchProcess();
    }

    /* Enum を使った条件分岐 */
    private static void branchProcess() {
        Debug.log("useFruitsSample");
        FruitsSample type = FruitsSample.APPLE;
        switch (type) {
        case APPLE:
            System.out.println("apple");
            break;
        case ORANGE:
            System.out.println("orange");
            break;
        case BANANA:
            System.out.println("banana");
            break;
        case MELON:
            System.out.println("melon");
            break;
        }

        // Enum を使えば、以下のような不自然な条件も成り立たない
        if (FruitsSample.APPLE == FruitsSample.MELON)
            System.out.println("joke?");    // 出力されない

        // FruitsSample の列挙子を取得する
        for (FruitsSample value : FruitsSample.values())
            System.out.printf("Array of : %s%n", value);

        // FruitsSample で任意の列挙子を取得する
        System.out.printf("Arbitrary value : %s%n", FruitsSample.valueOf("ORANGE"));
    }
}

/**
 * <pre>
 * Enum
 *   - クラスとして扱われる
 *   - 独自に定義した Enum はlang.Enum クラスのサブクラスとして扱われる
 *   - プログラム実行時には、Enum に定義した各列挙子が、それぞれ別のインスタンスで生成される
 *       - 前述の FruitsSample であれば、APPLE と ORANGE、BANANA、MELON の4つのインスタンス
 *         が、初めて FruitsSample を読み込んだタイミングで生成される
 *
 * プログラマーが定義した独自の Enum には、コンパイラによって以下のメソッドが追加される
 *   - Enum.values()
 *     - Enum に定義されている列挙子を配列に入れて返却する
 *
 *   - Enum.valueOf(列挙子名)
 *     - 列挙子の名前から、列挙子のインスタンスを返却する
 * </pre>
 */
