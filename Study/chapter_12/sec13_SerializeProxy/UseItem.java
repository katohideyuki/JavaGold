package sec13_SerializeProxy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import debug.Debug;

/** シリアライズ・プロキシの使用例 */
public class UseItem {
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
        useItem();
        useGoodItem();
    }

    /* Item　クラスの使用例
         - デシリアライズ時はエンクロージングクラスの不正値チェックを経由しないので、
           不正な値のまま Item インスタンスが生成されてしまう */
    private static void useItem() throws FileNotFoundException, IOException, ClassNotFoundException {
        Debug.log("useItem");
        String fileName = "SerializeProxyItem.ear";                     // シリアライズのファイル名
        Item item = new Item("apple", 100);                             
        item.nameNull();                                                // 不正な値をセット
        serializeExeHelper(fileName, item);                             // シリアライズ
        Item deserilizeItem = deSerializeExeHelper(fileName);           // デシリアライズ
        System.out.println(deserilizeItem);
    }

    /* GoodItem クラスの使用例
         - デシリアライズ時もエンクロージングクラスの不正値チェックを経由し、
           IllegalArgumentException がスローされる */
    private static void useGoodItem() throws FileNotFoundException, IOException, ClassNotFoundException {
        Debug.log("useGoodItem");
        String fileName = "SerializeProxyGoodItem.ear";                 // シリアライズのファイル名
        GoodItem item = new GoodItem("apple", 100);
        item.nameNull();                                                // 不正な値をセット
        serializeExeHelper(fileName, item);                             // シリアライズ
        GoodItem deserilizeGoodItem = deSerializeExeHelper(fileName);   // デシリアライズ
        System.out.println(deserilizeGoodItem);
    }

    /* ファイル名とシリアライズしたいインスタンスを受け取り、シリアライズを実行する */
    private static <T> void serializeExeHelper(String fileName, T t) throws FileNotFoundException, IOException {
        System.out.println("executed Serilize");
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(t);
        }
    }

    /* ファイル名を受け取り、デシリアライズしたオブジェクトを返却 */
    private static <T>T deSerializeExeHelper(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
        System.out.println("executed Deserialize");
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
        return (T) in.readObject();
        }
    }
}
