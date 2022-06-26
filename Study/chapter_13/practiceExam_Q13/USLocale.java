package practiceExam_Q13;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

import debug.Debug;

/** Q.13 */
public class USLocale {
    static final Locale LOCALE   = new Locale("en", "US");    // ロケール情報
    static final LocalDate TODAY = LocalDate.now();           // 本日日付

    public static void main(String[] args) {
        outToday(FormatStyle.MEDIUM);                         // 例 : Jun 26, 2022
        outToday(FormatStyle.SHORT);                          // 例 : 6/26/22
    }

    /* 受け取った FormatStyle のフォーマットで本日を出力 */
    private static void outToday(FormatStyle formatter) {
        Debug.log("outToday");
        String today = TODAY.format(
                DateTimeFormatter.ofLocalizedDate(formatter).withLocale(LOCALE));
        System.out.printf("%s format : %s%n",String.valueOf(formatter), today);
    }
}

/**
 * DateTimeFormatter.ofLocalizedDate(フォーマット)
 *   - ロケール固有の日付フォーマットを使用する formatter を提供する
 *
 * DateTimeFormatter.withLocale(ロケール情報)
 *   - ロケールをオーバーライドする
 */