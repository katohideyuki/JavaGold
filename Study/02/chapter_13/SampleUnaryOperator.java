package chapter_13;

import java.util.ArrayList;
import java.util.List;

/**
 * UnaryOperatorの使用例<br>
 * - ListインターフェースのreplaceAllメソッド<br>
 *
 */
public class SampleUnaryOperator {
  public static void main(String[] args) {
    excuteUnaryOperator();
  }

  /**
   * replaceALL<br>
   * - rereplaceAll(UnaryOperator<E> operator)<br>
   * - このリストの各要素を、その要素に演算子を適用した結果で置換します<br>
   * --- StringクラスのreplaceAllと違うので注意する<br>
   * <br>
   * toUpperCase()<br>
   * - デフォルト・ロケールのルールを使って、このString内のすべての文字を大文字に変換<br>
   */
  private static void excuteUnaryOperator() {
    List<String> list = new ArrayList<>();
    list.add("a");
    list.add("b");
    list.add("c");

    // replaceAllメソッドではUnaryOperatorインターフェースの実装を引数にしており、
    // 実装メソッド内の引数としてList内の要素を一つずつ受け取り、戻り値で上書き
    list.replaceAll(x -> x.toUpperCase());

    for (String str : list) {
      System.out.println(str);
    }
  }

}
