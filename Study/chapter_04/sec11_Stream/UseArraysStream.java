package sec11_Stream;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import debug.Debug;

/** Arrays.stream の使用例 */
public class UseArraysStream {

    public static void main(String[] args) {
        convertPrimitiveArrayToStream();
    }

    /* 配列の中身を出力 - 配列からストリームを生成 */
    private static void convertPrimitiveArrayToStream() {
        Debug.log("convertPrimitiveArrayToStream");

        int[] intArray       = { 1, 2, 3 };
        long[] longArray     = { 10L, 20L, 30L };
        double[] doubleArray = { 1.1, 2.2, 3.3 };
        String[] strArray    = { "A", "B", "C" };

        // int 型の配列から IntStream を生成
        System.out.println("▼ Convert from intArray to IntStream.");
        IntStream intNum = Arrays.stream(intArray);
        intNum.forEach(System.out::println);

        // long 型の配列から LongStream を生成
        System.out.println("\n▼ Convert from longArray to LongStream.");
        LongStream longNum = Arrays.stream(longArray);
        longNum.forEach(System.out::println);

        // double 型の配列から DoubleStream を生成
        System.out.println("\n▼ Convert from doubleArray to DoubleStream.");
        DoubleStream doubleNum = Arrays.stream(doubleArray);
        doubleNum.forEach(System.out::println);

        // String 型の配列から Stream を生成
        System.out.println("\n▼ Convert from StringArray to Stream.");
        Stream<String> str = Arrays.stream(strArray);
        str.forEach(System.out::println);
    }
}

/**
 * <pre>
 * Arrays.stream(配列)
 *   - プリミティブ型を扱う配列を渡すと、それぞれの型で用意されたXXXStream型が返却される
 *     - IntStream
 *     - LongStream
 *     - DoubleStream
 *
 *   - プリミティブ型以外は、Stream のジェネリクスで型を指定
 *     - Stream
 * </pre>
 */
