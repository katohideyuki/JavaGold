package sec02_Generics;

import java.util.ArrayList;
import java.util.List;

import debug.Debug;

/** ジェネリクスの使用例 */
public class UseGenerics {
    public static void main(String[] args) {
        listWithMixedClass();
    }

    /* 型が混在したコレクション
         - 要素を取り出したときに、どの型でダウンキャストすればよいか困る */
    private static void listWithMixedClass() {
        Debug.log("listWithMixedClass");
        List list = new ArrayList<>();  // ジェネリクス<>を指定していないから、Object 型となる
        list.add(10);                   // int 型
        list.add("Java");               // String 型
        list.add(new Object());         // Object 型

        // String 型でダウンキャストするが、ClassCastException が発生
        for (int i = 0; i < list.size(); i++) {
            String str = (String) list.get(i);
            System.out.println(str);
        }
    }
}

/**
 * <pre>
 * コレクション
 *   - インスタンスの集合を扱うためのクラスの総称
 * </pre>
 */