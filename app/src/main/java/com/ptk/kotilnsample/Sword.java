package com.ptk.kotilnsample;

// '객체 지향에서 위임'이란 클래스의 특정 기능들을 대신 처리해주는 것을 말한다.
// 클래스를 상속하지 않고 기존 클래스의 일부 메소드를 변경하거나 새로운 기능을 확장하고자 할 때 사용할 수 있는 것이 '위임'이다.

// 위임을 사용하는 대표적인 패턴에는 데코레이터(Decorator) 패턴이 있다.
// '데코레이터 패턴'은 그 이름처럼 특정 클래스의 기능에 추가 기능을 덧붙이는 방법이다.
public final class Sword implements ISword {
    // 검의 이름
    String name;

    // 생성자에서 이름을 받는다.
    public Sword(String name) {
        this.name = name;
    }

    // 장착시 불리는 메소드
    public void equip(){
        System.out.println(name + " 이 장착되었습니다.");
    }
}
