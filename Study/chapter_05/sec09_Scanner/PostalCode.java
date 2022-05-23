package sec09_Scanner;

/** Scanner　の使用例
      - 郵便番号に関する一件分のデータを保持するクラス */
public class PostalCode {
    private final String code;        // 郵便番号
    private final String prefecture;  // 都道府県名
    private final String district;    // 市区町村名
    private final String town;        // 町域名

    /* コンストラクタ */
    public PostalCode(String code, String prefecture, String district, String town) {
        this.code       = code;
        this.prefecture = prefecture;
        this.district   = district;
        this.town       = town;
    }

    @Override /* debug */
    public String toString() {
        return String.format("〒%s %s%s%s %n", code, prefecture, district, town);
    }
}
