package sec06_TryWithResources;

import debug.Debug;

/** try-with-resources の使用例
      - リソースは実質的な final もしくは実質的に final でなくてはならない  */
public class UseSample {
    public static void main(String[] args) throws Exception {
        inFrontOfTry();
        badExample_1();
        badExample_2();
        badExample_3();
    }

    /* 実質的な final のリソース
         - try ブロック前でリソース宣言しているので、問題なし */
    private static void inFrontOfTry() throws Exception {
        Debug.log("inFrontOfTry");
        var resouce = new SampleAutoCloseable();
        try (resouce) {
            System.out.println("something was done");
        }
    }

    /* 実質的な final ではないリソース
         - try ブロック内で新しいインスタンスを生成しているため、コンパイルエラー */
    private static void badExample_1() throws Exception {
        Debug.log("badExample_1");
        var resource = new SampleAutoCloseable();
        try (resource) {
//            resource = new SampleAutoCloseable();
            System.out.println("something was done");
        }
    }

    /* 実質的な final ではないリソース
         - try ブロック後で宣言したリソースの変更をしているため、コンパイルエラー */
    private static void badExample_2() throws Exception {
        Debug.log("badExample_2");
        var resource = new SampleAutoCloseable();
        try (resource) {
            System.out.println("something was done");
        }
//        resource = new SampleAutoCloseable();
    }

    /* 実質的な final ではないリソース
         - try ブロック前で宣言したリソースの変更をしているため、コンパイルエラー */
    private static void badExample_3() {
        Debug.log("badExample_3");
//        SampleAutoCloseable resource = null;
//        try (resource) {
//            System.out.println("something was done");
//        }
    }
}

/**
 * <pre>
 * try-with-resources
 *   - 複数のリソースを対象とする場合は、セミコロン「;」で区切って列挙する
 *     - try (a; b; c;) { }
 *   - リソースは実質的な final もしくは実質的に final でなくてはならない
 * </pre>
 */