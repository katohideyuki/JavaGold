package sec09_mutable;

import java.util.Date;

import debug.Debug;

/** 可変オブジェクトの使用例 */
public class Main {
    public static void main(String[] a) {
        useTestCalendar();
    }

    private static void useTestCalendar() {
        Debug.log("useTestCalendar");
        TestCalendar a = new TestCalendar(new Date());
        TestCalendar b = new TestCalendar(a);

        System.out.println(a == b);
        System.out.println(a.equals(b));
    }
}
