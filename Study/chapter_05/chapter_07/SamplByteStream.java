package chapter_07;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;

/**
 * 入出力<br>
 * BufferedInputStream/BufferedOutputStreamクラス<br>
 *
 */
public class SamplByteStream {
  public static void main(String[] args) {
    copyFile("me-moji.PNG");
  }

  /**
   * 受け取ったファイルをコピーする<br>
   *
   * @param name コピー元のファイル名
   */
  private static void copyFile(String name) {
    BufferedInputStream bis = null;
    BufferedOutputStream bos = null;
    try {
      bis = new BufferedInputStream(new FileInputStream(name));
      bos = new BufferedOutputStream(new FileOutputStream("bak_" + name));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    executeCopy(Optional.ofNullable(bis), Optional.ofNullable(bos));
  }


  /**
   * 受け取ったOptionalインスタンスから、ファイルのコピー処理を実行<br>
   * 無理やりOptionalを使ったら、かなり見づらくなってしまった<br>
   *
   * @param opBis 読み込み用のバイトストリーム
   * @param opBos 出力用のバイトストリーム
   */
  private static void executeCopy(Optional<BufferedInputStream> opBis, Optional<BufferedOutputStream> opBos) {
    opBis.ifPresentOrElse(bis -> {
      opBos.ifPresentOrElse(bos -> {
        byte[] data = null;
        try (bis; bos) {
          while ((data = bis.readNBytes(1024)).length != 0) {
            bos.write(data);
          }
          bos.flush();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }, () -> System.out.println("BufferedOutputStreamのインスタンス生成に失敗しました。")); // opBisが空のとき
    }, () -> System.out.println("BufferedInputStreamのインスタンス生成に失敗しました。")); // opBosが空のとき
  }
}
