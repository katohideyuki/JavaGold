package sec05_NestedStaticClass;

import debug.Debug;
import sec05_NestedStaticClass.Outer.Inner;

/** ネストした static なクラス */
public class UseOuter {
    public static void main(String[] args) {
        useOuter();
    }

    /**/
    private static void useOuter() {
        Debug.log("useOuter");
        new Outer().test();
        new Inner().test();
    }
}
