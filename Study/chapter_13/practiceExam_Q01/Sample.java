package practiceExam_Q01;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/** Q.01 */
public class Sample {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println(" in : ");
            String input = br.readLine();
            System.out.println("out : " + input);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
