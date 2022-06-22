package sec06_SecurityManager;

import java.io.FilePermission;
import java.io.IOException;
import java.security.Permissions;
import java.security.Policy;

import debug.Debug;

/** SecurityManager の使用例 */
public class UseSamplePolicy {
    public static void main(String[] args) throws IOException {
        setPermission();
    }

    /* ルートディレクトリに対するアクセス権の設定 */
    private static void setPermission() throws IOException {
        Debug.log("setPermission");
        Permissions permissions = new Permissions();
        permissions.add(new FilePermission("/", "read"));
        Policy.setPolicy(new SamplePolicy(permissions));
        System.setSecurityManager(new SecurityManager());
        Sample.outDirAndFieOfRoot();
    }
}

/**
 * <pre>
 * セキュリティポリシーの設定方法
 *   - アクセス許可の集合を扱う security.Permissions のインスタンスを作り
 *     ファイルへのアクセス件を指定する io.FilePermission を Permissions クラス
 *     の add メソッドで追加する
 * </pre>
 */
