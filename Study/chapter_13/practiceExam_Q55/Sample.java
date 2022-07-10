package practiceExam_Q55;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import debug.Debug;

/** DateTimeFormatter.ofPattern の使用例 */
public class Sample {
    public static void main(String[] args) {
        datePattern();
    }

    /* 日付を3パターン出力する */
    private static void datePattern() {
        Debug.log("datePattern");
        LocalDate day = LocalDate.of(2022, 4, 1);
        List<DateTimeFormatter> dateList = List.of(
                DateTimeFormatter.ofPattern("yyyy'年' MMM dd'日' eeee"),    // 2022年 4月 01日 金曜日
                DateTimeFormatter.ofPattern("yyyy'年' MMM d'日' eee"),      // 2022年 4月 1日 金
                DateTimeFormatter.ofPattern("yyyy'年' M d'日' ee"));        // 2022年 4 1日 06
        dateList.stream().map(date -> date.format(day)).forEach(System.out::println);

    }
}

/**
 * <pre>
 * DateTimeFormatter.ofPattern()
 *   - 日付の書式を当たらすパターン文字列として受け取る。
 *   - パターン文字の間に入る「年」や「月」「日」などがパターン文字ではないことを
 *     ために示すに、シングルクォーテーション「'」で囲む必要がある。
 * </pre>
 */
