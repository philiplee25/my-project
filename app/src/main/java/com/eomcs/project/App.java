package com.eomcs.project;

import com.eomcs.project.handler.BodyHandler;
import com.eomcs.project.handler.DietHandler;
import com.eomcs.project.handler.ExerciseHandler;
import com.eomcs.utility.Prompt;

public class App {

  public static void main(String[] args) {

    loop: while (true) {

      String command = Prompt.String("명령> ");

      switch (command) {

        case "/신체정보 등록":
          BodyHandler.add();
          break;

        case "/신체정보 조회":
          BodyHandler.list();
          break;

        case "/운동기록 등록":
          ExerciseHandler.add();
          break;

        case "/운동기록 조회":
          ExerciseHandler.list();
          break;

        case "/식단 등록":
          DietHandler.add();
          break;

        case "/식단 조회":
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

