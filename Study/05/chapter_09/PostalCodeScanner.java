package chapter_09;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * 入出力<br>
 * Scannerクラス/hasNext/next/useDelimiterメソッド<br>
 */
public class PostalCodeScanner {
  public static void main(String[] args) {
    textLoad("KAGAWA.csv");
    textLoad("NotFound.csv");
  }

  /**
   * csvファイル名を受け取り、いい感じに処理したデータを出力<br>
   * @param fileName
   */
  private static void textLoad(String fileName) {
    Scanner scanner = null;
    try {
      scanner = new Scanner(new FileInputStream(fileName));
    } catch (FileNotFoundException e) {
      System.out.println("ファイルが見つかりませんでした");
      e.printStackTrace();
    }
    // 処理されたデータをリストに追加
    List<PostalCode> list = executeLoad(Optional.ofNullable(scanner));
    list.forEach(x -> System.out.println(x));
  }

  /**
   * csvファイルから必要な情報を取得、フォーマットを整形してリストに追加<br>
   * - 今回使うcsvファイルは、一行あたり8カラムの構成でデータ管理されている<br>
   * - 1行分のデータを取得したタイミングで、PostalCodeインスタンスを生成しリストに追加<br>
   *
   * - ラムダ、Builder、Optionalを使ってみたら見づらくなった<br>
   *
   * @param scannerOp
   * @return
   */
  private static List<PostalCode> executeLoad(Optional<Scanner> scannerOp) {
    List<PostalCode> list = new ArrayList<>();

    // csvファイルがあった場合
    scannerOp.ifPresentOrElse(scanner -> {
      scanner.useDelimiter(","); // カンマを区切り文字とする
      try (scanner) {
        while (scanner.hasNext()) {
          scanner.next(); // skip 不要な情報
          scanner.next(); // skip 不要な情報
          String code = scanner.next().replaceAll("\"", " "); // 郵便番号
          scanner.next(); // skip 不要な情報
          scanner.next(); // skip 不要な情報
          scanner.next(); // skip 不要な情報
          String pref = scanner.next().replaceAll("\"", " "); // 都道府県名
          String dist = scanner.next().replaceAll("\"", " "); // 市区町村名
          String town = scanner.next().replaceAll("\"", " "); // 町域名

          // postalCodeBuilder経由でPostalCodeクラスのインスタンスをリストに追加
          list.add(new PostalCode.postalCodeBuilder(code).with(builder -> {
            builder.prefecture = pref;
            builder.district = dist;
            builder.town = town;
          }).create());
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }, /* csvファイルがなかった場合 */ () -> System.out.println("Optionalが空です"));
    return list;
  }

}
