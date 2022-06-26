package sec13_SerializeProxy;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/** シリアライズ・プロキシの使用例
      - static インナークラスを追加したクラス */
public class GoodItem implements Serializable {
    private String name;
    private int price;

    /* コンストラクタ */
    public GoodItem(String name, int price) {

        // 引数が不正であれば、例外をスロー
        if (name == null || price < 0)
            throw new IllegalArgumentException();

        this.name  = name;
        this.price = price;
    }

    // getter
    public String getName() { return name; }
    public int getPrice()   { return price; }

    @Override /* debug */
    public String toString() {
        return String.format("Item [ name = %s, price = %s ] %n", name, price);
    }

    /* debug - name フィールドをnullを代入し、不正な値をセットする */
    public void nameNull() {
        this.name = null;
    }

    /* シリアライズされる時に自動的に呼び出される */
    private Object writeReplace() {
        System.out.println("writeReplace");
        return new ItemSerializationProxy(name, price);
    }

    /* デシリアライズされる時に自動的に呼び出される */
    private void readObject(ObjectInputStream in) throws InvalidObjectException {
        System.out.println("readObject");
        throw new InvalidObjectException("proxy required");
    }

    /** GoodItem クラスと同じフィールドを持った、ネストした static なクラス */
    private static class ItemSerializationProxy implements Serializable {
        private final String name;
        private final int price;

        /* ItemSerializationProxy コンストラクタ */
        ItemSerializationProxy(String name, int price) {
            this.name = name;
            this.price = price;
        }

        /* デシリアライズされる時に自動的に呼び出される */
        private Object readResolve() {
            System.out.println("readResolve");
            return new GoodItem(name, price);
        }
    }
}

/**
 * <pre>
 * writeReplace()
 *   - シリアライズの時に自動的に呼び出され、同じフィールドの値を持ったネストした
 *     static なクラスのインスタンスを生成して返却
 *
 * readResolve()
 *   - デシリアライズの時に自動的に呼び出され、復元されたネストした static なクラス
 *     のインスタンスと同じフィールドの値を持ったエンクロージングのインスタンスを返却
 *
 * readObject(ObjectInputStream 型)
 *   - デシリアライズの時に自動的に呼び出され、万が一エンクロージングクラスのインスタ
 *     ンスがシリアライズされ、デシリアライズされることを想定し、不正なデシリアライズ
 *     を防ぐ
 *
 * </pre>
 */
