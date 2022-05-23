package sec10_Serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import debug.Debug;
import threadRelated.Sleep;

/** Serializable の使用例 */
public class UseItem {
    // 出力先
    static final String FILE_PATH = "src/main/resource/chapter_05/sec10/sec10_sample.ser";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        outputInstance();
        Sleep.exe(1000);
        inputInstance();
    }

    /* インスタンスをファイルに出力 - Serializable */
    private static void outputInstance() throws IOException {
        Debug.log("outputInstance");
        FileOutputStream fos   = new FileOutputStream(FILE_PATH);
        ObjectOutputStream out = new ObjectOutputStream(fos);

        try (out) {
            Item item = new Item("apple", 100);
            out.writeObject(item);
            System.out.printf("Serialized Item instance : %s%n  => %s%n", item, FILE_PATH);
        }
    }

    /* ファイルからインスタンスを作り直す - Deserializable */
    private static void inputInstance() throws IOException, ClassNotFoundException {
        Debug.log("inputInstance");
        FileInputStream fis  = new FileInputStream(FILE_PATH);
        ObjectInputStream in = new ObjectInputStream(fis);

        try (in) {
            Object obj = in.readObject();
            Item item = (Item) obj;
            System.out.printf("Deserialized Item instance : %s%n  => %s%n", item, FILE_PATH);
        }
    }
}

/**
 * <pre>
 * Serializable
 *   - メモリ上にあるインスタンスをストリームとして出力する
 *   - インスタンスを出力するときには、そのインスタンスが参照している先も同時に出力する必要がある
 *   - 実装クラスがシリアライズしなければならないことをJVMに示すためのマーカーインターフェース
 *       - 抽象メソッドを1つも持たず、クラスに何らかの意味を追加するためのもの
 *   - Serializable インターフェースを実装していないクラスをシリアライズすると
 *     NotSerialicableException をスローする
 *
 * Deserializable
 *   - ファイルに書き出された情報をもとにインスタンスを作り直す
 *
 * ObjectInputStream
 *   - ファイルからオブジェクトを作成する
 *
 * ObjectOutputStream
 *   - インスタンスをシリアライズして書き出すクラス
 *
 * ObjectInputStream.readObject()
 *   - デシリアライズしたインスタンスへの参照を Object 型で返却
 *   - 必要に合わせてダウンキャストする
 *
 * ObjectOutputStream.writeObject(出力したいインスタンス)
 *   - インスタンスをシリアライズする
 * </pre>
 */