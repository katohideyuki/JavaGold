package practiceExam_Q08;

import debug.Debug;

/** Q.08
      - クラスが定義するメソッドとインターフェースのデフォルトメソッドが重複した場合 */
public class UseTestAndAbstractTest extends AbstractTest implements Test {
    public static void main(String[] args) {
        exe();
    }

    /* execute メソッド実行するも IllegalAccessError がスローされる */
    private static void exe() {
        Debug.log("exe");
        new UseTestAndAbstractTest().execute("hello");
    }
}

/**
 * クラスが定義するメソッドとインターフェースのデフォルトメソッドが重複した場合、
 * 実行時にクラスに定義されたメソッドが優先される
 *   - インターフェースのデフォルトメソッドは、あくまでも実装がなかったときの標準的な処理
 *     を記述するためのもの
 *
 * IllegalAccessError がスローされる原因は、コンパイラはインターフェースに定義されている
 * public な execute メソッドを実行するものと解釈し、コンパイラは成功する。
 * しかし、実行時には前述のルールが適用されるため、AbstractTest クラスのメソッドを呼び出そうとし、
 * private なメソッドなのでアクセスできず、例外発生
 */