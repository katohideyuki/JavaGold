package practiceExam_Q16;

import java.util.Arrays;

import debug.Debug;

/** Stream.reduce の使用例 */
public class UseSample {
    public static void main(String[] args) {
        addUp();
    }

    /* Sample インスタンスの num フィールドが20以下の値を積算する */
    private static void addUp() {
        Debug.log("addUp");

        // Sample インスタンスのリストを生成
        var samples = Arrays.asList(
                new Sample("A", 8),
                new Sample("B", 21),
                new Sample("C", 23),
                new Sample("D", 12)
                );

        // 20以下の値にフィルタリングし、積算
        int result = samples.stream()
                .mapToInt(Sample::getNum)
                .filter(s -> s < 20)
                .reduce(0, (a, b) -> a + b);

        System.out.println(result);
    }
}
