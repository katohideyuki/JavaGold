package practiceExam_Q25;

/** enum のコンストラクタは private  */
enum Type {
    A(1), B(2), C(3);
    int val;

    // コンストラクタのアクセス修飾子が public なので、コンパイルエラーが起きる
//    public Type(int val) {
//        this.val = val;
//    }

    // アクセス修飾子を指定しなくても、暗黙的に private になる
    Type(int val) {
        this.val = val;
    }
}

/**
 * <pre>
 * enum のコンストラクタのアクセス修飾子は、private でなくてはいけない
 *   - enum は、あくまでも定数の集合を作るためのものである
 *   - enum 型のコンストラクタは、暗黙的に private として扱われる
 * </pre>
 */