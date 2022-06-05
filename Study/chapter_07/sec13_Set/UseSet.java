package sec13_Set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import debug.Debug;

/** Set の使用例 */
public class UseSet {
    static final List<Character> LIST = Arrays.asList('4', 'C', 'A', '1', 'B', '2', 'D', '3', 'A');

    public static void main(String[] args) {
        useHashSet();
        useTreeSet();
    }

    /* HashSet - 順不同 */
    private static void useHashSet() {
        Debug.log("useHashSet");
        Set<Character> hashSet = LIST.stream()
                .collect(Collectors.toCollection(HashSet::new));
        hashSet.stream().forEach(System.out::println);
    }

    /* TreeSet - 自然順 */
    private static void useTreeSet() {
        Debug.log("useTreeSet");
        Set<Character> treeSet = LIST.stream()
                .collect(Collectors.toCollection(TreeSet::new));
        treeSet.stream().forEach(System.out::println);
    }
}

/**
 * <pre>
 * Set インターフェース
 *   - 重複する要素を持たないことを保証するコレクション
 *   - 順序の保証は、実現クラスによって異なる
 *
 * HashSet クラス
 *   - Set インターフェースの実現クラス
 *   - 要素の並び順を保証しない
 *
 * TreeSet クラス
 *   - Set インターフェースの実現クラス
 *   - 自然順序で並び替えるか、引数で渡されたComparator で決める
 * </pre>
 */
