package com.eomcs.project.handler;

import com.eomcs.project.domain.Exercise;
import com.eomcs.project.domain.Routine;
import com.eomcs.utility.Prompt;

public class ExerciseHandler {

  static final int LENGTH = 100;
  static Routine[] routine = new Routine[LENGTH];
  static Exercise[] exercise = new Exercise[LENGTH];
  static int size = 0;
  static int size2 = 0;



  public static void add() {

    System.out.println("[운동 추가하기]");

    Routine r1 = new Routine();

    loop: while (true) {
      r1.nos = Prompt.Int("-번호? ");

      String rname = Prompt.String("-루틴 이름?(등록취소: 빈 문자열) ");
      System.out.println();

      if (rname.length() == 0) {
        System.out.println("=====루틴 등록을 취소합니다.=====");
        return;
      } else {
        r1.names = rname;
      }

      routine[size++] = r1;

      while (true) {
        Exercise e1 = new Exercise();

        String ename = Prompt.String("-운동 이름?(완료: 빈 문자열) ");
        if (ename.length() == 0) {
          System.out.println("=====운동 등록을 종료합니다.=====");
          System.out.println();
          break loop;
        } else {
          e1.exs = ename;
          e1.counts = Prompt.Int("--횟수? ");
          e1.sets = Prompt.Int("--세트? ");
          System.out.println();
        }

        exercise[size2++] = e1;

        String str2 = Prompt.String("- 운동을 계속 추가하시겠습니까?(y/N) ");
        System.out.println();
        if (!str2.equalsIgnoreCase("y")) {
          System.out.println("=====운동이 등록되었습니다.=====");
          break loop;
        }
      }
    }
  }


  public static void list() {

    System.out.println("[운동기록 조회]");

    for (int i = 0; i < size; i++) {
      Routine r1 = routine[i];
      System.out.printf("%d. 루틴이름: %s\n", r1.nos, r1.names);
      for (int j = 0; j < size2; j++) {
        Exercise e1 = exercise[j];
        System.out.printf("운동 : %s 횟수: %d 세트: %d\n", e1.exs, e1.counts, e1.sets);
      }
    }
    System.out.println();
  }
}
