package com.eomcs.my;

import java.sql.Date;

public class DietHandler {
  static final int ELENGTH = 2;
  static int[] enos = new int[ELENGTH];
  static int ecount = 0;
  static String[] emenus = new String[ELENGTH];
  static Date[] eregisteredDate = new Date[ELENGTH];

  static int esize = 0;


  static void addDiet() {

    for (esize = 0; esize < ELENGTH; esize++) {
      System.out.println("[식단 등록]");

      enos[esize] = Prompt.Int("번호? ");

      emenus[esize] = Prompt.String("음식? ");

      String estr = Prompt.String("계속 입력하시겠습니까?(y/N) ");
      if (!estr.equalsIgnoreCase("y")) {
        System.out.println();
        break;
      }
      System.out.println();
      ecount++;

      if (ecount == ELENGTH) {
        System.out.println("더이상 드시면 안됩니다.");
        System.out.println();
        break;
      }
    }
    System.out.println();
    esize++;
  }

  static void listDiet() {

    System.out.println("[식단 조회]");

    for (int i = 0; i < esize; i++) {
      System.out.printf("%d. %s\n", enos[i], emenus[i]);
    }

    System.out.println();
  }
}
