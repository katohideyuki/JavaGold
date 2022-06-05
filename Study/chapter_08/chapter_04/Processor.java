package chapter_04;



/**
 * NotNullアノテーションを使用するクラス<br>
 * nameフィールドに付与<br>
 */
public class Processor {
  @NotNull(message = "name is not allowed null") // 注釈パラメータ
  private String name;

  public Processor(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }
}
