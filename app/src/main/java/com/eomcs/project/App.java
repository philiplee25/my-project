package com.eomcs.project;

import com.eomcs.project.handler.BodyHandler;
import com.eomcs.project.handler.DietHandler;
import com.eomcs.project.handler.ExerciseHandler;
import com.eomcs.utility.Prompt;

public class App {

  public static void main(String[] args) {

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
          BodyHandler.add();
          break;

        case "/신체정보 조회":
          BodyHandler.list();
          break;

        case "/운동 추가하기":
          ExerciseHandler.add();
          break;

        case "/운동 조회하기":
          ExerciseHandler.list();
          break;

        case "/식사 등록":
          DietHandler.add();
          break;

        case "/식사 조회":
          DietHandler.list();
          break;

        case "quit":
        case "exit":
          System.out.println("안녕!");
          break loop;

        default:
          System.out.println("실행할 수 없는 명령입니다.");

      }
    }
    Prompt.close();
  }
}

