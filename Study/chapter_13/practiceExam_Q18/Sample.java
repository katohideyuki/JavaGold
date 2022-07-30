package practiceExam_Q18;

import java.io.Console;

import debug.Debug;

/**
 * コンソールでの動作検証
 */
public class Sample {
    public static void main(String args[]) {
     // eclipse 上で実行すると System.console() の返却値が null になり、NullPointerException が発生する
     // exe();
    }

    /**
     * コンソールからの入力値を表示する
     */
    private static void exe1() {
        Debug.log("exe1");
        Console console = System.console();               // コンソールインスタンスを生成
        var name = console.readLine("name > ");           // テキスト行を読み込む
        var pass = console.readPassword("password > ");   // 入力値はコンソールに表示せずに読み込む
        System.out.printf("name : %s, pass : %s", name, String.valueOf(pass));
    }
}
