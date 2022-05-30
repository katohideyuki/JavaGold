package sec04_Convariance;

import debug.Debug;

/** 共変性の使用例 */
public class UseConvariance {
    public static void main(String[] args) {
        dangerousHandling();
        improvementOfConvariance();
    }

    /* 共変性の危険性 - ArrayStoreException 発生 */
    private static void dangerousHandling() {
        Debug.log("dangerousHandling");
        try {
            String[] strArray = {"A", "B"};
            Object[] objArray = strArray;             // 代入できる
            objArray[0]       = Integer.valueOf(1);   // コンパイルできるが、例外発生
        } catch (ArrayStoreException e) {
            System.out.printf("dangerousHandling failure : %s%n", e);
        }
    }

    /* 共変性の改善 - ジェネリクスを使ったコードはサブクラスの代入を許さない */
    private static void improvementOfConvariance() {
        Debug.log("improvementOfConvariance");
//        List<Object> list = new ArrayList<String>();  // コンパイルエラー
        System.out.println("Code using generics can't be subclass assigned.");
    }
}

/**
 * <pre>
 * 共変性
 *   - サブクラス型の代入を許す
 *   - コンパイルはできるが、実行時に ArrayStoreException スローする危険性がある
 *     - 共変性の改善が施され、ジェネリクスを使ったコードは、サブクラスの代入を許さない
 * </pre>
 */