package sec15_nioFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Predicate;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/**
 * 入出力<br>
 * copy/moveメソッド<br>
 * - 毎回try文があるのが煩わしい<br>
 */
public class SampleCopyMove {
  private static Predicate<Path> existsPath = x -> Files.exists(x); // 存在有無チェック
  private static Path sample = Paths.get("dir", "sample.txt");

  public static void main(String[] args) {
    copyExecution();
    moveExecution();
  }

  /**
   * ファイルコピー<br>
   */
  private static void copyExecution() {
    var copyLocation = Paths.get("dir", "sample_bk.txt"); // コピー先情報
    Boolean existsSample = existsPath.test(sample); // sampleの存在有無
    Boolean existsCopyLocation = existsPath.test(copyLocation); // copyLocationの存在有無

    // ファイルが無ければ作成
    if (!existsSample) {
      try {
        Files.createFile(sample);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    // コピー先のファイルが無ければコピー
    if (!existsCopyLocation) {
      try {
        Files.copy(sample/* コピー元 */, copyLocation/* コピー先 */);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * ファイル移動<br>
   * - REPLACE_EXISTING<br>
   * --- 移動先ファイルがすでに存在する場合、上書き保存<br>
   */
  private static void moveExecution() {
    var subdirPath = Paths.get("dir", "subdir"); // subdirのパス
    var moveLocation = subdirPath.resolve(Paths.get("sample.txt")); // 移動先情報
    Boolean existsSample = existsPath.test(sample); // // sampleの存在有無
    Boolean existsSubdir = existsPath.test(subdirPath); // subdirの存在有無

    // コピー元のファイルがあれば、subdir直下に移動
    if (existsSample && existsSubdir) {
      try {
        Files.move(sample, moveLocation, REPLACE_EXISTING/* オプション */);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

}
