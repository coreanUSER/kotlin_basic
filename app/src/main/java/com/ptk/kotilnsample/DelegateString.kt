package com.ptk.kotilnsample

import kotlin.reflect.KProperty

// 코틀린은 '클래스'뿐 아니라 '프로퍼티'에 대해서도 위임을 제공한다.
// 코틀린의 '프로퍼티 위임'은 Getter, Setter 연산자를 위임할 수 있게 해주며, 매우 유용한 3가지 방법을 제공한다.
// 1. lazy properties : 값의 초기화를 처음 프로퍼티를 사용할 때 초기화한다.
// 2. observable properties : 프로퍼티에 값이 변경되면 옵저버에게 알려준다.
// 3. storing properties : 필드가 아닌 맴에 속성을 저장한다.

// 코틀린은 'Custom Getter, Setter'를 활용하여 자동으로 생성되는 Getter, Setter 를 얼마든지 변경할 수도 있지만,
// 종종 여러 클래스에서 같은 동작을 해야 할 경우 '위임'을 사용하면 보다 편리하다.
class DelegateString {
    // Setter 에서 호출된 값을 저장할 변수
    var text = ""

    // 'operator' 키워드는 '연산자'를 의미하며, getValue(), setValue() 함수 앞에 operator 키워드를 붙인 것은
    // 'Getter, Setter' 메소드가 연산자로 취급되기 때문이다.
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return text;
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        // 대문자로 변경하여 저장
        text = value.toUpperCase()
        // Setter 에 호출될 때의 문자열과 변경 후 문자열을 프린트
        println("$value ==> ${text}")
    }
}

// 프로퍼티 위임 클래스 요구사항
// 코틀린은 var 로 선언된 변수와 val 로 선언된 변수의 Getter, Setter 가 다르기 때문에
// 프로퍼티 위임 클래스를 만들기 위한 몇가지 규칙이 있다.
// 먼저 var 로 선언된 변수의 경우에는 setValue(), getValue() 메소드를 모두 구현해준다.
// val 로 선언된 변수의 경우에는 getValue() 메소드만 구현해준다.

// 예)
// 읽기 전용 속성 - val 로 선언된 속성
// interface ReadOnlyProperty<in R, out T> {
//      operator fnt getValue(thisRef: R, property: KProperty<*>): T
// }

// 읽고 쓰기 전용 속성 - var 로 선언된 속성
// interface ReadOnlyProperty<in R, T> {
//      operator fnt getValue(thisRef: R, property: KProperty<*>): T
//      operator fnt setValue(thisRef: R, property: KProperty<*>, value: T)
// }