package com.ptk.kotilnsample

// Java 역시 싱글턴 패턴의 구현 자체는 크게 어려운 것은 아니지만, 자주 사용하는 패턴 중 하나로서 비슷한 코드를 매번 작성하는 것은 꽤 번거롭다.
// 코틀린은 이런 뻔한 코드들을 줄여 주기 위해 'object'라는 클래스 타입을 제공한다.
// 'object' 키워드는 "해당 클래스가 싱글턴임"을 알려준다.
object SingletonKotlin {
    fun log(text: String){
        println(text)
    }
}