package com.ptk.kotilnsample;

// 이런 식의 상속은 객체 지향의 주요 개념들을 위반하게 된다.
public class CantMoveObject extends MoveObject{

    // 생성자에서 speed 를 0 으로 만듬.
    public CantMoveObject() {
        this.speed = 0;
    }

    // addSpeed 메소드를 오버라이드 함
//    @Override
//    public void addSpeed(int param) {
////        // 움직일 수 없는 오브젝트이므로 아무것도 하지 않음
////    }
}
