package com.eomcs.project;

import com.eomcs.project.handler.BodyHandler;
import com.eomcs.project.handler.DietHandler;
import com.eomcs.project.handler.ExerciseHandler;
import com.eomcs.utility.Prompt;

public class App {

  public static void main(String[] args) {

    BodyHandler bodyList = new BodyHandler();
    ExerciseHandler exerciseList = new ExerciseHandler();
    DietHandler dietList = new DietHandler();

    loop: while (true) {
      System.out.println("/신체정보 등록");
      System.out.println("/신체정보 조회");
      System.out.println("/운동기록 추가");
      System.out.println("/운동기록 조회");
      System.out.println("/식단 등록");
      System.out.println("/식단 조회");

      String command = Prompt.String("명령> ");
      System.out.println();

      switch (command) {

        case "/신체정보 등록":
          bodyList.add();
          break;

        case "/신체정보 조회":
          bodyList.list();
          break;

        case "/신체정보 상세조회":
          bodyList.detail();
          break;

        case "/신체정보 변경":
          bodyList.update();
          break;

        case "/운동 추가":
          exerciseList.add();
          break;

        case "/운동 조회":
          exerciseList.list();
          break;

        case "/식단 기록":
          dietList.add();
          break;

        case "/식단 조회":
          dietList.list();
          break;

        case "quit":
        case "exit":
          System.out.println("종료합니다.");
          break loop;

        default:
          System.out.println("실행할 수 없는 명령입니다.");

      }
    }
    Prompt.close();
  }
}

