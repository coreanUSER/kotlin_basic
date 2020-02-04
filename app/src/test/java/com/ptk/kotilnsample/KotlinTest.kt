package com.ptk.kotilnsample

import org.junit.Assert
import org.junit.Test

class KotlinTest {
    @Test
    fun test1() {
        Assert.assertEquals(4, 2+2)
    }

    // Java 코드에서 코틀린의 Getter 와 Setter 를 사용하기 위해서는 각 멤버 변수에 대해 Getter 와 Setter 메소드를 사용해야 하지만,
    // 코틀린에서는 그럴 필요가 없습니다.
    @Test
    fun testGetterSetter(){

        // 코틀린의 Person 객체를 생성하고 이름을 "Jhon"으로 설정
        val person = Person("Jhon")

        // 코틀린은 age 를 직접 사용해도 자동으로 setter 가 호출된다.
        person.age = 20

        // 설정한 값이 정상적인지 테스트
        // 마찬가지로 직접 프로퍼티 접근해도 자동으로 getter 가 불린다.
        Assert.assertEquals(20, person.age)
        Assert.assertEquals("Jhon", person.name)
    }

    @Test
    fun testSetNickname(){
        val person = Person("Jhon")
        // 대문자가 포함된 문자열을 닉네임으로 설정해도 소문자로 저장한다.
        person.nickname = "Banana"
        // 대문자가 포함된 문자열이 소문자로 되었는지 확인
        Assert.assertEquals("banana", person.nickname)
    }
}