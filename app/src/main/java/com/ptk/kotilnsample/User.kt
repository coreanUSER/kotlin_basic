package com.ptk.kotilnsample

import java.io.InputStreamReader
import java.net.URL
import kotlin.properties.Delegates

// 'User' 클래스의 'nickname'이라는 속성(property)이 있는데, 이것이 DelegateString 에 위임될 수 있는 이유는
// 코틀린의 '속성(property)'은 Field 로 정해지는 것이 아닌 접근자인 'Getter, Setter'에 의해 결정되기 때문이다.
class User {
    // 닉네임은 DelegateString 클래스에 위임
    var nickname by DelegateString()

    // 코틀린은 프로퍼티의 위임을 위해 기본적으로 제공되는 3가지 방법을 추가로 제공한다.
    // 1. lazy 위임 : 프로퍼티의 초기화를 인스턴스 생성 시점이 아니라 프로퍼티를 사용하는 시점에 초기화 하는 것
    // 초기화가 오래 걸리는 속성이 있을 경우, 인스턴스 생성 시점에 모든 초기화를 진행한다면 전체적인 성능이 매우 저하된다.
    // 그래서 일단은 초기화를 하지 않고 사용하다가 실제로 사용하는 시점에 초기화를 하는 것을 '게으른 초기화(lazy initialization)'라 하며,
    // 프로그래밍에서 매주 자주 사용하는 패턴이다.

    // lazy 위임은 val 키워드로 선언되어야만 가능하다.
    // 네트워크에서 받은 텍스트는 시간이 걸리므로 실제로 사용할 때 초기화

    // 보통 네트워크에서 데이터를 읽어오는 경우 속도가 느리기 때문에, 인스턴스 생성 시점에 httpText 를 초기화하면
    // 실제로는 httpText 를 사용하지 않는다고 해도 초기화가 느려지게 된다.
    // 게으른(lazy) 초기화 기법은 이러한 경우에 사용하는 것이 좋다.
    val httpText by lazy {
        println("lazy init start")
        InputStreamReader(URL("https://www.naver.com").openConnection().getInputStream()).readText()
    }

    // 게으른 초기화를 위한 lateinit
    // 게으른 초기화를 지원하기 위한 방법으로 코틀린은 'lateinit'라는 키워드를 지원한다.
    // lateinit var name: String
    // lateinit은 lazy처럼 위임이 아닌 변수의 '변경자(modifier)'로 사용된다.
    // 변경자(modifier)란 변수의 성질을 변경하는 것인데 'private, public, static, final' 등 이 있다.
    // lateinit은 컴파일러에게 "이 프로퍼티는 이후 초기화되어 null 이 아닐 것이 확실하니, 사용할 때 null 을 신경쓰지 않고 사용하겠다"고 알려주는 역활을 한다.
    // lateinit로 선언된 변수가 null 일 경우 'Null Point Exception'가 발생한다.


    // 2. observable 위임 : 주로 관찰하고자 하는 대상에 변경 사항이 생길 때, 변경된 사실을 관측자에게 알려주는 것
    // 관찰의 대상은 프로퍼티이다.
    // name 프로퍼티 값이 변경될 때 마다 자동으로 observable 의 코드가 실행된다.
    var name: String by Delegates.observable(""){
        property, oldValue, newValue ->
        println("기존값: ${oldValue}, 새로 적용될 값: ${newValue}")
    }

    // 3. storing 위임 : 프로퍼티를 Map 객체에 위임하는 것
    // Java 와 코틀린에서 'Map' 객체는 "Mapping 한다"는 의믜로서 'Key, Value'로 이루어진다.
    // 특정 Key 에 해당하는 Value 를 저장하는 자료구조
    // 최근 네트워크 통신은 대체적으로 'JSON' 통신을 사용하는데, Json 의 경우 Map 객체와 완전히 호환된다.
    // Animal Class 로 이동!
}