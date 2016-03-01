package co.adm.security;

import java.io.*;

/**
 * Created by cuichaoguo on 16/3/1.
 */
public class SecurityTest {

  public static void main(String args[]) {

    try {
      System.setSecurityManager(new PasswordSecurityManager("123456"));
    } catch (SecurityException se) {
      System.out.println("SecurityManager already set!");
    }

    try {
      //DataInputStream fis = new DataInputStream(new FileInputStream("input.txt"));
      BufferedReader fis = new BufferedReader(new FileReader("/tmp/input.txt"));
      //DataOutputStream fos = new DataOutputStream( new FileOutputStream("output.txt"));
      BufferedWriter fos = new BufferedWriter(new FileWriter("/tmp/output.txt"));
      String inputString;
      while ((inputString = fis.readLine()) != null) {
        //fos.writeBytes(inputString);
        //fos.writeByte('\n');
        fos.write(inputString);
        fos.write('\n');
      }
      fis.close();
      fos.close();
    } catch (IOException ioe) {
      System.out.println("I/O failed for SecurityManagerTest.");
    } catch (Exception e) {
      System.out.println(e.toString());
    }

  }
}

