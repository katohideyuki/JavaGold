package chapter_08;

public class Test<T> {
  T val;

  public Test(T val) {
    this.val = val;
  }

  public T getVal() {
    return val;
  }

  public void setVal(T val) {
    this.val = val;
  }
}
