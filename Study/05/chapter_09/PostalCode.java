package chapter_09;

import java.util.function.Consumer;

/**
 * 郵便番号に関する1件分のデータを保持するクラス<br>
 */
public class PostalCode {
  private String code; // 郵便番号
  private String prefecture; // 都道府県名
  private String district; // 市区町村名
  private String town; // 町域名

  /**
   * コンストラクタ<br>
   */
  private PostalCode(postalCodeBuilder builder) {
    this.code = builder.code;
    this.prefecture = builder.prefecture;
    this.district = builder.district;
    this.town = builder.town;
  }

  public String toString() {
    return code + prefecture + district + town;
  }

  /**
   * PostalCode用のBuilderクラス<br>
   */
  public static class postalCodeBuilder {
    private String code; // 郵便番号
    public String prefecture; // 都道府県名
    public String district; // 市区町村名
    public String town; // 町域名

    /**
     * postalCodeBuilderのコンストラクタ<br>
     */
    public postalCodeBuilder(String code) {
      this.code = code;
    }

    /**
     * 呼び出し元で、Consumer型のラムダ式でpostalCodeBuilderフィールド値を初期化する<br>
     *
     * @param consumer
     * @return
     */
    public postalCodeBuilder with(Consumer<postalCodeBuilder> consumer) {
      consumer.accept(this); // 自分自身の参照を引数にする
      return this;
    }

    /**
     * psotalCodeBuilderインスタンスを引数にPostalCodeインスタンスを生成<br>
     *
     * @return
     */
    public PostalCode create() {
      return new PostalCode(this);
    }
  }
}
