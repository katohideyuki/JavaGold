package sec16_Enum;

/** Enum の使用例 - 引数ありのコンストラクタを持つ */
public enum TestWithArguments {
    A("hoge"), B("hege"), C("fuga");

    private String value;
    /* コンストラクタ */
    private TestWithArguments(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
