package com.eomcs.project.handler;

import com.eomcs.project.domain.Routine;
import com.eomcs.utility.Prompt;

public class ExerciseHandler {

  static final int LENGTH = 100;
  static Routine[] routine = new Routine[LENGTH];
  static int size = 0;
  static int size2 = 0;



  public void add() {

    System.out.println("[운동 추가하기]");

    Routine r = new Routine();

    loop: while (true) {
      r.nos = Prompt.Int("-번호? ");

      String rname = Prompt.String("-루틴 이름?(등록취소: 빈 문자열) ");
      System.out.println();

      if (rname.length() == 0) {
        System.out.println("=====루틴 등록을 취소합니다.=====");
        return;
      } else {
        r.names = rname;
      }


      String ename = Prompt.String("-운동 이름?(완료: 빈 문자열) ");
      if (ename.length() == 0) {
        System.out.println("=====운동 등록을 종료합니다.=====");
        System.out.println();
        break loop;
      } else {
        r.weights = Prompt.Int("--무게(kg)? ");
        r.counts = Prompt.Int("--횟수? ");
        r.sets = Prompt.Int("--세트? ");
        System.out.println();
      }
      routine[size++] = r;

    }
  }


  public void list() {

    System.out.println("[운동기록 조회]");

    for (int i = 0; i < size; i++) {
      Routine r1 = routine[i];
      System.out.printf("%d. 루틴이름: %s\n", r1.nos, r1.names);
      System.out.printf("운동 : %s 무게 : %dkg 횟수: %d 세트: %d\n", r1.exs, r1.counts, r1.sets);
    }
    System.out.println();
  }



  public void update() {
    System.out.println("[신체정보 변경]");

    int no = Prompt.Int("번호? ");

    Routine r1 = findByNo(no);
    if (r1 == null) {
      System.out.println("해당 번호의 운동정보가 없습니다.");
      return;
    }

    String name = Prompt.String(String.format("-루틴이름(%s)? ", r.names));


    while (true) {

      if (r1 == null) {
        System.out.println("해당 번호의 운동정보가 없습니다.");
        return;
      }
      String ename = Prompt.String("-운동 이름?(완료: 빈 문자열) ");
      if (ename.length() == 0) {
        System.out.println();
        break;
      } else {
        r.exs = ename;
        r.counts = Prompt.Int("--횟수? ");
        r.sets = Prompt.Int("--세트? ");
        System.out.println();
      }

      String input = Prompt.String("정말 변경하시겠습니까?(y/N) ");

      if (input.equalsIgnoreCase("Y")) {
        r.names = name;
        r.exs = exs;
        r.counts = counts;
        r.sets = sets;
        System.out.println("신체정보를 변경하였습니다.");
        break;

      } else {
        System.out.println("신체정보 변경을 취소하였습니다.");
      }

    }

  }



  int indexOf(int routineNo) {
    for (int i = 0; i < this.size; i++) {
      Routine r = this.routine[i];
      if (r.nos == routineNo) {
        return i;
      }
    }
    return -1;
  }

  Routine findByNo(int routineNo) {
    int i = indexOf(routineNo);
    if (i == -1)
      return null;
    else
      return routine[i];
  }

  Exercise findByNo2(int exerciseNo) {
    int i = indexOf(exerciseNo);
    if (i == -1)
      return null;
    else
      return exercise[i];
  }
}
