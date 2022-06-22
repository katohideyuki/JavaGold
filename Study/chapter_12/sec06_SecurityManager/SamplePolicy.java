package sec06_SecurityManager;

import java.security.Permission;
import java.security.PermissionCollection;
import java.security.Policy;
import java.security.ProtectionDomain;

/** SecurityManager の使用例
      - 権限のコレクションを持ったクラスをフィールドとして持つ */
public class SamplePolicy extends Policy {
    private final PermissionCollection permissions;

    /* コンストラクタ */
    public SamplePolicy(PermissionCollection permissions) {
        this.permissions = permissions;
    }

    /* 指定されたアクセス権が、PermissionCollectionで保持されるPermissionオブジェクト
       のコレクションによって包含されるかどうかを判定 */
    public boolean implies(ProtectionDomain domain, Permission permission) {
        return permission.implies(permission);
    }
}

/**
 * <pre>
 * security.Policy
 *   - セキュリティポリシーに関するクラス
 *   - セキュリティポリシーを設定するには、Policy クラスを継承したサブクラスを作り
 *     SamplePolicy クラスのように権限のコレクションを持った
 *     security.PermissionCollection クラスをフィールドとして用意する
 * </pre>
 */
