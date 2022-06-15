package sec13_DefaultMethod;

/** デフォルトメソッドの使用例
      - インタフェースのデフォルトメソッドと、抽象クラスが同じメソッドを定義した場合 */
public abstract class B {

    /* A インタフェースの test メソッドを継承していると見なされ、
       アクセス修飾子を public => protected に狭めていることになるためコンパイルエラー */
//    protected void test() {
//        System.out.println("B");
//    }

    /* A インタフェースの test メソッドを継承していると見なされるも、
       修飾子を public => public と、アクセス修飾子を狭めていないため、問題なし */
    public void test() {
        System.out.println("B");
    }
}
