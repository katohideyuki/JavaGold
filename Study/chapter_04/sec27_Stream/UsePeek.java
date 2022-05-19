package sec27_Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import debug.Debug;

/** Stream.peek の使用例 */
public class UsePeek {
    public static void main(String[] args) {
        streamDebug();
        convertToUppercase();
    }

    /* ストリームの途中経過を debug して確認する */
    private static void streamDebug() {
        Debug.log("streamDebug");
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.stream().map(num -> num * 3)
                     .peek(num -> System.out.printf("debug : %s%n", num))
                     .filter(num -> num % 2 == 0)
                     .forEach(num -> System.out.printf("value : %s%n", num));
    }

    /* ストリームの途中経過を debug して確認する - 設問27 */
    private static void convertToUppercase() {
        Debug.log("convertToUppercase");
        List<String> list = Arrays.asList("banana", "apple", "orange");
        Stream<String> stream = list.stream();
        stream.filter(str -> str.length() > 5)
              .peek(str -> System.out.printf(str + " "))
              .map(str -> str.toUpperCase())
              .peek(str -> System.out.printf(str + " "))
              .forEach(System.out::print);
    }
}

/**
 * <pre>
 * Stream.peek(Consumer 型ラムダ式)
 *   - 主にデバッグなどの目的で、ストリームの途中でどのような状態になっているか
 *     確認したいときに使用
 *       - peek メソッド、forEach メソッドの結果が混在しているのは、
 *         ストリームに要素が1つずつ渡されているため
 * </pre>
 */