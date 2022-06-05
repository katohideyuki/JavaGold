package chapter_07;

public class SampleDeprecated {

  @Deprecated
  public void unusable() {
    System.out.println("このメソッドは非推奨です");
  }

  @Deprecated(forRemoval = true)
  public void unusanleRemoval() {
    System.out.println("このメソッドは非推奨を強く示しています");
  }
}
