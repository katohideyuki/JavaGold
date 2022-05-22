package sec02_File;

import java.io.File;
import java.io.FileFilter;

/** File.listFiles の使用例 - 出力ロジックを定義 */
public class OutPutListFiles {

    /* 出力条件がなく、ファイル一覧を再帰的に出力 */
    public static void noConditionShowTree(File dir, String indent) {
        File[] files = dir.listFiles();
        for (File file : files) {
            System.out.println(indent + file.getName());
            // サブディレクトリがあれば再帰呼び出し
            if (file.isDirectory())
                noConditionShowTree(file, " ");
        }
    }

    /* 出力条件があり、条件に合致したファイル一覧を再帰的に出力 */
    public static void ConditionsShowTree(File dir, FileFilter filter, String indent) {
        File[] files = dir.listFiles(filter);
        for (File file : files) {
            System.out.println(indent + file.getName());
            // サブディレクトリであれば、再帰呼び出し
            if (file.isDirectory())
                ConditionsShowTree(file, filter, indent + " ");
        }
    }
}

/**
 * File.listFiles()
 *   - ディレクトリの内容を表す File の配列を戻り値として返却
 *   - 結果の並び順は保証されない
 *
 * File.listFiles(FileFilter ラムダ式)
 *   - 指定した条件に合致するファイルの一覧を返却
 *
 * FileFilter インターフェース
 *   - Predicate と似たような感じで、引数を受け取り boolean 値を返却
 *     - Predicate と違うのは、引数が File 型と決まっていること
 */