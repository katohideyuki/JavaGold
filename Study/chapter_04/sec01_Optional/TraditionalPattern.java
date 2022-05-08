package sec01_Optional;

/** Optional クラスの使用例
      - Optionalを使わない従来のパターン */
public class TraditionalPattern {

    /* 配列に格納されている要素を取得し、出力する
         -  要素外にアクセスした場合、例外をスローして処理終了 */
    public static void getValue(int index) {
        String[] array = { "A", "B", null };
        try {
            String result = getFromArray(array, index);
            if (result == null) {
                System.out.println("result is empty.");
                return;
            }
            System.out.printf("result : %s%n ", result);
        } catch (IllegalAccessException | ArrayIndexOutOfBoundsException e) {
            System.out.printf("TraditionalPattern.exe failure %n  => %s%n", e);
        }
    }

    /* 配列とインデックス番号を受け取り、配列からインデックスに一致する要素を返却 */
    private static <T> T getFromArray(T[] array, int index)
            throws IllegalAccessException, ArrayIndexOutOfBoundsException {
        // null であれば 例外をスロー
        if (array == null)
            throw new IllegalAccessException();
        // 要素を返却
        try {
            return array[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw e;
        }
    }
}
