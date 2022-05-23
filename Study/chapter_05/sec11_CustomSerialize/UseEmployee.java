package sec11_CustomSerialize;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import debug.Debug;
import threadRelated.Sleep;

/** CustomSrealize の使用例 */
public class UseEmployee {
    // 出力先
    static final String FILE_PATH = "src/main/resource/chapter_05/sec11/sec11_sample.ser";

    public static void main(String[] args)
            throws FileNotFoundException, IOException, ClassNotFoundException {
        outputInstance();
        Sleep.exe(1000);
        inputInstance();
    }

    /* シリアライズ */
    private static void outputInstance()
            throws FileNotFoundException, IOException {
        Debug.log("outputInstance");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_PATH));

        try (out) {
            Employee emp = new Employee("comoli", "0123456789");
            out.writeObject(emp);
        }
    }

    /* デシリアライズ */
    private static void inputInstance()
            throws FileNotFoundException, IOException, ClassNotFoundException {
        Debug.log("inputInstance");
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_PATH));

        try (in) {
            Employee emp = (Employee) in.readObject();
            System.out.println(emp);
        }
    }
}
