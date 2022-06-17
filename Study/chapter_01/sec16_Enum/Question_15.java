package sec16_Enum;

/** Enum の使用例 - 設問15 */
public enum Question_15 {
    A("hello"), B("hello"), C("hello");
    private final String value;

    /* コンストラクタ */
    private Question_15(String value) {
        System.out.println(value);
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
