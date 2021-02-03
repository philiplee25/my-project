package com.eomcs.project.handler;

import java.sql.Date;
import com.eomcs.project.domain.Diet;
import com.eomcs.utility.List;
import com.eomcs.utility.Prompt;


public class DietHandler {

  private List dietList = new List();

  public void add() {
    System.out.println("[식단 기록]");

    Diet d = new Diet();

    d.no = Prompt.inputInt("-번호? ");
    d.status = Prompt.inputInt2("-0.아침 1.점심 2.저녁 3.간식");
    d.name = "";
    while (true) {
      String food = Prompt.inputString("-먹은 음식?(완료: 빈 문자열) ");
      if (food.length() == 0) {
        break;
      } else if (!d.name.isEmpty()) {
        d.name += ", ";
      }
      d.name += food;
    }
    d.registerDate = new Date(System.currentTimeMillis());

    dietList.add(d);
    System.out.println("=====식단이 저장되었습니다.=====");
  }


  public void list() {

    System.out.println("[식단 조회]");

    Object[] list = dietList.toArray();

    for (Object obj : list) {

      Diet d = (Diet) obj;

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

    int no = Prompt.inputInt("번호? ");
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
      String food = Prompt.inputString("-먹은 음식?(완료: 빈문자열) ");
      if (food.length() == 0) {
        break;
      } else if (!name.isEmpty()) {
        name += ", ";
      }
      name += food;
    }

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");

    if (input.equalsIgnoreCase("Y")) {
      d.setNo(no);
      d.setStatus(status);
      d.setName(name);
      System.out.println("식단을 변경하였습니다.");

    } else {
      System.out.println("식단 변경을 취소하였습니다.");
    }

  }

  public void delete() {
    System.out.println("[식단 삭제]");

    int no = Prompt.inputInt("번호? ");

    Diet diet = findByNo(no);
    if (diet == null) {
      System.out.println("해당 번호의 식단이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");

    if (input.equalsIgnoreCase("Y")) {
      dietList.delete(no);
      System.out.println("식단을 삭제하였습니다.");
      System.out.println();

    } else {
      System.out.println("식단 삭제를 취소하였습니다.");
      System.out.println();
    }

  }


  Diet findByNo(int dietNo) {
    Object[] list = dietList.toArray();
    for (Object obj : list) {
      Diet d = (Diet) obj;
      if (d.getNo() == dietNo) {
        return d;
      }
    }
    return null;
  }
}


