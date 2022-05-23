package sec11_CustomSerialize;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import debug.Debug;

/** CustomSrealize の使用例 */
public class Employee implements Serializable {
    private String name;        // 従業員名
    private String telephone;   // 電話番号

    /* コンストラクタ */
    public Employee(String name, String telephone) {
        this.name      = name;
        this.telephone = telephone;
    }

    /* シリアライズ時に自動的に呼び出される */
    private void writeObject(ObjectOutputStream out) throws IOException {
        System.out.println("write");
        out.writeObject(name);
        out.writeObject(telephone);
    }

    /* デシリアライズ時に自動的に呼び出される */
    private void readObject(ObjectInputStream in) throws ClassNotFoundException, IOException {
        System.out.println("read");
        this.name      = (String) in.readObject();
        this.telephone = (String) in.readObject();
    }

    // getter
    public String getName()      { return name; }
    public String getTelephone() { return telephone; }

    @Override /* debug */
    public String toString() {
        return String.format("Employee [ name = %s, telephone = %s ]", name, telephone);
    }
}

/**
 * <pre>
 * カスタムシリアライズ
 *   - 自由に書き出し・読み込みを制御できる
 *
 * [シリアライズの補足]
 *   - static なフィールドはシリアライズ対象にならない
 *   - データの読み込み順は、writeObject()で書き出した順
 * </pre>
 */