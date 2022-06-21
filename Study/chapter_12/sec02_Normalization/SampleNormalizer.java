package sec02_Normalization;

import java.text.Normalizer;
import java.text.Normalizer.Form;

import debug.Debug;

/** Normalization の使用例 */
public class SampleNormalizer {
    static final String DE = "\u3066\u3099";    // で  ※ 結合文字

    public static void main(String[] args) {
        convertNFKC();
        convertNFKD();
    }

    /* 互換等価性に基づく分解後、正準等価性に基づいて合成「て゛→ で」にする - NFKC */
    private static void convertNFKC() {
        Debug.log("convertNFKC");
        String de     = "\u3066\u3099";                           // て + 濁点 = て゛  ※ 結合文字
        String result = Normalizer.normalize(de, Form.NFKC);      // 結合文字を合成文字にする
        printHelper(de, result);                                  // て゛ : 2文字 → で : 1文字
    }

    /* 互換等価性に基づく分解をして、「㈱ → (株)」にする - NFKD */
    private static void convertNFKD() {
        Debug.log("convertNFKD");
        String kabu   = "\u3231";                                 // ㈱  ※ 合成文字
        String result = Normalizer.normalize(kabu, Form.NFKD);    // 合成文字を結合文字にする
        printHelper(kabu, result);                                // ㈱ : 1文字 → (株) : 3文字
    }

    /* debug - 変換前と後の文字列を出力する */
    private static void printHelper(String before, String result) {
        // 変換前
        System.out.println("""
                BEFORE
                  => Character  : %s
                     word count : %d
                """.formatted(before, before.length()));
        // 変換後
        System.out.println("""
                AFTER
                  => Character  : %s
                     word count : %d
                """.formatted(result, result.length()));
    }
}

/**
 * <pre>
 * 正規化 Normalization
 *   - 入力された文字列を処理しやすい形に変形したり整理したりする
 *
 * Unicode
 *   - 世界中の文字を1つのコード体型で表現することを目指した文字コード  例 : 「\u3066」
 *   - 結合文字
 *     - 複数の文字を結合して1つの文字を表現  例 : て + ゛ = で ※2文字で1文字
 *   - 合成済み文字
 *     - 文字があらかじめ合成されている文字   例 : で = で ※1文字
 *
 * Unicode の正規化
 *   - 結合文字を合成済みに統一したり、合成済み文字を結合文字にしたりする
 *       - 正規化の方法
 *           - NFD  : 正準等価性に基づく分解
 *           - NFC  : 正準等価性に基づく分解後、正準等価性に基づいて合成
 *           - NFKD : 互換等価性に基づく分解
 *           - NFKC : 互換等価性に基づく分解後、正準等価性に基づいて合成
 *       - 分解とは、合成済み文字を結合文字列に変換
 *       - 合祀とは、結合文字列を合成済み文字に変換
 *       - 正準等価性とは、同じ文字の見た目と同じ意味を持つ文字       例 : て + ゛ = で
 *       - 互換等価性とは、文字の見た目が異なるが、同じ意味を持つ文字  例 : (株) ≒ ㈱
 *   - 入力検証は、この正規化を行ったあとに実施する
 *
 * text.Normalizer
 *   - Unicode の正規化を行う
 *
 * Normalizer.normalize(正規化したい文字列, 正規化の方法)
 * Normalizer.From
 *   - 正規化方法を定義した列挙定数
 * </pre>
 */

