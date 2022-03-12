package chapter_08;

/**
 * セキュアコーディング<br>
 * 不変オブジェクト<br>
 */
public class Main {
  public static void main(String[] a) {
    exe();
  }

  private static void exe() {
    SampleImmutable firstImmutable = new SampleImmutable.Builder().setInt(10).setStr("abc").build();
    System.out.printf("▼ SampleImmutableオブジェクト(1)%n%s",firstImmutable);

    System.out.println("▼ SampleImmutableオブジェクト(1)の値を変更します");
    firstImmutable.setStr("値を変更");
    System.out.println(firstImmutable);

    SampleImmutable secondImmutable = new SampleImmutable.Builder().setInt(10).build();
    System.out.printf("▼ SampleImmutableオブジェクト(2)%n%s",secondImmutable);

    System.out.println("▼ SampleImmutableオブジェクト(2)の値を変更して、新しいSampleImmutableを受け取ります");
    SampleImmutable thirdImmutable = secondImmutable.setStr("値を変更");
    System.out.printf("SampleImmutableオブジェクト(3)%n%s", thirdImmutable);

  }
}
