package chapter_06;

import java.security.Permission;
import java.security.PermissionCollection;
import java.security.Policy;
import java.security.ProtectionDomain;

/**
 * セキュリティポリシーの設定<br>
 * - 権限のコレクションを持ったクラスをフィールドとして持つ<br>
 */
public class SamplePolicy extends Policy {
  private final PermissionCollection permissions;

  public SamplePolicy(PermissionCollection permissions) {
    this.permissions = permissions;
  }

  /*
   * 指定されたアクセス権が、PermissionCollectionで保持されるPermissionオブジェクトのコレクションによって包含されるかどうかを判定
   */
  @Override
  public boolean implies(ProtectionDomain domain, Permission permission) {
    return permissions.implies(permission);
  }
}
