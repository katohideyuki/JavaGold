package chapter_04;

/**
 * Builderパターンのおさらい<br>
 */
public class BuilderReviewMain {
  public static void main(String[] args) {
    exe();
  }

  private static void exe() {
    var br = new BuilderReview.Builder().setName("review").build();
    System.out.println(br.getName());
  }
}
