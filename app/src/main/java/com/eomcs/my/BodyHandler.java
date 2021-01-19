package com.eomcs.my;

public class BodyHandler {
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


  static void addBody() {

    for (size = 0; size < LENGTH; size++) {

      System.out.println("[신체정보 등록]");

      System.out.print("번호? ");
      nos[size] = Prompt.Int("번호? ");

      names[size] = Prompt.String("이름? ");

      heights[size] = Prompt.Double("키? ");

      weights[size] = Prompt.Double("몸무게? ");

      String str = Prompt.String("계속 입력하시겠습니까?(y/N) ");
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
  }



  static void listBody() {

    System.out.println("[신체정보 조회]");

    for (int i = 0; i < size; i++) {
      System.out.printf("%d.이름 : %s\n  %.2fcm  %.2fkg\n", nos[i], names[i], heights[i],
          weights[i]);
    }
    System.out.println();
  }
}
