package sec21_StreamLambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import debug.Debug;

/** ストリームとラムダ式の扱い方 */
public class SideEffects {
    static final List<String> LIST = Arrays.asList("A", "B", "C", "D", "E");

    public static void main(String[] args) {
        badExampleConcatenation();
        reuseMethod();
    }

    /* ストリームの文字列を連結する繰り返し処理 - 悪い例 ※1 */
    private static void badExampleConcatenation() {
        Debug.log("badExampleConcatenation");

        // builder が空じゃなければ「,」を追加し、その後ろに文字列を追加する
        StringBuilder builder = new StringBuilder();
        LIST.stream().forEach(str -> {
            if (builder.length() != 0)
                builder.append(", ");  // 副作用 : 外部のオブジェクト builder の中身を変更している
            builder.append(str);       // 副作用 : 外部のオブジェクト builder の中身を変更している
        });
        System.out.println(builder);
    }

    /* ストリームの文字列を連結する繰り返し処理
         - 副作用は未だ発生しているが、再利用性は解決 ※2 */
    private static void reuseMethod() {
        Debug.log("reuseMethod");
        StringBuilder builder = new StringBuilder();
        // 処理内容を変数として、定義することで再利用が可能となる
        Consumer<String> concatenation = str -> {
            if (builder.length() != 0)
                builder.append(", "); // 副作用 : 外部のオブジェクト builder の中身を変更している
            builder.append(str);      // 副作用 : 外部のオブジェクト builder の中身を変更している
        };
        LIST.stream().forEach(concatenation);
        System.out.println(builder);
    }
}

/**
 * <pre>
 * ※1
 * 非推奨の処理内容
 *   - ラムダ式内部から、外部のオブジェクトを操作している
 *     - builder
 *   - 同じように、文字列を連結する処理の再利用ができない
 *
 * ※2
 * 副作用は未だ発生しているが、再利用性は解決
 *   - ストリームを作る前に、処理内容を記述したConsumer 型ラムダ式を用意することで解決
 * </pre>
 */