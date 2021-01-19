package com.eomcs.my;

import java.sql.Date;

public class ExerciseHandler {
  static final int RLENGTH = 100;
  static final int EXCOUNT = 3;
  static int rcount = 0;
  static int ruserChoice = 0;
  static int[] rnos = new int[RLENGTH];
  static int[] rexsCounts = new int[RLENGTH];
  static int[] rexsSets = new int[RLENGTH];
  static String[] rnames = new String[RLENGTH];
  static String[] rexAreas = new String[RLENGTH];
  static String[] rexs = new String[RLENGTH];
  static Date[] rregisteredDate = new Date[RLENGTH];

  static int rsize = 0;


  static void addExercise() {

    System.out.println("[운동기록 등록]");

    rnos[rsize] = Prompt.Int("번호? ");

    rexAreas[rsize] = Prompt.String("운동부위? ");


    for (int i = 0; i < EXCOUNT; i++) {

      System.out.printf("운동 이름: (%d개까지 입력 가능)", EXCOUNT);
      System.out.println();
      rexs[i] = Prompt.String("> ");

      rexsCounts[i] = Prompt.Int("횟수? ");

      rexsSets[i] = Prompt.Int("세트? ");
      System.out.println();

      String rstr = Prompt.String("계속 입력하시겠습니까?(y/N) ");
      System.out.println();
      if (!rstr.equalsIgnoreCase("y")) {
        System.out.println();
        break;
      }
      rcount++;

      if (rcount == EXCOUNT) {
        System.out.println("저장할 수 있는 운동기록이 꽉 찼습니다.");
        System.out.println();
        break;
      }
    }
    System.out.println();
    rsize++;
  }

  static void listExercise() {

    System.out.println("[운동기록 조회]");

    for (int i = 0; i < rsize; i++) {
      System.out.printf("%d. %s\n", rnos[i], rexAreas[i]);
      for (int j = 0; j <= rcount; j++) {
        System.out.printf("운동 : %s 횟수: %d 세트: %d\n", rexs[j], rexsCounts[j], rexsSets[j]);
      }
    }
    System.out.println();
  }
}
