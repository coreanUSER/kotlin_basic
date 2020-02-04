package com.ptk.kotilnsample;

// '싱글턴(Singleton)' 패턴은 객체의 생성을 제한하여 한 개의 인스턴스만 생성도도록 하며,
// 생성된 객체에 접슨할 수 있는 방법을 공개하여 누구나 객체를 사용할 수 있도록 하는 것
public class SingletonJava {

    // 생성자를 private 로 감춘다
    private SingletonJava(){}

    // 생성된 객체를 private 로 감추고 프로그램이 시작할 때 초기화한다.
    // 인스턴스 생성방법은 처음 사용할 때 초기화하는 방법, 쓰레드 동기화 방법 등 다양한 방법이 있다.
    // 자세한 것은 디자인 패턴 관련 서적 참고.
    private static SingletonJava instanse = new SingletonJava();

    // 외부에서 생성된 instanse 에서 접근할 수 있는 방법을 제공
    public static SingletonJava getInstance(){
        return instanse;
    }

    public void log(String text){
        System.out.println(text);
    }
}
