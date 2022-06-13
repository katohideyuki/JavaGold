package sec07_AnonymousClass;

/** 匿名クラスの使用例 */
public class ThreadSample {
    /** {}内が実装部分だけを定義した匿名クラス */
    Runnable run = new Runnable() {
        @Override
        public void run() {
            System.out.println("Hello");
        }
    };
}

/**
 * <pre>
 * 匿名クラス
 *   - インタフェースを実現したクラス、抽象クラスか具象クラスを継承したサブクラスとして、
 *     名前のないクラスを宣言し、そのクラスがどのようなフィールドやメソッドを持つべきかという
 *     クラスの実装内容だけを定義したもの
 * </pre>
 */
