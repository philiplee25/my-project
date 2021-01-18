package com.eomcs.my;

import java.sql.Date;
import java.util.Scanner;

public class App {

  static Scanner keyboardScan = new Scanner(System.in);

  static final int LENGTH = 100;
  static int count = 0;
  static int userChoice = 0;
  static int[] nos = new int[LENGTH];
  static int[] status = new int[LENGTH];
  static double[] heights = new double[LENGTH];
  static double[] weights = new double[LENGTH];
  static double[] bmis = new double[LENGTH];
  static String[] names = new String[LENGTH];


  static int size = 0;



  static final int RLENGTH = 100;
  static final int EXCOUNT = 3;
  static int rcount = 0;
  static int ruserChoice = 0;
  static int[] rnos = new int[RLENGTH];
  static int[] rexsCounts = new int[RLENGTH];
  static int[] rexsSets = new int[RLENGTH];
  static String[] rnames = new String[RLENGTH];
  static String[] rexAreas = new String[RLENGTH];
  static String[] rexs = new String[RLENGTH];
  static Date[] rregisteredDate = new Date[LENGTH];

  static int rsize = 0;


  static final int ELENGTH = 2;
  static int[] enos = new int[ELENGTH];
  static int ecount = 0;
  static String[] emenus = new String[ELENGTH];
  static Date[] eregisteredDate = new Date[LENGTH];

  static int esize = 0;


  public static void main(String[] args) {



    loop: while (true) {

      System.out.print("명령 > ");
      String command = keyboardScan.nextLine();
      System.out.println();

      switch (command) {

        case "/신체정보 등록":

          for (size = 0; size < LENGTH; size++) {
            System.out.println("[신체정보 등록]");

            System.out.print("번호? ");
            nos[size] = Integer.parseInt(keyboardScan.nextLine());

            System.out.print("이름? ");
            names[size] = keyboardScan.nextLine();

            System.out.print("키? ");
            heights[size] = Double.parseDouble(keyboardScan.nextLine());

            System.out.print("몸무게? ");
            weights[size] = Double.parseDouble(keyboardScan.nextLine());

            System.out.print("계속 입력하시겠습니까?(y/N) ");
            String str = keyboardScan.nextLine();
            if (!str.equalsIgnoreCase("y")) {
              break;
            }
            count++;
            System.out.println();

            if (count == LENGTH) {
              System.out.println("저장할 수 있는 신체정보가 꽉 찼습니다.");
              System.out.println();
              break;
            }
          }


          System.out.println();

          size++;
          break;


        case "/신체정보 조회":

          System.out.println("[신체정보 조회]");

          for (int i = 0; i < size; i++) {
            System.out.printf("%d.이름 : %s\n  %.2fcm  %.2fkg\n", nos[i], names[i], heights[i],
                weights[i]);
          }

          System.out.println();

          break;


        case "/운동기록 등록":
          System.out.println("[운동기록 등록]");

          System.out.print("번호: ");
          rnos[rsize] = Integer.parseInt(keyboardScan.nextLine());

          System.out.print("운동 부위: ");
          rexAreas[rsize] = keyboardScan.nextLine();


          for (int i = 0; i < EXCOUNT; i++) {

            System.out.printf("운동 이름: (%d개까지 입력 가능)", EXCOUNT);
            System.out.println();
            System.out.print("> ");
            rexs[i] = keyboardScan.nextLine();
            System.out.print("횟수: ");
            rexsCounts[i] = Integer.parseInt(keyboardScan.nextLine());
            System.out.print("세트: ");
            rexsSets[i] = Integer.parseInt(keyboardScan.nextLine());
            System.out.println();

            System.out.print("계속 입력하시겠습니까?(y/N) ");
            String rstr = keyboardScan.nextLine();
            System.out.println();
            if (!rstr.equalsIgnoreCase("y")) {
              break;
            }
            rcount++;

            if (rcount == EXCOUNT) {
              System.out.println("저장할 수 있는 운동기록이 꽉 찼습니다.");
              System.out.println();
              break;
            }

          }

          rsize++;
          break;

        case "/운동기록 조회":

          System.out.println("[운동기록 조회]");

          for (int i = 0; i < rsize; i++) {
            System.out.printf("%d. %s\n", rnos[i], rexAreas[i]);
            for (int j = 0; j <= rcount; j++) {
              System.out.printf("운동 : %s 횟수: %d 세트: %d\n", rexs[j], rexsCounts[j], rexsSets[j]);
            }

          }


          System.out.println();
          break;


        case "/식단 등록":

          for (esize = 0; esize < ELENGTH; esize++) {
            System.out.println("[식단 등록]");

            System.out.print("번호: ");
            enos[size] = Integer.parseInt(keyboardScan.nextLine());

            System.out.print("음식: ");
            emenus[size] = keyboardScan.nextLine();

            System.out.print("계속 입력하시겠습니까?(y/N) ");
            String estr = keyboardScan.nextLine();
            if (!estr.equalsIgnoreCase("y")) {
              break;
            }
            ecount++;

            if (ecount == ELENGTH) {
              System.out.println("더이상 드시면 안됩니다.");
              System.out.println();
              break;
            }
          }

          System.out.println();

          esize++;
          break;

        case "/식단 조회":
          System.out.println("[식단 조회]");

          for (int i = 0; i < esize; i++) {
            System.out.printf("%d. %s\n", enos[i], emenus[i]);
          }

          System.out.println();
          break;

        case "quit":
        case "exit":
          System.out.println("안녕!");
          break loop;

        default:
          System.out.println("실행할 수 없는 명령입니다.");

      }
    }

    keyboardScan.close();

  }
}

