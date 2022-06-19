package sec12_ResourceBundle;

import java.util.ResourceBundle;

/** ResourceBundle の使用例 */
public class RB {
    public static void main(String[] args) throws Exception {
        exe();
    }

    /* プロパティファイルを読み込み、値を表示 */
    private static void exe() throws Exception {
        ResourceBundle resource = ResourceBundle.getBundle("Japanese"); // 拡張子は不要(基底名のみ)
        System.out.println(resource.getString("test"));
    }
}

/**
 * <pre>
 * ResourceBundle
 *   - プロパティファイルを扱う抽象クラス
 *       - 抽象クラスなので、new でインスタンス生成できない
 *   - Locale を使える
 *   - デフォルトでURF-8で記述されたプロパティファイルを扱える
 *
 * ResourceBundle.getBundle(プロパティファイル名)
 *   - インスタンス生成
 *   - static メソッド
 *   - 引数のプロパティファイル名は、拡張子なしでよい
 *   - WEB-INF/classes 配下を見にいく
 *
 * ResourceBundle.getString
 * </pre>
 */
