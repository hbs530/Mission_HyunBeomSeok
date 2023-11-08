package com.ll;
// 패키지는 자바 클래스를 모아놓은 폴더

import java.util.Scanner;
// 임포트는 다른 클래스 또는 패키지의 멤버(클래스, 인터페이스, 메서드 등)을 현재 클래스에서 사용할 수 있게 하는 역할
// Scanner는 키보드 입력 또는 파일로부터 데이터를 읽어오기 위한 클래스

public class App {
    // App 클래스 선언
    public void run() {
        // 반환 값이 없는 void를 반환 유형으로 한 run 메서드 선언

        System.out.println("== 명언 앱 ==");
        // == 명언 앱 == 출력 후 줄 바꿈

        int lastQuotationId = 0;
        // 명언의 횟수를 저장하는 lastQuotationId 변수를 0으로 초기화

        while(true) {
        // 항상 참인 조건을 가진 무한 루프

            System.out.print("명령) ");
            // 명령) 출력

            Scanner scanner = new Scanner(System.in);
            // 표준 입력 스트림을 나타내는 System.in을 사용하는 키보드 입력을 위한 scanner 인스턴스 생성

            String cmd = scanner.nextLine();
            // scanner 인스턴스로 Scanner 클래스에서 제공되는 nextLine 메서드를 호출하여 리턴 값을 문자열 변수 cmd에 대입

            if (cmd.equals("종료")){
            // 두 객체가 내용이 같은지 비교할 떄 사용되는 equals 메서드를 사용하여 입력된 cmd 변수가 종료와 같으면

                break;
                // 대입된 cmd 변수가 “종료”와 동일하다는 조건이면 해당 조건문을 탈출
            }
            else if (cmd.equals("등록")) {
            // 두 객체가 내용이 같은지 비교할 떄 사용되는 equals 메서드를 사용하여 입력된 cmd 변수가 등록과 같으면

                System.out.print("명언 : ");
                // 명언 : 출력

                String content = scanner.nextLine();
                // scanner 인스턴스로 Scanner 클래스에서 제공되는 nextLine 메서드를 호출하여 리턴 값을 문자열 변수 content에 대입

                System.out.print("작가 : ");
                // 작가 : 출력

                String authorName = scanner.nextLine();
                // scanner 인스턴스로 Scanner 클래스에서 제공되는 nextLine 메서드를 호출하여 리턴 값을 문자열 변수 authorName에 대입

                lastQuotationId++;
                // 명언을 입력하였으므로 명언의 횟수를 저장하는 lastQuotationId 변수를 +1

                System.out.printf("%d번 명언이 등록 되었습니다.\n", lastQuotationId);
                // +1이 된 lastQuotationId 변수 + 명언이 등록되었습니다. 출력
            }
        }
    }
}
