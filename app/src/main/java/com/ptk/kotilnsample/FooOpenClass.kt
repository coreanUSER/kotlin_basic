package com.ptk.kotilnsample

// 코틀린에서 상속을 허용하려면 'open' 키워드를 사용한다.
// open 키워드는 상속을 허영한다는 의미이다.

open class FooOpenClass {
    var property1 = 0

    // 메소드는 기본적으로 final 이고 오버라이드 불가하다.
    fun disable() {}

    // open 키워드로 메소드 역시 상속가능하게 변경할 수 있다.
    open fun animate() {}

    // 오버라이드 된 메소드는 하위 클래스에도 열려있다.
    override fun toString(): String {
        return super.toString()
    }

    // 코틀린에서 클래스의 메소드는 기본적으로 'final' 상태이기 때문에 클래스뿐만 아니라 메소드 역시
    // open 처리를 해야 오버라이드할 수 있다는 것을 기억하자.

    // 코틀린은 오버라이드하는 함수에 대해서는 반드시 'override' 키워드를 사용해야 한다.
}