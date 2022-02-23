package chapter_04;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * オブジェクトのフィールド値がnullかどうかをチェックするプロセッサ<br>
 * - アノテーション情報があり、且つフィールド値がnullの場合、注釈パラメータを返却する<br>
 */
public class NotNullValidator {
  public static <T> List<String> validate(T target) {
    try {
      List<String> messageList = new ArrayList<>();
      Class clazz = target.getClass();
      Field[] fields = clazz.getDeclaredFields(); // フィールドの定義情報一覧を取得
      for (Field field : fields) {
        field.setAccessible(true); // フィールドのアクセス制限を解除(privateにアクセスするため)
        NotNull annotetion = field.getAnnotation(NotNull.class); // NotNullアノテーション情報を取得

        // アノテーション情報(annotetion)がnullなら、NotNullの対象外であり、nullを許容するということ
        if (annotetion == null) {
          continue;
        }
        // フィールド値(target)がnullじゃないなら問題なし(空は許容する）
        if (field.get(target) != null) {
          continue;
        }
        messageList.add(annotetion.message()); // message注釈パラメータをリストに追加
      }
      return messageList;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
