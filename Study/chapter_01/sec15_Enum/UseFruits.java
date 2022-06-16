package sec15_Enum;

import debug.Debug;

/** Enum の使用例 */
public class UseFruits {
    static final int NUMBER = 0;

    public static void main(String[] args) {
        badBranchProcess();
        branchProcess();
    }

    /* switch 文で分岐処理を行う - 数字の意味がコードを読んでも分からない ※1 */
    private static void badBranchProcess() {
        Debug.log("branchProcess");
        switch (NUMBER) {
        case 0:
            System.out.println("apple");
            break;
        case 1:
            System.out.println("orange");
            break;
        case 2:
            System.out.println("banana");
            break;
        }
    }

    /* switch 文で分岐処理を行う - Fruits インタフェースに定義した定数を使う */
    private static void branchProcess() {
        Debug.log("branchProcess");
        switch (NUMBER) {
        case Fruits.APPLE:
            System.out.println("apple");
            break;
        case Fruits.ORANGE:
            System.out.println("orange");
            break;
        case Fruits.BANANA:
            System.out.println("banana");
            break;
        }

        // ※2 不自然な条件が成り立ってしまう
        if (Fruits.APPLE == Fruits.MELON)
            System.out.println("joke?");    // joke?
    }
}

/**
 * <pre>
 * ※1 case に定義した数字の意味がコードを読んでも理解できない。
 *    10〜20年の長いソフトウェアのライフサイクルの中で、メンテナンスする人が代わっていき
 *    意味のわかりにくいコードはメンテナンス性を下げ、バグが生まれる可能性がある
 * </pre>
 */