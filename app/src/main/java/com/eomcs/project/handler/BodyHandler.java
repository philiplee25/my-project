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

    System.out.println("[신체정보 조회]");

    for (int i = 0; i < size; i++) {
      Body b = bodys[i];
      System.out.printf("%d.이름 : %s\n  %s\n", b.nos, b.names, b.registeredDates);
    }
    System.out.println();
  }


  static double bmi(double h, double w) {
    double height = h / 100;
    double bmi = w / height / height;
    return bmi;
  }


  public void detail() {
    System.out.println("[신체정보 상세보기]");

    int no = Prompt.Int("-번호? ");

    for (int i = 0; i < this.size; i++) {
      Body b = this.bodys[i];
      if (b.nos == no) {
        System.out.printf("%d.이름: %s\n", b.nos, b.names);
        System.out.printf("  키: %.2fcm\n  몸무게: %.2fkg\n", b.heights, b.weights);
        System.out.printf("  BMI지수: %.2f\n", b.bmis);
        System.out.printf("  날짜: %s\n", b.registeredDates);
        return;
      }
    }

    System.out.println("해당 번호의 신체정보가 없습니다.");
  }


  public void update() {
    System.out.println("[신체정보 변경]");

    int no = Prompt.Int("번호? ");

    Body body = findByNo(no);
    if (body == null) {
      System.out.println("해당 번호의 신체정보가 없습니다.");
      return;
    }

    String names = Prompt.String(String.format("-이름(%s)? ", body.names));

  }

  int indexOf(int bodyNo) {
    for (int i = 0; i < this.size; i++) {
      Body body = this.bodys[i];
      if (body.nos == bodyNo) {
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
}


