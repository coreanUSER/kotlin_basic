package com.ptk.kotilnsample

// 이름을 생성자로 받는 것을 표현
class Person(val name: String) {
    // 코틀린에서 'var'로 선언된 변수는 Getter, Setter 가 전부 생성되고,
    // 'val'로 선언된 변수는 Getter 만 선언됩니다.

    // 나이
    var age: Int = 0

    // 닉네임 - 소문자만 허용
    // 코틀린은 프로퍼티에서 자동으로 Getter, Setter 가 생성되지만, 필요한 코드를 추가해 특정 기능을 구현할 수 있습니다.

    // 코틀린은 클래스의 프로퍼티 접근자인 'Getter'와 'Setter'를 기본적으로 자동 생성하고, 필요한 경우에만 코드를 작성하게 하는 것
    var nickname: String = ""
        set(value) {
            // field 는 Setter 의 대상이 되는 field 를 의미
            // field 는 Setter 메소드 내의 '값을 적용할 영역'
            // this.nickname 은 setNickname() 을 호출해 재귀호출이 된다. -> StackOverFlow 의 원인
            field = value.toLowerCase()
        }
}