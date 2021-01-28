package com.eomcs.project.handler;

import com.eomcs.project.domain.Body;
import com.eomcs.utility.Prompt;

public class BodyHandler {

  static final int LENGTH = 100;

  static Body[] bodys = new Body[LENGTH];

  static int size = 0;
  static int count = 0;


  public void add() {

    System.out.println("[신체정보 등록]");

    while (true) {
      if (size < LENGTH) {
        Body b = new Body();

        b.nos = Prompt.Int("-번호? ");

        b.names = Prompt.String("-이름? ");

        b.heights = Prompt.Double("-키? ");

        b.weights = Prompt.Double("-몸무게? ");

        b.bmis = bmi(b.heights, b.weights);

        b.registeredDates = new java.sql.Date(System.currentTimeMillis());

        bodys[size++] = b;

        String str = Prompt.String("-다음 신체정보를 등록하시겠습니까?(y/N) ");
        if (!str.equalsIgnoreCase("y")) {
          System.out.println("=====신체정보가 등록되었습니다.=====");
          System.out.println();
          break;
        }
        count++;
        System.out.println();

      } else {
        System.out.println("=====저장할 수 있는 신체정보가 꽉 찼습니다.=====");
        break;
      }
    }
  }


  public void list() {

    System.out.println("[신체정보 목록조회]");

    for (int i = 0; i < size; i++) {
      Body b = bodys[i];
      System.out.printf("%d.이름 : %s\n  %s\n", b.nos, b.names, b.registeredDates);
      System.out.println();
    }

    loop: while (true) {
      int choice1 = Prompt.Int2("1. 상세조회    0. 뒤로가기");
      switch (choice1) {
        case 1:
          System.out.println("[신체정보 상세조회]");

          int no = Prompt.Int("-번호? ");

          for (int i = 0; i < this.size; i++) {
            Body b = this.bodys[i];
            if (b.nos == no) {
              System.out.printf("%d.이름: %s\n", b.nos, b.names);
              System.out.printf("  키: %.2fcm\n  몸무게: %.2fkg\n", b.heights, b.weights);
              System.out.printf("  BMI지수: %.2f\n", b.bmis);
              System.out.printf("  날짜: %s\n", b.registeredDates);
            }
            return;
          }
          System.out.println("해당 번호의 신체정보가 없습니다.");
        case 0:
          break loop;
        default:
          System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
          continue;
      }
    }
  }


  public void update() {
    System.out.println("[신체정보 변경]");

    int no = Prompt.Int("번호? ");

    Body b = findByNo(no);
    if (b == null) {
      System.out.println("해당 번호의 신체정보가 없습니다.");
      return;
    }

    String name = Prompt.String(String.format("-이름(%s)? ", b.names));
    double height = Prompt.doubleUpdate("-키(%.2f)? ", b.heights);
    double weight = Prompt.doubleUpdate("-몸무게(%.2f)? ", b.weights);

    String input = Prompt.String("정말 변경하시겠습니까?(y/N) ");

    if (input.equalsIgnoreCase("Y")) {
      b.heights = height;
      b.weights = weight;
      System.out.println("신체정보를 변경하였습니다.");

    } else {
      System.out.println("신체정보 변경을 취소하였습니다.");
    }
  }


  public void delete() {
    System.out.println("[신체정보 삭제]");

    int no = Prompt.Int("번호? ");

    int i = indexOf(no);
    if (i == -1) {
      System.out.println("해당 번호의 신체정보가 없습니다.");
      return;
    }

    String input = Prompt.String("정말 삭제하시겠습니까?(y/N) ");

    if (input.equalsIgnoreCase("Y")) {
      for (int x = i + 1; x < this.size; x++) {
        this.bodys[x - 1] = this.bodys[x];
      }
      bodys[--this.size] = null;

      System.out.println("신체정보를 삭제하였습니다.");
      System.out.println();

    } else {
      System.out.println("신체정보 삭제를 취소하였습니다.");
      System.out.println();
    }


  }

  int indexOf(int bodyNo) {
    for (int i = 0; i < this.size; i++) {
      Body b = this.bodys[i];
      if (b.nos == bodyNo) {
        return i;
      }
    }
    return -1;
  }

  Body findByNo(int bodyNo) {
    int i = indexOf(bodyNo);
    if (i == -1)
      return null;
    else
      return this.bodys[i];
  }


  double bmi(double h, double w) {
    double height = h / 100;
    double bmi = w / height / height;
    return bmi;
  }
}


