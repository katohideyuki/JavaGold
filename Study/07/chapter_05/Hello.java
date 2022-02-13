package chapter_05;

/**
 * Aクラスまたはそのサブクラス（すなわちBクラス）のみHelloクラスを生成できる<br>
 */
public class Hello<T extends A> {

  /**
   * 指定した型のhelloメソッドを呼び出す<br>
   * @param t
   */
  public void execute(T t) {
    t.hello();
  }
}
