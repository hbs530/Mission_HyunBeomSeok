package com.ll;
// 패키지는 자바 클래스를 모아놓은 폴더

import java.util.ArrayList;
// 임포트는 다른 클래스 또는 패키지의 멤버(클래스, 인터페이스, 메서드 등)을 현재 클래스에서 사용할 수 있게 하는 역할
// ArrayList는 동적 배열 구조를 제공하는 List 인터페이스를 구현하는 클래스 중 하나

import java.util.List;
// List는 순서가 있는 데이터 컬렉션을 나타내는 인터페이스

import java.util.Scanner;
// Scanner는 키보드 입력 또는 파일로부터 데이터를 읽어오기 위한 클래스

public class App {
// App 클래스 선언
    Scanner scanner;
    // Scanner 클래스의 scanner 인스턴스 선언
    int lastQuotationId;
    // 명언의 횟수를 저장하는 lastQuotationId 변수 선언
    List<Quotation> quotations;
    // Quotation 클래스를 매개변수로 넣은 List의 인스턴스 quotations 선언

    App(){
    // App 생성자 선언

        scanner = new Scanner(System.in);
        // Scanner 클래스의 기능을 사용할 수 있는 scanner 객체 생성

        lastQuotationId = 0;
        // 명언의 횟수를 저장하는 lastQuotationId 변수를 0으로 초기화

        quotations = new ArrayList<>();
        // ArrayList의 생성자로 인하여 인스턴스 quotations 생성 및 초기화
    }
    void run() {
    // 반환 값이 없는 void를 반환 유형으로 한 run 메서드 선언\

        System.out.println("== 명언 앱 ==");
        // == 명언 앱 == 출력 후 줄 바꿈

        while(true) {
        // 항상 참인 조건을 가진 무한 루프

            System.out.print("명령) ");
            // 명령) 출력

            String cmd = scanner.nextLine();
            // scanner 인스턴스로 Scanner 클래스에서 제공되는 nextLine 메서드를 호출하여 리턴 값을 문자열 변수 cmd에 대입

            if (cmd.equals("종료")){
            // 두 객체가 내용이 같은지 비교할 떄 사용되는 equals 메서드를 사용하여 입력된 cmd 변수가 종료와 같으면

                break;
                // 해당 조건문을 탈출

            }
            else if (cmd.equals("등록")) {
            // 두 객체가 내용이 같은지 비교할 떄 사용되는 equals 메서드를 사용하여 입력된 cmd 변수가 등록과 같다는 다른 조건이면

                actionWrite();
                // actionWrite 메서드 호출

            }
            else if (cmd.equals("목록")){
            // 두 객체가 내용이 같은지 비교할 떄 사용되는 equals 메서드를 사용하여 입력된 cmd 변수가 목록과 같다는 다른 조건이면

                actionList();
                // actionList() 메서드 호출
            }
            else if (cmd.startsWith("삭제?")){
            // 특정 문자열로 시작되는지 확인하는 startsWith 메서드를 사용하여 입력된 cmd 변수가 삭제?로 시작하는 다른 조건이면
                
                actionRemove(cmd);
                // cmd를 인수로 하는 actionRemove 메서드 호출
            }
            else if (cmd.startsWith("수정?"))
            // 특정 문자열로 시작되는지 확인하는 startsWith 메서드를 사용하여 입력된 cmd 변수가 수정?로 시작하는 다른 조건이면

                actionModify(cmd);
                // cmd를 인수로 하는 actionModify 메서드 호출
        }
    }

    void actionWrite(){
    // 리턴 값이 없는 void 형 actionWrite() 메서드 선언

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

        int id = lastQuotationId;
        // +1이 된 lastQuotationId 변수를 작가와 명언의 번호를 저장하는 id 변수에 대입

        Quotation quotation = new Quotation(id, content, authorName);
        // id, content, authorName을 매개변수로 하는 Quotation 생성자를 이용하여 Quotation 클래스의 기능을 사용할 수 있는 인스턴스 quotation 생성 및 id, content, authorName 초기화

        quotations.add(quotation);
        // Quotation 리스트의 add 메서드를 이용하여 번호, 내용, 작가가 초기화된 인스턴스 quotation를 리스트의 마지막 원소로 추가

        System.out.printf("%d번 명언이 등록되었습니다.\n", lastQuotationId);
        // Quotation 클래스의 기능을 사용할 수 있는 quotation 객체 생성 및 id, content, authorName 초기화

    }

    void actionList(){
    // 리턴값이 없는 void 형 actionList() 메서드 선언

        System.out.println("번호 / 작가 / 명언");
        // 번호 / 작가 / 명언 출력 후 줄 바꿈

        System.out.println("------------------");
        // ------------------ 출력 후 줄 바꿈

        if(quotations.isEmpty())
        // 참조 변수 quotations의 데이터의 존재 여부를 확인하여 데이터가 하나도 없을 때만 true를 리턴하는 isEmpty() 메서드 호출시

            System.out.println("등록된 명언이 없습니다.");
            // 데이터가 하나도 없어 true 값을 리턴하면 "등록된 명언이 없습니다." 출력

        for(int i = quotations.size() - 1; i >= 0; i--){
        // 인스턴스 quotations의 리스트 객체 내에 포암된 원소의 개수를 호출하는 size() 메서드 -1을 대입한 int 형 변수 i를 초기화하여 0보다 크면 아래 코드를 수행 후 i 값을 -1

            Quotation quotation = quotations.get(i);
            // 인스턴스 quotations의 인덱스 위치의 원소값을 꺼내 리턴하는 get() 메서드를 이용하여 호출된 값을 인스턴스 quotation에 대입

            System.out.printf("%d / %s / %s\n", quotation.id, quotation.authorName, quotation.content);
            // 참조 변수 quotation에 명언을 저장하는 정수형 필드 id,작가 이름을 저장하는 문자형 필드 content,작가 이름을 저장하는 authorName 필드에 각각 접근하여 정수 출력 형식 %d, 문자열 출력 형식 %s에 각각 대입하여 출력
        }
    }

    void actionRemove(String cmd){
    // 문자열 변수 cmd를 매개변수로 하는 리턴 값이 없는 void 형 actionRemove 메서드 선언

        int id = getParamAsInt(cmd, "id", 0);
        // cmd, paranName은 "id", defaultValue를 0으로 하여 getParamAsInt 메서드를 호출한 후 리턴 값을 정수형 변수 id에 대입

        if (id == 0){
        // id가 0이면

            System.out.println("id를 정확히 입력해주세요.");
            // "id를 정확히 입력해주세요." 출력

            return;
            // if 조건문을 종료하고 호출한 getParamAsInt 메서드로 이동
        }
        System.out.printf("%d번 명언을 삭제합니다.\n", id);
        // id가 0이 아니면 0이 아닌 id를 정수 출력 형식인 %d에 대입한 "%d번 명언을 삭제합니다." 출력 후 줄 바꿈
    }

    void actionModify(String cmd){
    // 문자열 변수 cmd를 매개변수로 하는 리턴 값이 없는 void 형 actionModify 메서드 선언

        int id = getParamAsInt(cmd, "id", 0);
        // cmd, paranName은 "id", defaultValue를 0으로 하여 getParamAsInt 메서드를 호출한 후 리턴 값을 정수형 변수 id에 대입

        if (id == 0){
        // id가 0이면

            System.out.println("id를 정확히 입력해주세요.");
            // "id를 정확히 입력해주세요." 출력

            return;
            // actionModify() 메서드를 종료하고 호출한 곳으로 이동
        }

        System.out.printf("%d번 명언을 수정합니다.\n", id);
        // id가 0이 아니면 0이 아닌 id를 정수 출력 형식인 %d에 대입한 "%d번 명언을 수정합니다." 출력 후 줄 바꿈
    }
    int getParamAsInt(String cmd, String paramName, int defaultValue){
    // 문자열 변수 cmd, paramName, 정수형 변수 defaultValue를 매개변수로 하는 getParamAsInt 매서드 선언

        String[] cmdBits = cmd.split("\\?", 2);
        // 문자열 변수 cmd를 구분자를 기준으로 문자열을 잘라 배열로 입력할 떄 사용하는 split() 메서드를 이용하여
        // 정규표현식 regex인 \\?를 기준으로 limit 크기 2만큼 잘려진 수들을 문자열 배열 변수 cmdBits에 대입

        String queryString = cmdBits[1];
        // cmdBits[1]을 문자열 변수 queryString에 대입

        String[] queryStringBits = queryString.split("&");
        // 문자열 변수 queryString을 구분자를 기준으로 문자열을 잘라 배열로 입력할 떄 사용하는 split() 메서드를 이용하여
        // 정규표현식 regex인 & 기준으로 잘려진 수들을 문자열 배열 변수 queryStringBits에 대입

        for (int i = 0; i < queryStringBits.length; i++){
        // 0으로 초기화된 정수형 변수 i가 문자열 배열 queryStringBits 변수의 길이를 나타내는 length 속성보다 작으면 아래 코드를 실행하고 i값을 +1

            String queryParamStr = queryStringBits[i];
            // 배열 크기가 i인 문자열 배열 queryStringBits 변수를 문자열 변수 queryParamStr에 대입

            String[] queryParamStrBits = queryParamStr.split("=", 2);
            // 문자열 변수 queryParamStr를 구분자를 기준으로 문자열을 잘라 배열로 입력할 떄 사용하는 split() 메서드를 이용하여
            // 정규표현식 regex인 = 기준으로 limit 크기 2만큼 잘려진 수들을 문자열 배열 변수 queryParamStrBits에 대입

            String _paramName = queryParamStrBits[0];
            // 배열 크기가 0인 문자열 배열 queryParamStrBits를 문자열 변수__paramName에 대입

            String paramValue = queryParamStrBits[1];
            // 배열 크기가 1인 문자열 배열 queryParamStrBits를 문자열 변수 paramValue에 대입

            if(_paramName.equals(paramName)){
            // 두 객체가 내용이 같은지 비교할 떄 사용되는 equals 메서드를 사용하여 입력된 cmd 변수가 종료와 같으면

                try{
                // 예외 발생시 처리

                    return Integer.parseInt(paramValue);
                    // 문자열 변수 paramValue를 인자로 받아 파싱하여 정수로 반환하는 Integer.parseInt() 메서드를 사용하여 리턴

                }
                catch (NumberFormatException e) {
                // 문자열을 숫자 또는 실수로 변환할 떄 문자열이 변환하고자 하는 숫자 형식이 아니면 반환이 실패 할때 발생하는 실행 예외인 NumberFormatException 발생시 처리

                    return defaultValue;
                    // 정수형 변수 defaultValue 리턴
                }
            }
        }
        return defaultValue;
        // 정수형 변수 defaultValue 리턴
    }
}

