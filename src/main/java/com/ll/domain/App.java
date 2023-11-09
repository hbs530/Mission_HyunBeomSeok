package com.ll.domain;
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
    private Scanner scanner;
    // Scanner 클래스의 scanner 인스턴스 선언
    private int lastQuotationId;
    // 명언의 횟수를 저장하는 lastQuotationId 변수 선언
    private List<Quotation> quotations;
    // Quotation 클래스를 매개변수로 넣은 List의 인스턴스 quotations 선언

    public App() {
    // App 생성자 선언

        scanner = new Scanner(System.in);
        // Scanner 클래스의 기능을 사용할 수 있는 scanner 객체 생성

        lastQuotationId = 0;
        // 명언의 횟수를 저장하는 lastQuotationId 변수를 0으로 초기화

        quotations = new ArrayList<>();
        // ArrayList의 생성자로 인하여 인스턴스 quotations 생성 및 초기화
    }

    public void run() {
    // 반환 값이 없는 void를 반환 유형으로 한 run 메서드 선언\

        System.out.println("== 명언 앱 ==");
        // == 명언 앱 == 출력 후 줄 바꿈

        while (true) {
        // 항상 참인 조건을 가진 무한 루프

            System.out.print("명령) ");
             // 명령) 출력

            String cmd = scanner.nextLine();
            // scanner 인스턴스로 Scanner 클래스에서 제공되는 nextLine 메서드를 호출하여 리턴 값을 문자열 변수 cmd에 대입

            Rq rq = new Rq(cmd);
            // 문자열 변수 cmd를 매개변수로 하는 Rq 생성자로 인하여 rq 객체 생성 및 초기화

            switch (rq.getAction()) {
            // 참조 변수 rq가 가리키는 곳의 객체 안에 있는 메서드인 getAction() 호출 하면

                case "종료":
                // 인스턴스 rq의 getAction 메서드의 리턴 값이 "종료"와 동일하면

                    return;
                    // switch 조건문을 종료하고 메서드를 호출한 장소인 인스턴스 rq의 getAction 메서드로 이동

                case "등록":
                // 인스턴스 rq의 getAction 메서드의 리턴 값이 "등록"과 동일하면

                    actionWrite();
                    // actionWrite 메서드 호출

                    break;
                    // swtich 조건문을 탈출

                case "목록":
                // 인스턴스 rq의 getAction 메서드의 리턴 값이 "목록"과 동일하면

                    actionList();
                    // actionList 메서드 호출

                    break;
                    // swtich 조건문을 탈출

                case "삭제":
                // 인스턴스 rq의 getAction 메서드의 리턴 값이 "삭제"와 동일하면

                    actionRemove(rq);
                    // 인스턴스 rq를 인수로 하는 actionRemove 메서드 호출

                    break;
                    // switch 조건문을 탈출

                case "수정":
                // 인스턴스 rq의 getAction 메서드의 리턴 값이 "수정"과 동일하면

                    actionModify(rq);
                    // 인스턴스 rq를 인수로 하는 actionRemove 메서드 호출

                    break;
                    // switch 조건문을 탈출
            }
        }
    }

    private void actionWrite() {
    // 리턴 값이 없는 void 형 actionWrite() 메서드 선언
        System.out.print("명언 : ");
        String content = scanner.nextLine();

        System.out.print("작가 : ");
        String authorName = scanner.nextLine();

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

    private void actionList() {
    // 리턴값이 없는 void 형 actionList() 메서드 선언

        System.out.println("번호 / 작가 / 명언");
        // 번호 / 작가 / 명언 출력 후 줄 바꿈

        System.out.println("----------------------");
        // ------------------ 출력 후 줄 바꿈

        if (quotations.isEmpty())
        // 참조 변수 quotations의 데이터의 존재 여부를 확인하여 데이터가 하나도 없을 때만 true를 리턴하는 isEmpty() 메서드 호출시

            System.out.println("등록된 명언이 없습니다.");
            // 데이터가 하나도 없어 true 값을 리턴하면 "등록된 명언이 없습니다." 출력 후 줄 바꿈

        for (int i = quotations.size() - 1; i >= 0; i--) {
        // 인스턴스 quotations의 리스트 객체 내에 포암된 원소의 개수를 호출하는 size() 메서드를 호출 한 후의 리턴 값에서
        // -1을 대입한 int 형 변수 i를 초기화하여 0보다 크면 아래 코드를 수행 후 i 값을 -1

            Quotation quotation = quotations.get(i);
            // 인스턴스 quotations의 인덱스 위치의 원소값을 꺼내 리턴하는 get() 메서드를 이용하여 호출된 값을 인스턴스 quotation에 대입

            System.out.printf("%d / %s / %s\n", quotation.id, quotation.authorName, quotation.content);
            // 참조 변수 quotation에 명언을 저장하는 정수형 필드 id,작가 이름을 저장하는 문자형 필드 content,
            // 작가 이름을 저장하는 authorName 필드에 각각 접근하여 정수 출력 형식 %d, 문자열 출력 형식 %s에 각각 대입하여 출력
        }
    }

    private void actionRemove(Rq rq) {
    // Rq 클래스의 rq 인스턴스를 인수로 하는 리턴 값이 없는 void 형 actionRemove() 메서드 선언

        int id = rq.getParamAsInt("id", 0);
        // 문자열 변수 paramName은 "id", 정수형 변수 defaultvalue는 0을 인수로 하는
        // rq 인스턴스의 getParamAsInt() 메서드를 호출 한 후 리턴 값을 정수 형 변수 id에 대입

        if (id == 0) {
        // id가 0이면

            System.out.println("id를 정확히 입력해주세요.");
            // "id를 정확히 입력해주세요." 출력 후 줄 바꿈

            return;
            // if 조건문을 종료하고 호출한 장소로 이동
        }

        int index = findQuotationIndexById(id);
        // 정수형 변수 id를 인수로 하는 getIndexOfQuotationById 메서드를 호출 후 리턴 값을 정수형 변수 index에 대입

        if (index == -1) {
        // 정수형 변수 index가 -1이면

            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
            // 정수형 변수 id를 정수 출력 형식 %d에 대입하여 "%d번 명언은 존재하지 않습니다." 출력 후 줄 바꿈

            return;
            // if 조건문을 종료하고 호출한 장소로 이동
        }

        quotations.remove(index);
        // 인스턴스 quotations의 정수형 변수 인덱스 값을 삭제하는 remove 리스트 메서드를 호출
        
        System.out.printf("%d번 명언을 삭제되었습니다.\n", id);
        // 정수형 변수 id를 정수 출력 형식 %d에 대입하여 "%d번 명언을 삭제되었습니다." 출력 후 줄 바꿈
    }

    private int findQuotationIndexById(int id) {
    // 정수형 변수 id를 매개변수로 하는 getInOfQuotationById() 메서드 선언

        for (int i = 0; i < quotations.size(); i++) {
        // 0으로 초기화된 정수형 변수 i가 인스턴스 quotations의 리스트 객체 내에 포함된
        // 원소의 갯수를 나타내는 size 리스트 메서드 보다 작으면 아레 코드를 실행하고 i변수 +1

            Quotation quotation = quotations.get(i);
            // 인스턴스 quotations의 인덱스 위치의 원소값을 꺼내 리턴하는
            // get() 메서드를 호출한 후 리턴 값을 인스턴스 quotation에 대입

            if (quotation.id == id) {
            // 인스턴스 quotation의 정수형 필드 id가 입력된 id와 같다면

                return i;
                // 정수형 필드 i를 메서드를 호출한 quotations.get(i)로 이동하고 메서드 종료
            }
        }

        return -1;
        // 관용적으로 함수의 오류 발생시 -1을 메서드를 호출한 quotations.size()로 이동하고 메서도 종료
    }

    private void actionModify(Rq rq) {
    // rq를 매개변수로 하여 리턴 값이 없는 void 형 run() 메서드 선언

        int id = rq.getParamAsInt("id", 0);
        // 문자열 변수 paramName은 "id", 정수형 변수 defaultvalue는 0인 getParamAsInt() 메서드에 접근한 rq 객체를 정수형 변수 id에 대입

        if (id == 0) {
        // 정수형 변수 id가 0이면

            System.out.println("id를 정확히 입력해주세요.");
            // "id를 정확히 입력해주세요." 출력 후 개행 표시

            return; // 함수를 끝낸다.
            // 메서드를 호출한 장소로 이동하고 메서드 종료
        }

        int index = findQuotationIndexById(id);
        // 정수형 id 변수를 인수로 하는 findQuotationIndexById .메서드를 호출 후 리턴 값을 정수형 변수 index에 대입

        if(index == -1){
        // 정수형 변수 index가 명언이 존재 하지 않음을 나타내는 임의의 수인 -1인 조건 이면
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
            //정수형 id 변수를 정수값을 형식화하여 출력할 떄 사용하는 형식 지정자 %d에 대입하여 "%d번 명언은 존재하지 않습니다" 출력

            return;
            // 조건문 종료
        }

        Quotation quotation = quotations.get(index);
        // 정수형 변수 index를 인자로 하여 index의 위치에 해당 하는 값을 반환하는데 사용하는 get 메서드 리턴 값을 인스턴스 quotation에 대입

        System.out.printf("명언(기존) : %s\n", quotation.content);
        // 인스턴스 quotation의 문자열 필드 content에 접근하여 나온 값을 문자열 값을 형식화하여 출력할 떄 사용하는 형식 지정자 %s에 대입하여
        // "명언(기존) : %s"을 출력한 후 프로그래밍 언어 특정상 표현할 수 없는 기능, 문자를 표현 해주는 이스케이프 시퀸스 중 하나인 \n로 줄 바꿈

        System.out.print("명언 : ");
        // 명언 : 출력

        String content = scanner.nextLine();
        // scanner 인스턴스로 Scanner 클래스에서 제공되는 nextLine 메서드를 호출하여 리턴 값을 문자열 필드 authorName에 대입

        System.out.printf("작가(기존) : %s\n", quotation.authorName);
        // 인스턴스 quotation의 문자열 필드 authorName에 접근하여 나온 값을 문자열 값을 형식화하여 출력할 떄 사용하는 형식 지정자 %s에 대입하여
        // "작가(기존) : %s"을 출력한 후 프로그래밍 언어 특정상 표현할 수 없는 기능, 문자를 표현 해주는 이스케이프 시퀸스 중 하나인 \n로 줄 바꿈

        System.out.print("작가 : ");
        // 작가 : 출력

        String authorName = scanner.nextLine();
        // scanner 인스턴스로 Scanner 클래스에서 제공되는 nextLine 메서드를 호출하여 리턴 값을 문자열 authorName 필드에 대입

        quotation.content = content;
        // 수정된 명언를 인스턴스 quotation의 필드 content에 대입하여 갱신
        quotation.authorName = authorName;
        // 수정된 작가를 인스턴스 quotaiton의 필드 authorName에 대입하여 갱신

        System.out.printf("%d번 명언을 수정되었습니다.\n", id);
        // id가 0이 아니면 0이 아닌 id를 정수 출력 형식인 %d에 대입한 "%d번 명언을 삭제합니다." 출력 후 줄 바꿈
    }
}