package practiceExam_Q16;

/** Stream.reduce の使用例 */
public class Sample {
    private String name;
    private int num;

    /* コンストラクタ */
    public Sample(String name, int num) {
        this.name = name;
        this.num  = num;
    }

    /* getter */
    public String getName() { return name; }
    public int getNum()     { return num; }

}

/**
 * <pre>
 * Stream.mapToInt()
 *   - int 型のストリームに変換
 *
 * Stream.reduce()
 *   - 結合的な累積関数を使って、値を積算する
 * </pre>
 */
