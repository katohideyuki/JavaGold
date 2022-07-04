package practiceExam_Q19;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import debug.Debug;

/** List と Set の重複について */
public class Smaple {
    public static void main(String[] args) {
        confOfDuplication();
    }

    /* リストとセットの重複について確認 */
    private static void confOfDuplication() {
        Debug.log("confOfDuplication");
        List<String> list = new LinkedList<>();
        Set<String> set   = new HashSet<>();
        String[] array = { "a", "b", "c", "d", "a" };

        // List と Set に代入し、出力
        for (String str : array) {
            list.add(str);
            set.add(str);
        }
        System.out.printf("%s , %s ," , set.size(), list.size());   // 4, 5,

        // List2 と Set2 のサイズを出力
        List list2 = new LinkedList<>(set);
        Set set2   = new HashSet<>(list);
        System.out.printf("%s , %s", set2.size(), list2.size());    // 4, 4
    }
}

/**
 * <pre>
 * リストとセットの違い
 *   - リスト : 重複を許す
 *   - セット : 重複を許さない
 *     - 重複を許さないとは、equals() によって等しいと判断される要素
 *
 *  LinkedList
 *    - 要素の数が可変のコレクション
 *    - それぞれの要素は前の要素と次の要素の情報を持っていて、先頭の要素から順番に
 *      たどっていくことで各要素へのアクセスをする
 *
 * </pre>
 */