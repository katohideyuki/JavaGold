package chapter_01;

/**
 * 新しいスレッドクラス
 * - Threadクラスのサブクラス
 *
 */
public class SampleThread extends Thread{
  @Override
  public void run() {
    System.out.println("New Thread");
  }

}
