package sec06_SecurityManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.Policy;

import debug.Debug;

/** SecurityManager の使用例 */
public class Sample {
    public static void main(String[] argas) throws IOException {
        getAllowEverything();
        getAllowEverythingFailed();

    }

    /* すべてのファイル or ディレクトリのアクセス制限がないため、セキュリティ上問題
         - ルート配下のファイル or ディレクトリを出力 */
    private static void getAllowEverything() throws IOException {
        Debug.log("getAllowEverything");
        outDirAndFieOfRoot();
    }

    /* すべてのファイル or ディレクトリにアクセス制限をかける
         - ルート配下のファイル or ディレクトリを出力するも失敗し AccessControlException をスローする */
    private static void getAllowEverythingFailed() throws IOException {
        Debug.log("getAllowEverythingFailed");
        System.setSecurityManager(new SecurityManager());   // セキュリティ機構を有効にして、アクセス制限をかける
        outDirAndFieOfRoot();
    }

    /* debug - ルート配下のファイル or ディレクトリを出力 */
    static void outDirAndFieOfRoot() throws IOException {
        Files.list(Paths.get("/")).forEach(p -> {
            System.out.println(p.getFileName());
        });
    }
}

/**
 * <pre>
 * SecurityManager
 *   - セキュリティポリシーに則ったセキュリティ機構関連のクラス
 *   - Jave SE 17 から非推奨となっている
 *
 * System.setSecurityManager(SecurityManager のインスタンス)
 *   - セキュリティ機構を有効にする
 *   - セキュリティポリシーを設定しないと、有効にしただけでは、すべての場所にアクセス
 *     できなくなる
 *   - Jave SE 17 から非推奨となっている
 * </pre>
 */
