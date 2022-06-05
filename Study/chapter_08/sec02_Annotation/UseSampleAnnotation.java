package sec02_Annotation;

import sec02_Annotation.SampleAnnotation.*;

/** アノテーション
      - 注釈パラメータを受け取る */
public class UseSampleAnnotation {

    @Value("sample")                /** パラメータ名を省略する */
    class Omit {}

    @Value(value = "sample")        /** パラメータ名を省略しない */
    class NotOmit {}

    @ArrayValues(data = {1, 2, 3})  /** 複数の値を扱う */
    class useArrayValues {}

    @DefaultValue                   /** パラメータ名、値を省略する */
    class useDefaultValue {}
}

/**
 * <pre>
 * 注釈パラメータの受け取り方
 *   - @アノテーション名(注釈パラメータ名 = 値)
 *     - 1つだけだったら、パラメータ名を省略できる
 *       - @アノテーション名(値)
 *     - デフォルト値が設定されている場合、パラメータ名、値を省略できる
 * </pre>
 */
