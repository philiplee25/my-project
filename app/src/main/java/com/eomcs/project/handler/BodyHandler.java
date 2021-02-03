package com.eomcs.project.handler;

import java.sql.Date;
import com.eomcs.project.domain.Body;
import com.eomcs.utility.List;
import com.eomcs.utility.Prompt;

public class BodyHandler {

  private List bodyList = new List();

  public void add() {
    System.out.println("[신체정보 등록]");

    Body b = new Body();

    b.setNos(Prompt.inputInt("-번호? "));
    b.setNames(Prompt.inputString("-이름? "));
    b.setHeights(Prompt.inputDouble("-키? "));
    b.setWeights(Prompt.inputDouble("-몸무게? "));
    b.setBmis(Body.bmi(b.getHeights(), b.getWeights()));
    b.setRegisteredDates(new Date(System.currentTimeMillis()));

    bodyList.add(b);

    System.out.println("신체정보를 등록하였습니다.");

  }


  public void list() {

    System.out.println("[신체정보 목록조회]");

    Object[] list = bodyList.toArray();

    for (Object obj : list) {
      Body b = (Body) obj;
      System.out.printf("%d.이름 : %s\n  %s\n", b.getNos(), b.getNames(), b.getRegisteredDates());
      System.out.println();
    }
  }


  public void detail() {
    System.out.println("[게시글 상세보기]");

    int no = Prompt.inputInt("번호? ");

    Body b = findByNo(no);
    if (b == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    System.out.printf("%d.이름: %s\n", b.getNos(), b.getNames());
    System.out.printf("  키: %.2fcm\n  몸무게: %.2fkg\n", b.getHeights(), b.getWeights());
    System.out.printf("  BMI지수: %.2f\n", b.getBmis());
    System.out.printf("  날짜: %s\n", b.getRegisteredDates());

  }


  public void update() {
    System.out.println("[신체정보 변경]");

    int no = Prompt.inputInt("번호? ");

    Body b = findByNo(no);
    if (b == null) {
      System.out.println("해당 번호의 신체정보가 없습니다.");
      return;
    }

    String name = Prompt.inputString(String.format("-이름(%s)? ", b.getNames()));
    double height = Prompt.doubleUpdate("-키(%.2f)? ", b.getHeights());
    double weight = Prompt.doubleUpdate("-몸무게(%.2f)? ", b.getWeights());

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");

    if (input.equalsIgnoreCase("Y")) {
      b.setNames(name);
      b.setHeights(height);
      b.setWeights(weight);
      System.out.println("신체정보를 변경하였습니다.");

    } else {
      System.out.println("신체정보 변경을 취소하였습니다.");
    }
  }


  public void delete() {
    System.out.println("[신체정보 삭제]");

    int no = Prompt.inputInt("번호? ");

    Body body = findByNo(no);
    if (body == null) {
      System.out.println("해당 번호의 신체정보가 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");

    if (input.equalsIgnoreCase("Y")) {
      bodyList.delete(no);
      System.out.println("신체정보를 삭제하였습니다.");
    } else {
      System.out.println("신체정보 삭제를 취소하였습니다.");
    }
  }


  Body findByNo(int bodyNo) {
    Object[] list = bodyList.toArray();
    for (Object obj : list) {
      Body b = (Body) obj;
      if (b.getNos() == bodyNo) {
        return b;
      }
    }
    return null;
  }



}


