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
      System.out.println("[식단 기록]");

      d.no = Prompt.Int("-번호? ");

      d.status = Prompt.Int2("-0.아침 1.점심 2.저녁 3.간식");

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


  public void update() {
    System.out.println("[식단 변경]");

    int no = Prompt.Int("번호? ");
    Diet d = findByNo(no);
    if (d == null) {
      System.out.println("해당 번호의 식단이 없습니다.");
      return;
    }

    System.out.print("-0.아침 1.점심 2.저녁 3.간식\n");
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

    int status = Prompt.intUpdate2("-식사시간(%d.%s)? ", d.status, stateLabel);


    String name = "";
    while (true) {
      String food = Prompt.String("-먹은 음식?(완료: 빈문자열) ");
      if (food.length() == 0) {
        break;
      } else if (!name.isEmpty()) {
        name += ", ";
      }
      name += food;
    }

    String input = Prompt.String("정말 변경하시겠습니까?(y/N) ");

    if (input.equalsIgnoreCase("Y")) {
      d.no = no;
      d.status = status;
      d.name = name;
      System.out.println("식단을 변경하였습니다.");

    } else {
      System.out.println("식단 변경을 취소하였습니다.");
    }

  }

  public void delete() {
    System.out.println("[식단 삭제]");

    int no = Prompt.Int("번호? ");

    int i = indexOf(no);
    if (i == -1) {
      System.out.println("해당 번호의 식단이 없습니다.");
      return;
    }

    String input = Prompt.String("정말 삭제하시겠습니까?(y/N) ");

    if (input.equalsIgnoreCase("Y")) {
      for (int x = i + 1; x < this.size; x++) {
        this.diet[x - 1] = this.diet[x];
      }
      diet[--this.size] = null;

      System.out.println("식단을 삭제하였습니다.");
      System.out.println();

    } else {
      System.out.println("식단 삭제를 취소하였습니다.");
      System.out.println();
    }

  }


  int indexOf(int dietNo) {
    for (int i = 0; i < size; i++) {
      Diet d = diet[i];
      if (d.no == dietNo) {
        return i;
      }
    }
    return -1;
  }

  Diet findByNo(int dietNo) {
    int i = indexOf(dietNo);
    if (i == -1) {
      return null;
    } else {
      return diet[i];
    }
  }
}


