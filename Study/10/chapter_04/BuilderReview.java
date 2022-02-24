package chapter_04;

/**
 * Builderパターンのおさらい<br>
 */
public class BuilderReview {
  private String name;

  /**
   * インナークラス<br>
   */
  public static class Builder {
    private String name;

    // コンストラクタ
    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public BuilderReview build() {
      if (this.name == null) {
        throw new IllegalStateException();
      }
      var br = new BuilderReview();
      br.name = this.name; // 新しくインスタンスを生成したフィールドに、代入
      return br; // BuilderReviewのインスタンスを返す
    }
  }

  public String getName() {
    return name;
  }
}
