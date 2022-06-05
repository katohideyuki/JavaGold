package sec17_Comparator;

import java.util.Comparator;

/** Comparator インタフェースの使用例
      - Comparator を実現するクラス */
public class ItemNameComparator implements Comparator<Item> {

    @Override /* 名前順に比較する */
    public int compare(Item a, Item b) {
        System.out.println("ItemNameComparator.compare was executed");
        return a.getName().compareTo(b.getName());
    }
}

/**
 * <pre>
 * Comparator インタフェース
 *   - 並べ替えの方法だけを定義する
 *
 * Comparator.compare(比較対象1, 比較対象2)
 *   - 2つの比較対象の引数を受け取って、それぞれを比較する
 *   - 比較した結果
 *     - 1つ目の引数が前なら正の整数
 *     - 1つ目の引数が後ろなら負の整数
 *     - 同じなら0を返却
 * </pre>
 */
