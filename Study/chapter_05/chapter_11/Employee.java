package chapter_11;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 従業員の情報を管理するクラス<br>
 */
public class Employee implements Serializable {
  private String name;
  private String telephone;

  public Employee(String name, String telephone) {
    super();
    this.name = name;
    this.telephone = telephone;
  }

  /**
   * 指定したフィールドをシリアライズ<br>
   *
   * @param ObjectOutputStream
   */
  private void writeObject(ObjectOutputStream out) {
    System.out.println("write");
    try {
      out.writeObject(name);
      out.writeObject(telephone);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * 指定したフィールドをでシリアライズ<br>
   *
   * @param ObjectInputStream
   */
  private void readObject(ObjectInputStream in) {
    System.out.println("read");
    try {
      this.name = (String) in.readObject();
      this.telephone = (String) in.readObject();
    } catch (ClassNotFoundException | IOException e) {
      e.printStackTrace();
    }
  }

  public String getName() {
    return name;
  }

  public String getTelephone() {
    return telephone;
  }

  @Override
  public String toString() {
    return String.format("Employee [name=%s , telephone=%s ]", name, telephone);
  }

}
