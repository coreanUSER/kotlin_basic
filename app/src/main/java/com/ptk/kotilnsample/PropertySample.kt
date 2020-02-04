package com.ptk.kotilnsample

// 코틀린의 프로퍼티는 결국 '접근자(Getter, Setter)'에 의해 정의된다.
// 프로퍼티가 접근자에 의해 결정된다면 Field가 필요할까?

// 아래 코드에서 'name' 프로퍼티는 'name'이라는 필드가 있어도 필드의 값가 전혀 상관없이 동작하고 있다.
// Setter 에서는 print() 함수를 호출할 뿐이고, Getter 에서는 무조건 "Alice"라는 문자열을 반환하기 때문에
// 결국, Field 값은 아무런 의미가 없다.

// 코틀린은 프로퍼티의 이름을 사용하는 경우, 자동으로 Getter, Setter 가 호출되기 때문에 실제로 Field 가 전혀 필요하지 않다.
// 이것이 포틀린이 프로퍼티를 대하는 기본사상이다.

// '필드(Field)' 대신 프로퍼티를 사용하며, 그 프로퍼티를 제어할 수 있는 '접근자'만 제공한다.
class PropertySample {
    var name: String
        // Setter 에서는 print 함수를 호출한다.
        set(value: String) {
            print("sest")
        }
        // 무조건 "Alice" 문자열을 반환한다.
        get(): String {
            return "Alice"
        }

    // 코틀린은 클래스 내부에서도 멤버 변수를 이름으로 직접 접근할 수 없다.
    // 코틀린은 Field 를 사요하지 않기 때문이다.

    // 프로퍼티의 Getter, Setter 에서도 코틀린은 Field 를 사용하지 않기 때문에 프로퍼티의 이름은 결국 Getter, Setter 가 호출되어 버린다. -> 무한히 반복됨 -> StackOverflow
    // 프로퍼티의 '이름'이 아닌 'field'라는 키워드로 프로퍼티의 '값'에 접근할 수 있다.
    // 이렇게 '접근자(Getter, Setter)'에서 field 키워드로 사용되는 개념을 '프로퍼티를 뒷파침하는 필드'라는 의미의 'Backing Field'라 부른다.
    // Backing Field 는 클래스 내부의 접근자에서만 사용 가능하다.

    // 코틀린은 Field 를 사용하지 않음으로써 '속성 위임'이나 '인터페이스에 프로퍼티 추가' 등을 할 수 있다.
    var nickname: String = ""
        set(value: String) {
            field = value.toLowerCase()
        }
}