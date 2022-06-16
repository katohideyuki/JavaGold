package sec15_Enum;
/** Enum の使用例
      - 定数を定義したインタフェース */
public interface Fruits {
    public final static int APPLE  = 0;
    public final static int ORANGE = 1;
    public final static int BANANA = 2;
    public final static int MELON  = 0;
}

/**
 * <pre>
 * ※2 ソフトウェアの規模が大きくなるにつれ、定数の数が増え、定数値が重複してしまう恐れがある
 *    プログラムの制御は、定数名ではなく、定数値で行うため、以下のような不自然なプログラムが
 *    成り立ってしまう
 * </pre>
 */