package sec06_UnboundedWildcard;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

import debug.Debug;

/** 非境界ワイルドカード */
public class UseWildcard {
    static final List<Integer> INT_LIST = List.of(1, 2, 3, 4, 5);
    static final List<String>  STR_LIST = List.of("A", "B", "C");
    // String 型だけを扱う Collection 型の引数を受け取るラムダ
    static final Consumer<Collection<String>> PRINT_ONLY_STR =
                        str -> str.stream().forEach(System.out::println);
   // Object 型だけを扱う Collection 型の引数を受け取るラムダ
    static final Consumer<Collection<Object>> PRINT_ONLY_OBJ =
                        obj -> obj.stream().forEach(System.out::println);
   // 非境界ワイルドカードを使った Collection 型の引数を受け取るラムダ
    static final Consumer<Collection<?>> PRINT_ANY =
                        any -> any.stream().forEach(System.out::println);

    public static void main(String[] args) {
        usePrintOnlyXXX();
    }

    /* サンプル(よい説明が思いつかない) */
    private static void usePrintOnlyXXX() {
        Debug.log("usePrintOnlyXXX");

        // String 型以外のコレクションは許容していないため、Integer 型はコンパイルエラー
        System.out.println("▼ example of using 'PRINT_ONLY_STR'");
//        PRINT_ONLY_STR.accept(INT_LIST);  // Integer 型 NG
        PRINT_ONLY_STR.accept(STR_LIST);    // String  型 OK

        // Object 型以外のコレクションは許容していないため、Integer, String 型はコンパイルエラー
        System.out.println("▼ example of using 'PRINT_ONLY_OBJ'");
//        PRINT_ONLY_OBJ.accept(INT_LIST);  // Integer 型 NG
//        PRINT_ONLY_OBJ.accept(STR_LIST);  // String  型 NG

        // ワイルドカード「?」を使っているので、どんな型のコレクションでも許容する
        System.out.println("▼ example of using 'PRINT_ANY'");
        PRINT_ANY.accept(INT_LIST);         // Integer 型 OK
        PRINT_ANY.accept(STR_LIST);         // String  型 OK
    }
}

/**
 * <pre>
 * 非境界ワイルドカード
 *   - 汎用的に使いたいカードでは、ジェネリクスの型パラメータは、実行時まで
 *     型が不明であることを示す、ワイルドカード「?」を使う
 * </pre>
 */
