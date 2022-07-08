package practiceExam_Q50;

import java.util.stream.IntStream;

import debug.Debug;

/** IntStream.iterate の使用例 */
public class Sample {
    public static void main(String[] args) {
        accumulation();
    }

    private static void accumulation() {
        Debug.log("accumulation");

        // 0を初期値として、+1ずつ累積し、5回まで繰り返す
        IntStream.iterate(0, n -> n + 1)
                 .limit(5)
                 .mapToObj(n -> n + ", ")
                 .forEach(System.out::print);    // 0, 1, 2, 3, 4
    }
}

/**
 * <pre>
 * IntStream.iterate()
 *   - 第1引数に初期値、第2引数に初期値に対して何らかの演算を行う UnaryOperator 型のラムダ式を渡す
 *       - ラムダ式の処理を実行しながら、初期値から始まる無限に続くストリームを構築する
 *       - まず、初期値がを返却するところから、始まる
 * </pre>
 */
