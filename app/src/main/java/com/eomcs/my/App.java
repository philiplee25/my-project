package com.eomcs.my;

public class App {

  public static void main(String[] args) {

    loop: while (true) {

      String command = Prompt.String("명령> ");
      System.out.println();

      switch (command) {

        case "/신체정보 등록":
          BodyHandler.addBody();
          break;

        case "/신체정보 조회":
          BodyHandler.listBody();
          break;

        case "/운동기록 등록":
          ExerciseHandler.addExercise();
          break;

        case "/운동기록 조회":
          ExerciseHandler.listExercise();
          break;

        case "/식단 등록":
          DietHandler.addDiet();
          break;

        case "/식단 조회":
          DietHandler.listDiet();
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

