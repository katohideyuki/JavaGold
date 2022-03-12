package chapter_08;

/**
 * 不変オブジェクト<br>
 * すべてのフィールドに初期値をセットすることを保証するため、ビルダーパターンを使用<br>
 * - Builderのコンストラクタを用意すれば簡単に解決する気がする<br>
 * - もしくはデフォルト値を用意すれば。。。<br>
 */
public class SampleImmutable {
  private final int num; // フィールドはfinalで宣言
  private final String str;

  public static class Builder { /* ②外部から直接インスタンス化させない（ビルダーパターン） */
    private int num;
    private String str;

    public Builder setInt(int num) {
      this.num = num;
      return this;
    }

    public Builder setStr(String str) {
      this.str = str;
      return this;
    }

    public SampleImmutable build() {
      if (this.str == null) {
        this.str = "none";
      }
      return new SampleImmutable(this);
    }
  }

  private SampleImmutable(Builder builder) {
    this.num = builder.num;
    this.str = builder.str;
  }

  public String getStr() { /* getterは、参照をそのまま戻さず、新しいインスタンスを生成してその参照を戻す */
    return new String(str);
  }

  public SampleImmutable setStr(String str) { /* setterは、元の値を変更せず、新しい値を持った新しいインスタンスを生成して戻す */
    System.out.println("SampleImmutable.setStr()が呼び出されました"); // debug用
    return new SampleImmutable.Builder().setInt(num).setStr(str).build();
  }

  @Override
  public String toString() { // debug用
    return String.format("num : %d%nstr : %s%n", num, str);
  }
}
