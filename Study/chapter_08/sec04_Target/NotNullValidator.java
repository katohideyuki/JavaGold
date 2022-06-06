package sec04_Target;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/** Target アノテーションの使用例
      - オブジェクトのフィールド値が null かどうかチェックする
      - NotNull アノテーションが付与されており、フィールド値が null であればエラーメッセージを返却する */
public class NotNullValidator {
    public static List<String> validate(Object target) {
        try {
            List<String> messageList = new ArrayList<>();   // エラーメッセージのリスト
            Class<?> clazz = target.getClass();             // クラスの定義情報を取得
            Field[] fields = clazz.getDeclaredFields();     // フィールドの定義情報の一覧を取得

            // フィールドのアクセス制限を解除し、アノテーションおよび null チェックを行う
            for (Field field : fields) {

                // フィールドのアクセス情報を変更し、NotNull アノテーション情報を取得する
                field.setAccessible(true);
                NotNull annotation = field.getAnnotation(NotNull.class);

                // NotNull アノテーション情報が付与されていなければ、対象外
                if (annotation == null)
                    continue;

                // フィールドに値が入っていれば、対象外
                if (field.get(target) != null)
                    continue;

                // アノテーションが付与されており、フィールド値が null である
                messageList.add(annotation.message());
            }
            return messageList;
        } catch (IllegalArgumentException | IllegalAccessException e) {
            System.out.println("failed to get field value");
            throw new RuntimeException(e);
        }
    }
}

/**
 * <pre>
 * getDeclaredFields()
 *   - フィールドの定義情報の一覧を取得する
 *
 * Field.setAccessible(boolean flag)
 *   - フィールドのアクセス情報を変更 (private にアクセスするため)
 * </pre>
 */
