package sec16_DateTimeFormatter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import debug.Debug;

/** DateTimeFormatter の使用例 */
public class SampleDTF {
    static final LocalDateTime CURRENT_DATE_TIME = LocalDateTime.now();   // 現在日時

    public static void main(String[] args) {
        useConstant();
        usePattern();
        useStyle();
    }

    /* 事前に定義された DateTimeFormatter の定数を使ってインスタンス生成 */
    private static void useConstant() {
        Debug.log("useConstant");

        // 定数を抜粋して、その定数を使用して現在日時を文字列にし Map に追加する
        Map<String, String> dateMap = Map.of(
                "BASIC_ISO_DATE", DateTimeFormatter.BASIC_ISO_DATE.format(CURRENT_DATE_TIME),
                "ISO_LOCAL_DATE", DateTimeFormatter.ISO_LOCAL_DATE.format(CURRENT_DATE_TIME),
                "ISO_LOCAL_TIME", DateTimeFormatter.ISO_LOCAL_TIME.format(CURRENT_DATE_TIME),
                "ISO_ORDINAL_DATE", DateTimeFormatter.ISO_ORDINAL_DATE.format(CURRENT_DATE_TIME)
                );
        // 定数名と現在時刻を出力
        dateMap.keySet().stream()
                        .forEach(key -> System.out.printf("%s : %s%n", key, dateMap.get(key)));
    }

    /* パターン文字を使って インスタンスを生成 */
    private static void usePattern() {
        Debug.log("usePattern");

        String pattern = "yyyy年MM月dd年";   // パターン文字列
        var originalFormat = DateTimeFormatter.ofPattern(pattern);
        System.out.printf("%s : %s%n", pattern, originalFormat.format(CURRENT_DATE_TIME));
    }

    /* ローカライズされたスタイル FormatStyle クラスを使ってインスタンス生成 */
    private static void useStyle() {
        Debug.log("useStyle");

        // デフォルトのロケールを日本に変更
        Locale.setDefault(Locale.JAPAN);

        // 受け取った FormatStyle の定数を使って、現在日時を返却するラムダを定義 (Stream で使用)
        Function<FormatStyle, String> getToday = d -> {
            return DateTimeFormatter.ofLocalizedDate(d).format(CURRENT_DATE_TIME);
        };

        // FormatStyle の定数を すべて取得
        FormatStyle[] fsArray = FormatStyle.values();

        // FormatStyle をキーに、getTodayラムダ の実行結果を値にセットし、出力
        Map<FormatStyle, String> map = Stream.of(fsArray)
                .collect(Collectors.toMap(UnaryOperator.identity(), getToday));
        map.keySet().stream().forEach(key -> System.out.printf("%s : %s%n", key, map.get(key)));
    }
}

/**
 * <pre>
 * DateTimeFormatter
 *   - 日付フォーマットのクラス
 *   - インスタンス生成は次の3パターンある
 *       1. DateTimeFormatter の定数を使用する
 *       2. パターン文字を使用する
 *       3. ローカライズされたスタイルを使用する
 *
 * DateTimeFormatter.formatter()
 *   - LocalDate, LocalDateTime などのインスタンスの参照を受け取り、書式を適用した文字列に変換
 *
 * DateTimeFormatter.ofPattern(パターン文字列)
 *   - パターン文字を使って、書式を自由に設定した上でインスタンスを生成
 *   - 「yyyy年MM月dd日」など
 *
 * FormatStyle
 *   - ローカライズされたスタイルを扱う Enum クラス
 *
 * DateTimeFormatter.ofLocalizedDate(日付)
 * DateTimeFormatter.ofLocalizedTime(時刻)
 * DateTimeFormatter.ofLocalizedDateTime(日付と日時)
 *
 * </pre>
 */