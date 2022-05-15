package sec15_Stream;

/** 設問15 */
public class Value {
    private String data;

    public Value(String data) {
        this.data = data;
    }

    @Override /* 常に100を返す */
    public int hashCode()             { return 100; }
    @Override /* 常に true を返す */
    public boolean equals(Object obj) { return true; }
    @Override /* debug */
    public String toString()          { return data; }
}
