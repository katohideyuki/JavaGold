package sec02_File;

import java.io.File;
import java.io.FileFilter;

import debug.Debug;

/** File.listFiles の使用例 */
public class UseOutPutListFiles {

    public static void main(String[] args) {
        useListFiles();
        useFileFilter();
    }

    /* とあるディレクトリ配下を一覧で出力する - 出力条件なし */
    private static void useListFiles() {
        Debug.log("useListFiles");
        File file = new File("src/main/resource/chapter_04");
        OutPutListFiles.noConditionShowTree(file, null);
    }

    /* とあるディレクトリ配下を一覧で出力する - 出力条件あり */
    private static void useFileFilter() {
        Debug.log("useFileFilter");
        try {
            File file = new File("chapter_05/sec02_File");

            // 出力条件を定義 - ディレクトリ または java ファイルであれば true を返却
            FileFilter filter = path -> {
                if (path.isDirectory()) return true;               // ディレクトリの場合
                if (path.getName().endsWith(".java")) return true; // java ファイルの場合
                return false;                                      // いずれも該当しない場合
            };
            OutPutListFiles.ConditionsShowTree(file, filter, "");
        } catch (RuntimeException e) {
            System.out.printf("Not found : %s%n", e);
        }
    }
}
