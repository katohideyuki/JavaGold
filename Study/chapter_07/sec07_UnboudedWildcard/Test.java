package sec07_UnboudedWildcard;

/** 非境界ワイルドカードの使用例 - どんな型でも扱えるクラス */
public class Test<T> {
    T value;

    // コンストラクタ
    public Test(T value) {
        this.value = value;
    }
    public T getValue() {
        return value;
    }
    public void setValue(T value) {
        this.value = value;
    }
}
