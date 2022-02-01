package chapter_10;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Optional;

/**
 * 入出力<br>
 * Serializableインターフェース<br>
 *
 */
@SuppressWarnings("serial") // 課題と関係がないので、警告無視
public class SampleSerializable {
  public static void main(String[] a) {
    serializeExecution("sample.ser");
  }

  /**
   * ObjectOutputStreamインスタンス生成<br>
   * @param name
   */
  private static void serializeExecution(String name) {
    ObjectOutputStream out = null;
    try {
      out = new ObjectOutputStream(new FileOutputStream(name));
    } catch (IOException e) {
      e.printStackTrace();
    }
    serializeProcess(Optional.ofNullable(out));
  }

  /**
   * Itemクラスをシリアライズ化する処理<br>
   * @param outOptional
   */
  private static void serializeProcess(Optional<ObjectOutputStream> outOptional) {
    outOptional.ifPresentOrElse(out -> {
      try (out) {
        out.writeObject(new Item("apple", 100));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }, () -> System.out.println("処理されませんでした。"));
  }

}
