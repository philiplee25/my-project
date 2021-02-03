package com.eomcs.utility;

import java.sql.Date;
import java.util.Scanner;

public class Prompt {

  static Scanner keyboardScan = new Scanner(System.in);

  public static String inputString(String title) { // print
    System.out.print(title);
    return keyboardScan.nextLine();
  }

  public static String inputString2(String title) { // println
    System.out.println(title);
    System.out.print("> ");
    return keyboardScan.nextLine();
  }

  public static int inputInt(String title) {
    return Integer.parseInt(inputString(title));
  }

  public static int inputInt2(String title) {
    return Integer.parseInt(inputString2(title));
  }

  public static double inputDouble(String title) {
    return Double.parseDouble(inputString(title));
  }

  public static Date date(String title) {
    return Date.valueOf(inputString(title));
  }

  public static double doubleUpdate(String title, double d) {
    System.out.printf(title, d);
    return Double.parseDouble(keyboardScan.nextLine());
  }

  public static int intUpdate(String title, int i) {
    System.out.printf(title, i);
    return Integer.parseInt(keyboardScan.nextLine());
  }

  public static int intUpdate2(String title, int i, String string) {
    System.out.printf(title, i, string);
    return Integer.parseInt(keyboardScan.nextLine());
  }

  public static void close() {
    keyboardScan.close();
  }
}
