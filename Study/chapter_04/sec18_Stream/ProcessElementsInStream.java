package sec18_Stream;

import java.util.Arrays;
import java.util.List;

import debug.Debug;

/** Stream.map の使用例
      - ストリーム内の要素を処理 */
public class ProcessElementsInStream {
    static final List<String> LIST = Arrays.asList("red", "blue", "green", "yellow");

    public static void main(String[] args) {
        convertToUpperCase();
        strLnegth();
    }

    /* 文字列を大文字に変換 - Stream.map 引数と戻り値の型が同じ */
    private static void convertToUpperCase() {
        Debug.log("useMap");
        LIST.stream().map(String::toUpperCase)
                     .forEach(System.out::println);
    }

    /* 文字数を出力 - Stream.map 引数と戻り値の型が違う */
    private static void strLnegth() {
        Debug.log("returnAnotherType");
        LIST.stream().map(String::length)
                     .forEach(System.out::println);
    }
}

/**
 * <pre>
 * Stream.map(Function 型ラムダ式)
 *   - Function 型のラムダ式を受け取り、ストリーム内の要素を処理する
 * </pre>
 */