package dayStream;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

import debug.Debug;

/** DateTimeAPI で日付のストリームを生成する */
public class DaysStream {
    public static void main(String[] args) {
        useCreBetween();
    }


    /**
     * fromDate ~ toDate までの日付を出力する。
     * 出力時にフォーマットをyyyy/MM/ddに変換する。
     */
    private static void useCreBetween() {
        Debug.log("useCreBetween");
        var pattern = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        var fromDate = LocalDate.parse("2022/07/01", pattern);
        var toDate   = LocalDate.parse("2022/07/31", pattern);
        creBetween(fromDate, toDate)
            .map(date -> date.format(pattern))
            .forEach(System.out::println);
    }

    /**
     * <pre>
     * 開始日 〜 終了日 の期間の日付をストリームで返却する。
     * iterate で無限ストリームを作り、limit の代わりに takewhile で終了する条件を定める。
     * @param fromDate 開始日
     * @param toDate   終了日
     * @return 期間
     * </pre>
     */
    private static Stream<LocalDate> creBetween(LocalDate fromDate, LocalDate toDate) {
        return Stream.iterate(fromDate, d -> d.plusDays(1)).takeWhile(d -> !d.isAfter(toDate));
    }
}
/**
 * Stream.takeWhile(Predicate 型)
 *   - 条件を満たさなくなったら、処理を終了する。
 *
 * Locale.isAfter(LocalDate 型)
 *   - 指定された日付より未来であれば true を返却する。
 */
