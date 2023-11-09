package com.ll;
// 패키지는 자바 클래스를 모아놓은 폴더

import com.ll.domain.App;

public class Main {
    public static void main(String[] args) {
        new App().run();
        // App 클래스의 새로운 인스턴스를 생성하고 즉시 그 인스턴스에 있는 run 메소드를 호출
    }
}