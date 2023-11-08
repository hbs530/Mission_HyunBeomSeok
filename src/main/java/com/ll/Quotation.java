package com.ll;
// 패키지는 자바 클래스를 모아놓은 폴더
public class Quotation {
// Quotation 클래스 선언

    int id;
    // 작가와 명언의 번호를 저장하는 정수형 필드 id 선언

    String content;
    // 명언을 저장하는 문자형 필드 content 선언

    String authorName;
    // 작가를 저장하는 문자형 필드 authorName 선언

    public Quotation(int id, String content, String authorName){
        // 정수형 필드 id, 문자형 필드 content, authorName을 입력 매개 변수로 전달 하는 Quotation 생성자 선언

        this.id = id;
        // 입력 매개변수로 전달된 정수형 필드 id를 자신이 포함된 Quotation 클래스의 객체를 가리키는 this.id 필드에 대입

        this.content = content;
        // 입력 매개변수로 전달된 문자형 필드 content를 자신이 포함된 Quotation 클래스의 객체를 가리키는 this.content 필드에 대입

        this.authorName = authorName;
        // 입력 매개변수로 전달된 문자형 필드 authorName를 자신이 포함된 Quotation 클래스의 객체를 가리키는 this.authorName 필드에 대입
    }
}