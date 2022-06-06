package sec04_Target;

/** Target アノテーションの使用例
      - フィールドに対して NotNull アノテーションを付与 */
public class UseNotNull {

    // 注釈パラメータとして、エラーメッセージを渡す
    @NotNull(message = "code is not allow null")
    private int code;
    @NotNull(message = "name is not allow null")
    private String name;
    @NotNull(message = "anotherName is not allow null")
    private String anotherName;

    /* コンストラクタ */
    public UseNotNull(int code, String name, String anotherName) {
        this.code        = code;
        this.name        = name;
        this.anotherName = anotherName;
    }

    /* getter */
    public int getCode()          { return this.code; }
    public String getName()       { return this.name; }
    public String getAnotheName() { return this.anotherName; }
}
