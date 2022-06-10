package sec02_InnerClass;

import debug.Debug;

/** インナークラスの使用例 - Sample クラスを生成 */
public class SampleFactory {
    public static void main(String[] args) {
        sampleFactoryExe();
    }

    /* インナークラスとして定義した SampleImpl インスタンスを生成 */
    public static Sample creSampleImpl() {
        return new SampleFactory().new SampleImpl();
    }

    /** ▼ Sample インタフェースを継承したインナークラス */
    private class SampleImpl implements Sample {
        public void test() {
            System.out.println("test");
        }

        @Override
        public void execute() {
            System.out.println("execute");
        }
    }

    /* インナークラスを取得し、test(),  execute() メソッドを実行 */
    private static void sampleFactoryExe() {
        Debug.log("sampleFactoryExe");
        SampleImpl sample = (SampleImpl)creSampleImpl();
        sample.test();
        sample.execute();
    }
}

/**
 * <pre>
 * インナークラス
 *   - エンクロージングクラスのフィールドやメソッドが、インスタンスがなければ
 *     インナークラスは使えない
 *   - インナークラスのインスタンスだけをインスタンス化できない
 *     - new 親クラス().new インナークラス()
 * </pre>
 */
