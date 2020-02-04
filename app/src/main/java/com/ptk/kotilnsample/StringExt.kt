package com.ptk.kotilnsample

// 확장함수 : 실제로 클래스의 메소드는 아니지만, 클래스 외부에서 선언하고 마치 클래스의 메소드처럼 사용하는 것
// 이미 정의된 클래스를 전혀 수정하지 않고도 클래스에 포함된 함수처럼 사용할 수 있게 하는 역할
// Java API 와 라이브러리 코드를 변경하지 않고도, 코틀린으로 만든 새로운 메소드나 함수를 마치 기존 Java API 에 있었던 함수처럼 추가할 수 있게 해준다.

// 코틀린에서 확장 함수를 만들고 싶다면, 함수를 선언할 때 '확장할 클래스의 이름을 덧붙이기만' 하면 된다.
// 확장 함수를 선언하려면 함수 이름에 확장할 클래스의 이름을 '.'기호로 덧붙여 선언하기만 하면 된다.
// 덧붙인 클래스가 수신 객체의 타입이 되고, 함수 내부에서 'this'로 사용할 수 있다.

// 확장 함수 역시 다른 함수들과 같은 '가시성'을 가지기 때문에, 내부에서 확장 함수를 정의하면 클래스 내부에서만 해당 확장 함수를 사용할 수 있다.
fun String.lastString():String {
    return this.get(this.length - 1).toString()
}

class ExtTest {
    // String 클래스에 extFunc 라는 확장 함수를 추가
    fun String.extFunc(){
        // 확장함수 String.lastString() 에 접근 가능
        println(this.lastString())
    }

    fun method1(){
        // 확장함수 String.extFunc() 에 접근 가능
        "test".extFunc()
    }
}

fun test(){
    // 확장함수 String.lastString() 에 접근 가능
    "test".lastString()

    // 확장함수 String.extFunc() 에 접근 불가
//    "test".extFunc()
}