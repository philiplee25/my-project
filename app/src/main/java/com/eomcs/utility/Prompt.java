package com.eomcs.utility;

import java.sql.Date;
import java.util.Scanner;

public class Prompt {

  static Scanner keyboardScan = new Scanner(System.in);

  public static String String(String title) { // print
    System.out.print(title);
    return keyboardScan.nextLine();
  }

  public static String String2(String title) { // println
    System.out.println(title);
    return keyboardScan.nextLine();
  }

  public static int Int(String title) {
    return Integer.parseInt(String(title));
  }

  public static double Double(String title) {
    return Double.parseDouble(String(title));
  }

  public static Date Date(String title) {
    return Date.valueOf(String(title));
  }

  public static void close() {
    keyboardScan.close();
  }
}
