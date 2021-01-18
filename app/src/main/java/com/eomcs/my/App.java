package com.eomcs.my;

import java.sql.Date;
import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    Scanner keyboardScan = new Scanner(System.in);


    final int LENGTH = 100;
    int[] nos = new int[LENGTH];
    String[] names = new String[LENGTH];
    int[] ages = new int[LENGTH];
    String[] sexs = new String[LENGTH];
    String[] tels = new String[LENGTH];
    int[] response = new int[LENGTH];

    int size = 0;


    final int TLENGTH = 100;
    String[] thospitals = new String[TLENGTH];
    int[] tuserChoice= new int[TLENGTH];
    int[] tstatus = new int[TLENGTH];

    int tsize = 0;

    final int ALENGTH = 100;
    int[] auserChoice = new int[ALENGTH];
    String[] acountry = new String[ALENGTH];
    Date[] astartDate = new Date[ALENGTH];
    Date[] aendDate = new Date[ALENGTH];
    String astrs = null;

    int asize = 0;


    loop:
      while (true) {

        System.out.print("명령> ");
        String command = keyboardScan.nextLine();
        System.out.println();

        switch (command) {
          case "/person/add":
            System.out.println("[인적사항 등록]");

            System.out.print("번호? ");
            nos[size] = Integer.parseInt(keyboardScan.nextLine());

            System.out.print("이름? ");
            names[size] = keyboardScan.nextLine();

            System.out.print("나이? ");
            ages[size] = Integer.valueOf(keyboardScan.nextLine());

            System.out.print("성별? ");
            sexs[size] = keyboardScan.nextLine();

            System.out.println("거주지역: ");
            System.out.println("1. 서울 / 경기");
            System.out.println("2. 강원도");
            System.out.println("3. 경상도");
            System.out.println("4. 전라도");
            System.out.println("5. 충청도");
            System.out.println("6. 제주도");
            System.out.println("7. 그 외");
            System.out.print("> ");

            response[size] = Integer.valueOf(keyboardScan.nextLine());

            while(true) {
              if(response[size] > 0 && response[size] < 8) {
                break;
              }else {
                System.out.println("잘못 입력하셨습니다. 다시 입력해주세요: ");
                System.out.print("> ");
                response[size] = Integer.valueOf(keyboardScan.nextLine());

              }
            }

            System.out.print("전화? ");
            tels[size] = keyboardScan.nextLine();


            size++;
            break;

          case "/test/add":
            System.out.println("[검사상태 등록]");

            for (int i = 0; i < size; i++) {
              System.out.printf("%d. %s\n", nos[i], names[i]);
            }
            System.out.println("등록할 이름을 고르세요.");
            System.out.print("> ");
            tuserChoice[size] = Integer.valueOf(keyboardScan.nextLine());

            while(true) {
              if(tuserChoice[size] > 0 && tuserChoice[size] <= size) {
                System.out.print("검사받은 병원명: ");
                thospitals[tsize] = keyboardScan.nextLine();

                System.out.println("검사결과: ");
                System.out.println("0: 음성");
                System.out.println("1: 진행중");
                System.out.println("2: 양성");
                System.out.print("> ");
                tstatus[tsize] = Integer.valueOf(keyboardScan.nextLine());

                while(true) {
                  if(tstatus[tsize] >= 0 && tstatus[tsize] < 3) {
                    break;
                  }else {
                    System.out.println("잘못 입력하셨습니다. 다시 입력해주세요: ");
                    System.out.print("> ");
                    tstatus[tsize] = Integer.valueOf(keyboardScan.nextLine());
                  }
                }
                break;
              }else {
                System.out.println("잘못 입력하셨습니다. 숫자를 입력해주세요:");
                System.out.print("> ");
                tuserChoice[size] = Integer.valueOf(keyboardScan.nextLine());
              }
            }

            tsize++;
            break;

          case "/ask/add":
            System.out.println("[질문사항 등록]");
            for (int i = 0; i < size; i++) {
              System.out.printf("%d. %s\n", nos[i], names[i]);
            }
            System.out.println("등록할 이름을 고르세요.");
            System.out.print("> ");
            auserChoice[size] = Integer.valueOf(keyboardScan.nextLine());

            while(true) {
              if(auserChoice[size] > 0 && auserChoice[size] <= size) {
                System.out.print("2주 이내에 해외방문한 이력이 있습니까?(y/N) ");
                astrs = keyboardScan.nextLine();
                if(astrs.equalsIgnoreCase("y")) {
                  System.out.print("방문한 나라: ");
                  acountry[asize] = keyboardScan.nextLine();

                  System.out.print("출국일자: ");
                  astartDate[asize] = Date.valueOf(keyboardScan.nextLine());

                  System.out.print("귀국일자: ");
                  aendDate[asize] = Date.valueOf(keyboardScan.nextLine());

                  break;

                }else {
                  break;
                }
              }
            }

            asize++;
            break;



          case "/total/list":

            for (int i = 0; i < size; i++) {
              System.out.printf("%d. %s\n", nos[i], names[i]);
            }
            System.out.println("조회할 이름을 고르세요.");
            System.out.print("> ");
            tuserChoice[size] = Integer.valueOf(keyboardScan.nextLine()) - 1;

            for(int i = 0; i < size; i++) {
              String regidence = null;
              switch(response[i]) {
                case 1 :
                  regidence = "서울 / 경기";
                  break;
                case 2 :
                  regidence = "강원도";
                  break;
                case 3:
                  regidence = "경상도";
                  break;
                case 4:
                  regidence = "전라도";
                  break;
                case 5:
                  regidence = "충청도";
                  break;
                case 6:
                  regidence = "제주도";
                  break;
                default:
                  regidence = "그 외";
              }

              String stateLabel = null;
              switch (tstatus[i]) {
                case 1:
                  stateLabel = "진행중";
                  break;
                case 2:
                  stateLabel = "양성";
                  break;
                default:
                  stateLabel = "음성";
              }



              if(tstatus[i] >= 0 && tstatus[i] < 3) {
                System.out.printf("이름: %s 나이: %d\n", names[i], ages[i]);
                System.out.printf("성별: %s 거주지역: %s\n", sexs[i], regidence);
                System.out.printf("번호: %s\n ", tels[i]);
                System.out.printf("검사받은 병원: %s 검사결과: %s\n", thospitals[i], stateLabel);
                System.out.println();
                System.out.printf("최근 2주이내 해외출국 이력: %s\n", astrs);
                if(astrs.equalsIgnoreCase("n")) {
                  System.out.println("없음");
                }else if(astrs.equalsIgnoreCase("y")) {
                  System.out.println("방문한 나라: " + acountry[i]);
                  System.out.println("출국일: " + astartDate[i]);
                  System.out.println("귀국일: " + aendDate[i]);
                }
                System.out.println();              
              }
            }
            break;


          case "quit":
          case "exit":
            System.out.println("안녕!");
            break loop;
          default:
            System.out.println("실행할 수 없는 명령입니다.");
        }
        System.out.println();
      }

    keyboardScan.close();
  }
}


