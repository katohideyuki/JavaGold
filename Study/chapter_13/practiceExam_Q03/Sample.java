package practiceExam_Q03;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import debug.Debug;

/* Q.04 - Stream.peek() の使用例 */
public class Sample {
    public static void main(String[] args) {
        outEvenNumList();
    }

    /* 偶数のみのリストを出力 */
    private static void outEvenNumList() {
        Debug.log("creEvenNumList");

        // リストに0~100の乱数を格納して返却
        Random r = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            list.add(r.nextInt(100));

        // 処理前のリストを出力
        System.out.printf("Before : %s%n  => ", list);

        // 処理の途中結果を出力し、偶数のみのリストを生成
        List<Integer> resultList = list.stream()
                .filter(n -> n % 2 == 0)
                .peek(num -> System.out.printf("%s, ", num))
                .collect(Collectors.toList());
    }
}