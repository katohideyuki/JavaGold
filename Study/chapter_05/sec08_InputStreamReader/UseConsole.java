package sec08_InputStreamReader;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

import debug.Debug;

/** InputStreaReader の使用例 */
public class UseConsole {
    public static void main(String[] args) throws IOException {
        acceptInputUseIn();
        acceptInputUseConsole();
        acceptPasswordInput();
    }

    /* 一行のみの入力を受け付ける - System.in */
    private static void acceptInputUseIn() throws IOException {
        Debug.log("acceptInputUseIn");
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            String input = bf.readLine();
            System.out.println(input);
        }
    }

    /* 一行のみの入力を受け付ける - Console.readLine ※1  */
    private static void acceptInputUseConsole() {
        Debug.log("acceptInputUseConsole");
        try {
            Console console = System.console();
            String str = console.readLine();
            System.out.println(str);
        } catch (RuntimeException e) {
            System.out.printf("acceptInputUseConsole failure : %s%n", e);
        }
    }

    /* 一行のみのパスワード入力を受け付ける - Console.password ※1 */
    private static void acceptPasswordInput() {
        Debug.log("");
        try {
            Console console = System.console();
            char[] password = console.readPassword();
            System.out.println(String.valueOf(password));
        } catch (Exception e) {
            System.out.printf("acceptPasswordInput failure : %s%n", e);
        }
    }
}

/**
 * <pre>
 * System.in
 *   - コンソールからの入力を受け付ける
 *     - コンソールで入力されたものは、必ず表示される
 *
 * InputStreamReader
 *   - 文字入力ストリームを扱う Reader に変換
 *
 * Console
 *   - コンソールからの入力を簡略的に受け取る
 *
 * Console.readPassword()
 *   - 入力内容を表示せずに入力を受け付ける
 *   - Char 型の配列を返却
 *
 * ※1
 * エクリプス上からはnullが返却されるため実行できない
 * </pre>
 */