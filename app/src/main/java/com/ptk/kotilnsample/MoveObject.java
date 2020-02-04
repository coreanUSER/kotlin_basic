package com.ptk.kotilnsample;

// '구현 상속'과 '인터페이스 상속'의 주요 차이점 중 또 하나는 인터페이스 상속은 다중 상속에서 자유롭지 못하지만,
// 구현 상속은 다중 상속을 하는 경우 문제점이 생긴다는 것이다.
// 구현 상속은 실제 코드가 포함되어 있기 때문에 만약 상속받는 2개의 클래스에 똑같은 이름의 메소드가 있다면 어느 메소드를 호출해야 하는 지 애매하다.
// 반면 인터페이스 상속은 구현되어 있는 코드가 없으므로 직접 구분지어 새로 정의를 해야 한다.

// 구현 상속은 클래스 설계각 복잡해질 때 다양한 문제점이 생겨나는데, 보통 'fragile base class'라고 불리운다.
// 이 문제는 '상속'을 사용하는 언어들이 대부분 갖고 있는 문제이다.
// '취약한 기반 클래스 문제(fragile base class)'는 하위 클래스에서 상위 클래스의 메소드를 오버라이딩하면서 발생하게 되는데,
// 그 이유는 클래스를 사용하는 코드에서는 클래스의 실제 구현에는 관심을 가지지 않아야 하기 때문이다.

// 이동 가능한 객체
// 클래스 자체를 상속 불가능하게 하려면, class 에 'final' 키워드를 붙이면 된다.
public class MoveObject {
    // 이동 스피드
    protected int speed;

    // Java 에서 상속을 김지하려면, 메소드에 'final'을 붙이면 된다.
    // 상속불가
    final public void addSpeed(int param){
        this.speed = speed + param;
    }

    final public int getSpeed() {
        return speed;
    }

    // 좌표
    int x, y;
}
