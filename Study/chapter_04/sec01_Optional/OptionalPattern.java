package sec01_Optional;

import java.util.Optional;

/** Optional クラスの使用例
      - Optionalを使パターン */
public class OptionalPattern {

    /* 配列に格納されている要素を取得し、出力する
         -  要素外にアクセスした場合、空の Optional を取得し、処理を完了する */
    public static void getValue(int index) {
        String[] array = { "A", "B", null };
        Optional<String> result = getFromArray(array, index);
        // Optional の空チェック ※1
        if (result.isEmpty()) {
            System.out.println("result is empty");
            return;
        }
        // 値を取得
        System.out.printf("result : %s%n ", result.get());
    }

    /* 配列とインデックス番号を受け取り、配列からインデックスに一致する要素を Optional 型で返却 */
    private static <T> Optional<T> getFromArray(T[] array, int index) {
        // null であれば 空の Optional を返却
        if (array == null)
            return Optional.empty();
        // 空または要素を保持した Optional を返却する
        try {
            return Optional.ofNullable(array[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.printf("OptionalPattern.getFromArray failure %n  => %s%n", e);
            return Optional.empty();
        }
    }
}

/**
 * <pre>
 * Optional
 *   - メソッドの処理結果を扱うためのクラスで、処理結果の正常・異常に関わらず
 *     同じ型で扱うことができる
 *     - new によるインスタンス生成ができない
 *
 * Optional.empty()
 *   - 空の Optional のインスタンスを生成し、その参照を戻す
 *
 * Optional.ofNullable(T t)
 *   - 値があれば、その値を取得する
 *   - null であれば、空の Optional を取得する
 *
 * Optional.get()
 *   - 値があれば、その値を取得する
 *     - null であれば nullPointerExecption をスローする
 *       - ※1 事前に Optional の空チェックを行うこと
 * </pre>
 */