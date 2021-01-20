package com.eomcs.project.Handler;

import java.sql.Date;
import com.eomcs.Utility.Prompt;

public class ExerciseHandler {

  static class Exercise {
    int nos;
    String areas;
    Date registeredDate;
  }

  static class Exercise2 {
    String exs;
    int counts;
    int sets;
  }

  static final int LENGTH = 100;
  static final int COUNT = 3;
  static Exercise[] exercise = new Exercise[LENGTH];
  static Exercise2[] exercise2 = new Exercise2[LENGTH];
  static int size = 0;
  static int count;


  public static void addExercise() {

    loop: while (true) {
      if (size < LENGTH) {

        Exercise e1 = new Exercise();

        System.out.println("[운동기록 등록]");

        e1.nos = Prompt.Int("번호? ");
        e1.areas = Prompt.String("운동부위? ");

        exercise[size++] = e1;

        while (true) {
          if (count < COUNT) {

            Exercise2 e2 = new Exercise2();

            System.out.printf("운동 이름: (%d개까지 입력 가능)", COUNT);
            System.out.println();
            e2.exs = Prompt.String("> ");

            e2.counts = Prompt.Int("횟수? ");

            e2.sets = Prompt.Int("세트? ");
            System.out.println();

            String str = Prompt.String("계속 입력하시겠습니까?(y/N) ");
            System.out.println();
            if (!str.equalsIgnoreCase("y")) {
              break;
            }
            exercise2[count++] = e2;

            if (count == COUNT) {
              System.out.println("기록할 수 있는 운동이 꽉 찼습니다.");
              System.out.println();
              break;
            }
          }
        } // 운동 개수 저장하고 하기 싫으면 1. 2. 정해서 계속 입력할지 안할지 만들기
      } else {
        System.out.println("저장할 수 있는 운동기록이 모두 찼습니다.");
      }
    }
  }


  public static void listExercise() {

    System.out.println("[운동기록 조회]");

    for (int i = 0; i < size; i++) {
      System.out.printf("%d. %s\n", exercise[i].nos, exercise[i].areas);
      for (int j = 0; j < count; j++) {
        System.out.printf("운동 : %s 횟수: %d 세트: %d\n", exercise2[i].exs, exercise2[i].counts,
            exercise2[i].sets);
      }
    }
    System.out.println();
  }
}
