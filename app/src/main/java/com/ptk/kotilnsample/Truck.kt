package com.ptk.kotilnsample

// 코틀린은 타입 캐스팅을 'as'연산자로 사용한다.
// 'as' 연산자 역시 타입 캐스팅을 시도한 대상의 값을 지정한 타입으로 변환 할 수 없는 경우,
// Java 에서와 같이 'ClassCastException'이 발생한다.

// 클래스 캐스트를 할 때마다 'is' 연산자로 캐스팅이 가능한지 확인할 수도 있지만,
// 코틀린의 'as?' 연산자를 사용하면 조금 더 편리하고 안전하게 캐스팅을 할 수 있다.
class Truck(val id: Int, val name: String) {

    // equals 를 오버라이드 함. id 가 같으면 같은 객체로 취급
    override fun equals(other: Any?): Boolean {
        // as? 연산자를 사용하면 타입이 같은경우 캐스팅이 정상적으로 되고
        // 캐스팅이 실패하면 null 이 반환된다
        // null 이 반환된 경우 엘비스 연산자의 디펄트 식이 실행되어 false 가 리턴된다.
        val otherTruck = other as? Truck ?: return false

        // otherTruck 은 스마트 캐스팅 되어 널 을 신경 쓸 필요가 없다.
        return otherTruck.id == id
    }
}

// 타입 캐스팅을 시도할 때 타입이 맞는 경우엔 스마트 캐스팅이 되고, 만일 실패하면 널이 반환되므로
// 엘비스 연산자가 실해오디어 함수에서 'false'를 반환한다.