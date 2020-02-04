package com.ptk.kotilnsample;

// '인터페이스 상속'은 Java에서 'implements' 키워드를 사용하며, 코드 구현이 아닌 '메소드의 집합'을 상속받는다.
// '인터페이스 상속'은 '인터페이스'를 사용하는 객체에서 인터페이스에 정의한 코드를 신경 쓰지 않고 호출할 수 있도록 하는데에 의의가 있다.
// 인터페이스를 사용하는 입장에서는 메소드의 실제 구현을 신경쓰지 않고 사용할 수 있게 해주는 것이다.
public interface SampleInterface {
    void plus(int a, int b);
}
