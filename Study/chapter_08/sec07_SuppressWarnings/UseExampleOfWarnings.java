package sec07_SuppressWarnings;

import debug.Debug;

/** SuppressWarnings アノテーションの使用例 */
public class UseExampleOfWarnings {
    public static void main(String[] args) {
        useNoGenerics();
        useNoGenericsSuppresWarn();
        useDeprecatedMethod();
        usePlanToDelete();
    }

    /* 呼び出し元では警告なし */
    private static void useNoGenerics() {
        Debug.log("useNoGenerics");
        ExampleOfWarning.noGenerics();
    }

    /* 呼び出し元でも警告なし */
    private static void useNoGenericsSuppresWarn() {
        Debug.log("useNoGenericsSuppresWarn");
        ExampleOfWarning.noGenerics();
    }

    /* 非推奨メソッドを使用するので、警告を抑制 */
    @SuppressWarnings("deprecation")
    private static void useDeprecatedMethod() {
        Debug.log("useDeprecatedMethod");
        ExampleOfWarning.deprecatedMethod();
    }

    /* 使用することを強く抑制した非推奨メソッドを使用するので、警告を抑制 */
    @SuppressWarnings("removal")
    private static void usePlanToDelete() {
        Debug.log("usePlanToDelete");
        ExampleOfWarning.planToDelete();
    }
}
