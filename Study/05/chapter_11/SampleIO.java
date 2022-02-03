package chapter_11;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Optional;

/**
 * 入出力<br>
 * カスタム・シリアライズ<br>
 *
 */
public class SampleIO {
  public static void main(String[] a) {
    outputExecution("emp.ser", "kato", "0123456789ll");
    sleep(1000);
    inputExecution("emp.ser");
  }

  /**
   * employeeインスタンスのフィールドを書き込む<br>
   * @param fileName
   */
  private static void outputExecution(String fileName, String name, String telephone) {
    ObjectOutputStream out = null;
    var emp = new Employee(name, fileName);
    try {
      out = new ObjectOutputStream(new FileOutputStream(fileName));
    } catch (IOException e) { // なぜClassNotFoundExceptionをキャッチする必要がないのか
      e.printStackTrace();
    }
    outputProcess(Optional.ofNullable(out), emp);
  }

  /**
   * シリアライズ処理<br>
   * @param outOp
   * @param emp
   */
  private static void outputProcess(Optional<ObjectOutputStream> outOp, Employee emp) {
    outOp.ifPresentOrElse(out -> {
      try (out) {
        out.writeObject(emp);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }, () -> System.out.println("書き込み処理が実行できませんでした"));
  }

  /**
   * 引数のファイルを読み込む<br>
   * @param fileName
   */
  private static void inputExecution(String fileName) {
    ObjectInputStream in = null;
    try {
      in = new ObjectInputStream(new FileInputStream(fileName));
    } catch (IOException e) {
      e.printStackTrace();
    }
    inputProcess(Optional.ofNullable(in));
  }

  private static void inputProcess(Optional<ObjectInputStream> inOp) {
    inOp.ifPresentOrElse(in -> {
      try {
        Employee emp = (Employee) in.readObject();
        System.out.println(emp);
      } catch (ClassNotFoundException | ClassCastException |IOException e) {
        e.printStackTrace();
      }
    }, () -> System.out.println("読み込み処理が実行できませんでした"));
  }

  public static void sleep(int time) {
    try {
      Thread.sleep(time);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
