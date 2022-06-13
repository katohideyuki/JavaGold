package sec06_LocalClass;

import debug.Debug;

/** ローカルクラスの使用例 */
public class UseFactory {
    public static void main(String[] args) {
        useLocalClassesHelloAndBye();
    }

    /* Factory クラスの Hello と Bye ローカルクラスを使用 */
    private static void useLocalClassesHelloAndBye() {
        Debug.log("useLocalClassesHelloAndBye");
        Factory.hello().execute();
        Factory.bye().execute();
    }
}
