package com.ll.domain;
// 패키지는 자바 클래스를 모아놓은 폴더

import com.ll.standard.util.Ut;

import java.util.HashMap;
import java.util.Map;
// Map은 key와 value 값을 연결 지어 저장하는 매핑을 나타내는 인터페이스

public class Rq {
// Rq 클래스 선언

    private String cmd;
    // 문자열 필드 cmd 선언

    private String action;
    // 문자열 필드 action 선언

    private String queryString;
    // 문자열 필드 queryString 선언

    private Map<String, String> paramsMap;
    // key와 value가 문자열인 paramsMap 객체 선언

    public Rq(String cmd) {
        // 문자열 객체 cmd를 매개변수로 하는 Rq 생성자

        paramsMap = new HashMap();
        // HashMap 생성자를 이용하여 생성 및 초기화된 객체 paramsMap 객체에 대입

        this.cmd = cmd;
        // 입력 매개변수로 전달된 정수형 필드 cmd를 자신이 포함된 Rq 클래스의 객체를 가리키는 this.cmd 필드에 대입

        String[] cmdBits = cmd.split("\\?", 2);
        // 문자열 변수 cmd를 구분자를 기준으로 문자열을 잘라 배열로 입력할 떄 사용하는 split() 메서드를 이용하여 정규표현식 regex인 \\?를 기준으로 limit 크기 2만큼 잘려진 수들을 문자열 배열 변수 cmdBits에 대입

        action = cmdBits[0].trim();
        // 문자열의 앞뒤 공백을 제거하는 trim() 메서드를 이용하여 문자열 배열 변수 cmdBits의 0번째에 대입된 문자열의 앞뒤 공백을 제거하여 문자열 필드 action에 대입

        if (cmdBits.length == 1) {
            // 문자열 배열 변수 cmdBits의 길이가 1이면

            return;
            // switch 반복문을 종료하고 호출한 장소로 이동
        }

        queryString = cmdBits[1].trim();
        // 문자열의 앞뒤 공백을 제거하는 trim() 메서드를 이용하여 문자열 배열 변수 cmdBits의 1번째에 대입된 문자열의 앞뒤 공백을 제거하ㅣ여 문자열 필드 queryString에 대입

        String[] queryStringBits = queryString.split("&");
        // 문자열 필드 QueryString의 구분자를 기준으로 문자열을 잘라 배열로 입력할 떄 사용하는 split() 메서드를 이용하여 정규표현식 regex인 \\?를 기준으로 limit 크기 2만큼 잘려진 수들을 문자열 배열 변수 cmdBits에 대입

        for (int i = 0; i < queryStringBits.length; i++) {
            // 0으로 초기화된 정수형 변수 i가 문자열 배열 queryStringBits의 길이보다 작으면 아래 코드를 실행하고 i를 +1

            String queryParamStr = queryStringBits[i];
            // queryStringBits 배열의 i번쨰에 대입된 값을 문자열 배열 변수 queryParamStr에 대입

            String[] queryParamStrBits = queryParamStr.split("=", 2);
            // 문자열 필드 queryParamStr의 구분자를 기준으로 문자열을 잘라 배열로 입력할 떄 사용하는 split() 메서드를 이용하여 정규표현식 regex인 =를 기준으로 limit 크기 2만큼 잘려진 수들을 문자열 배열 변수 queryParamStrBits 대입

            String paramName = queryParamStrBits[0];
            // queryParamStrBits 0번째에 대입된 값을 문자열 변수 paramName에 대입

            String paramValue = queryParamStrBits[1];
            // queryParamStrBits 0번째에 대입된 값을 문자열 변수 paramValue에 대입

            paramsMap.put(paramName, paramValue);
            // Key와 Value를 Map에 삽입시키는 put() 메서드를 이용하여 paramsMap 객체 안의 메서드를 활용

        }
    }

    public String getAction() {
        // 문자열을 리턴하는 getAction()  메서드 선언

        return action;
        // 문자열 변수 action을 함수를 호출한 장소로 이동하고 메서드 종료
    }

    public int getParamAsInt(String paramName, int defaultValue) {
        // 문자열 변수 paramName과 정수형 변 수 defaultValue를 매개변수로 정수형을 리턴하는 getParamAsInt 선언
        return Ut.str.parseInt(paramsMap.get(paramName), defaultValue);
    }
}