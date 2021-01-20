package com.eomcs.project.Handler;

import java.sql.Date;
import com.eomcs.Utility.Prompt;

public class BodyHandler {

  static class Body {
    int nos;
    int status;
    double heights;
    double weights;
    String names;
    Date registeredDates;
  }

  static final int LENGTH = 100;
  static Body[] bodys = new Body[LENGTH];
  static int size = 0;
  static int count = 0;


  public static void addBody() {

    System.out.println("[신체정보 등록]");

    while (true) {
      if (size < LENGTH) {
        Body b = new Body();

        b.nos = Prompt.Int("번호? ");

        b.names = Prompt.String("이름? ");

        b.heights = Prompt.Double("키? ");

        b.weights = Prompt.Double("몸무게? ");

        b.registeredDates = new java.sql.Date(System.currentTimeMillis());

        bodys[size++] = b;

        String str = Prompt.String("계속 입력하시겠습니까?(y/N) ");
        if (!str.equalsIgnoreCase("y")) {
          break;
        }
        count++;

        if (count == LENGTH) {
          System.out.println("저장할 수 있는 신체정보가 꽉 찼습니다.");
          System.out.println();
          break;
        }
        System.out.println();
      } else {
        System.out.println("저장할 수 있는 신체정보가 꽉 찼습니다.");
        break;
      }
    }
  }


  public static void listBody() {

    System.out.println("[신체정보 조회]");

    for (int i = 0; i < size; i++) {
      System.out.printf("%d.이름 : %s\n  %.2fcm  %.2fkg\n", bodys[i].nos, bodys[i].names,
          bodys[i].heights, bodys[i].weights);
    }
    System.out.println();
  }
}
