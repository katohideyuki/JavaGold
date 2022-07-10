package practiceExam_Q56;
/** Enum の使用例 */
public enum Type {
    A(1), B(2), C(3);

    int val;

    /* コンストラクタ */
    private Type(int val) {
        this.val = val;
    }
}
