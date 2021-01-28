package com.eomcs.project.handler;

import java.sql.Date;
import com.eomcs.project.domain.Diet;
import com.eomcs.utility.Prompt;



// 칼로리 직접 써넣기


public class DietHandler {

  static final int LENGTH = 10;
  static Diet[] diet = new Diet[LENGTH];
  static int size = 0;


  public void add() {

    Diet d = new Diet();

    while (true) {
      System.out.println("[식단 등록]");

      d.no = Prompt.Int("-번호? ");

      System.out.print("-0.아침 1.점심 2.저녁 3.간식\n");
      d.status = Prompt.Int("> ");

      d.name = "";
      while (true) {
        String food = Prompt.String("-먹은 음식?(완료: 빈 문자열) ");
        if (food.length() == 0) {
          break;
        } else if (!d.name.isEmpty()) {
          d.name += ", ";
        }
        d.name += food;
      }

      d.registerDate = new Date(System.currentTimeMillis());

      System.out.println("=====식단이 저장되었습니다.=====");

      diet[size++] = d;
      System.out.println();
      break;
    }
  }


  public void list() {

    System.out.println("[식단 조회]");



    for (int i = 0; i < size; i++) {

      Diet d = diet[i];

      String stateLabel = null;

      switch (d.status) {
        case 0:
          stateLabel = "아침";
          break;
        case 1:
          stateLabel = "점심";
          break;
        case 2:
          stateLabel = "저녁";
          break;
        default:
          stateLabel = "간식";
      }
      System.out.printf("[%s]\n%d. %s\n", d.registerDate, d.no, stateLabel);
      System.out.printf("식단: %s\n", d.name);
      System.out.println();
    }

    System.out.println();
  }
}
