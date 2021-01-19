package com.eomcs.my;

import java.sql.Date;
import java.util.Scanner;

public class Prompt {

  static Scanner keyboardScan = new Scanner(System.in);

  static String String(String title) {            // print
    System.out.print(title);
    return keyboardScan.nextLine(); 
  }

  static String String2(String title) {           // println
    System.out.println(title);
    return keyboardScan.nextLine(); 
  }

  static int Int(String title) {
    return Integer.parseInt(String(title));
  }

  static double Double(String title) {
    return Double.parseDouble(String(title));
  }

  static Date Date(String title) {
    return Date.valueOf(String(title));
  }

  static void close() {
    keyboardScan.close();
  }
}
