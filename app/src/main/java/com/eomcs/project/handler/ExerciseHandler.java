package com.eomcs.project.handler;

import com.eomcs.project.domain.Exercise;
import com.eomcs.utility.Prompt;

public class ExerciseHandler {

  static final int LENGTH = 100;
  static Exercise[] routine = new Exercise[LENGTH];
  static int size = 0;
  static int size2 = 0;



  public void add() {

    System.out.println("[운동 추가하기]");

    Exercise r = new Exercise();

    r.nos = Prompt.inputInt("-번호? ");

    String rname = Prompt.inputString("-루틴 이름?(등록취소: 빈 문자열) ");
    System.out.println();

    if (rname.length() == 0) {
      System.out.println("=====루틴 등록을 취소합니다.=====");
      return;
    } else {
      r.names = rname;
    }


    String ename = Prompt.inputString("-운동 이름?(완료: 빈 문자열) ");
    if (ename.length() == 0) {
      System.out.println("=====운동 등록을 종료합니다.=====");
      System.out.println();
    } else {
      r.weights = Prompt.inputInt("--무게(kg)? ");
      r.counts = Prompt.inputInt("--횟수? ");
      r.sets = Prompt.inputInt("--세트? ");
      System.out.println();

      String ename2 = Prompt.inputString("-운동 이름?(완료: 빈 문자열) ");
      if (ename.length() == 0) {
        System.out.println("=====운동 등록을 종료합니다.=====");
        System.out.println();
      } else {
        r.weights2 = Prompt.inputInt("--무게(kg)? ");
        r.counts2 = Prompt.inputInt("--횟수? ");
        r.sets2 = Prompt.inputInt("--세트? ");
        System.out.println();

        String ename3 = Prompt.inputString("-운동 이름?(완료: 빈 문자열) ");
        if (ename.length() == 0) {
          System.out.println("=====운동 등록을 종료합니다.=====");
          System.out.println();
        } else {
          r.weights3 = Prompt.inputInt("--무게(kg)? ");
          r.counts3 = Prompt.inputInt("--횟수? ");
          r.sets3 = Prompt.inputInt("--세트? ");
          System.out.println();
        }
      }
    }
  }

  public void list() {

    System.out.println("[운동기록 조회]");

    for (int i = 0; i < size; i++) {
      Exercise r1 = routine[i];
      System.out.printf("%d. 루틴이름: %s\n", r1.nos, r1.names);
      System.out.printf("운동 : %s 무게 : %dkg 횟수: %d 세트: %d\n", r1.exs, r1.counts, r1.sets);
    }
    System.out.println();
  }



  public void update() {
    System.out.println("[신체정보 변경]");

    int no = Prompt.inputInt("번호? ");

    Exercise r1 = findByNo(no);
    if (r1 == null) {
      System.out.println("해당 번호의 운동정보가 없습니다.");
      return;
    }

    String name = Prompt.inputString(String.format("-루틴이름(%s)? ", r1.names));


    while (true) {

      if (r1 == null) {
        System.out.println("해당 번호의 운동정보가 없습니다.");
        return;
      }
      String ename = Prompt.inputString("-운동 이름?(완료: 빈 문자열) ");
      if (ename.length() == 0) {
        System.out.println();
        break;
      } else {
        String exs1 = ename;
        int counts1 = Prompt.inputInt("--횟수? ");
        int sets1 = Prompt.inputInt("--세트? ");
        System.out.println();

        String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");

        if (input.equalsIgnoreCase("Y")) {
          r1.names = name;
          r1.exs = exs1;
          r1.counts = counts1;
          r1.sets = sets1;
          System.out.println("신체정보를 변경하였습니다.");

        } else {
          System.out.println("신체정보 변경을 취소하였습니다.");
          return;
        }
      }
    }
  }



  int indexOf(int routineNo) {
    for (int i = 0; i < this.size; i++) {
      Exercise r = this.routine[i];
      if (r.nos == routineNo) {
        return i;
      }
    }
    return -1;
  }

  Exercise findByNo(int routineNo) {
    int i = indexOf(routineNo);
    if (i == -1)
      return null;
    else
      return routine[i];
  }

}
