package sec04_Target;

import java.util.List;

import debug.Debug;

/** Target アノテーションの使用例
      - NotNullValidator を使った入力チェックのプログラム */
public class UseNotNullvalidator {
    public static void main(String[] args) {
        useValidate();
    }

    /* NotNullValidator.validate メソッドを実行し、結果を出力 */
    private static void useValidate() {
        Debug.log("useValidate");
        UseNotNull notNull = new UseNotNull(0, null, null);
        List<String> messageLlist = NotNullValidator.validate(notNull);

        // 空のリストであれば、フィールド値は問題なし
        if (messageLlist.isEmpty()) {
            System.out.println("Validate : OK!");
            return;
        }

        // エラーメッセージを出力
        for (String message : messageLlist)
            System.out.println(message);
    }
}
