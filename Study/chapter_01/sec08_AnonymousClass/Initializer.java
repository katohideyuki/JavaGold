package sec08_AnonymousClass;

import java.util.ArrayList;
import java.util.List;

import debug.Debug;

/** 匿名クラスの使用例 - 匿名クラスの初期化 */
public class Initializer {
    public static void main(String[] args) {
        listSample();
    }

    /* 初期化ブロックの中で、コレクションに要素を追加し、出力する */
    private static void listSample() {
        Debug.log("listSample");

        /** ArrayList を継承した匿名クラスを、初期化子「{}」を使って初期化 */
        List<String> list = new ArrayList<>() {
            {
                super.add("A");
                super.add("B");
                super.add("C");
            }
        };
        list.stream().forEach(System.out::println);   // A, B, C
    }
}

/**
 * <pre>
 * 匿名クラスを初期化したい場合、コンストラクタの代わりに初期化子「{}」を使用する
 * </pre>
 */
