package chapter_09;

import java.util.Date;

/**
 * セキュアコーディング<br>
 * 可変オブジェクト<br>
 */
public class Main {
  public static void main(String[] a) {
    exe();
  }

  private static void exe() {
    var a = new CopyObject(new Date());
    var b = new CopyObject(a);

    System.out.printf("a == b : %b%n", a == b); // false
    System.out.printf("a == a : %b <---------- if(this == obj)に該当%n", a.equals(a)); // true
    System.out.printf("aとbのdateフィールド値は同じ : %b%n", a.equals(b)); // true
  }
}
