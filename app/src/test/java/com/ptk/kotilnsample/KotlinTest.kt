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

    @Test
    fun testUser(){
        val user = User()
        // 닉네임을 대소문자가 섞인 문자열로 설정
        user.nickname = "death Note"
        // 닉네임으느 모두 대문자로 변경되어야 한다.
        Assert.assertEquals("DEATH NOTE", user.nickname)

        // 처음 nickname 을 설정하면 위임된 Setter 에서 로그를 출력하고, 대문자로 값을 저장한다.
        // 코틀린은 필드(Field)를 사용하지 않기 때문에 얻을 수 있는 이점 중 하나가 바로 이러한 '프로퍼티(Property, 속성) 위임'이다
        // 코틀린의 프로퍼티는 Getter, Setter 연산자에 의해 결정되므로, Getter, Setter 를 정의한 어느 클래스로도 위임이 가능하다.
        // 또한 프로퍼티를 특정 타입으로 선언하느 것보다 프로퍼티를 위임할 경우 훨씬 많은 유연성을 제공한다.
    }

    @Test
    fun testUserLazy(){
        val user = User()
        // 초기화 순서를 확인하기 위해 프린트를 추가
        println("not init")
        // 불리는 시점에는 초기화가 되어 NULL 이 아니게 된다
        Assert.assertNotNull(user.httpText)
    }

    @Test
    fun testUserObservable(){
        val user = User()
        user.name = "john"
        user.name = "james"
    }

    @Test
    fun testAnimalByMap(){
        // Animal 객체를 생성할 때 맵 객체를 넘긴다.
        val animal = Animal(mutableMapOf(
            "name" to "cat",
            "age" to 20
        ))

        // name 속성이 map 객체에 정상적으로 위임되었는지 확인
        Assert.assertEquals("cat", animal.name)
        // age 속성이 map 객체에 정상적으로 위임되었는지 확인
        Assert.assertEquals(20, animal.age)

        // 프로퍼티의 값을 변경한다.
        animal.age = 21
        animal.name = "dog"

        // map 의 값들이 바꼈는지 확인
        Assert.assertEquals("dog", animal.name)
        Assert.assertEquals(21, animal.age)
    }

    @Test
    fun testFruit(){
        // 객체의 속성 값을 같도록 Fruit 객체 2개 생성
        val fruit1 = Fruit("바나나", "바나나는 길어")
        val fruit2 = Fruit("바나나", "바나나는 길어")

        // 각각 프린트한다. toString() 호출
        println(fruit1)
        println(fruit2)

        // 두 객체가 같은지 비교한다. equals() 호출
        Assert.assertEquals(fruit1, fruit2)

        // 두 객체의 해시코드가 같은지 비교한다.
        Assert.assertEquals(fruit1.hashCode(), fruit2.hashCode())
    }

    @Test
    fun testLambda1() {
        // 함수의 파라미터로 람다식 전달
        println(sum(1, 2))
        // 람다식 반환 값으로 비교
        Assert.assertEquals(4, sum(1, 3))

        // LambdaEx.kt 파일에서 선언한 sum 은 '최상위 프로퍼티'이기 때문에 바로 접근이 가능
        // 함수의 파라미터로 sum 을 전달할 수도 있는 등 자유롭게 사용 가능하다.
        // 코틀린이 함수를 일급객체로 취급하기 때문,
        // '일급 객체(First Class Citizen)'이란 함수형 프로그래밍에서 주로 사용하는 용어로 다음 조건을 만족해야 함
        //  - 변수와 자료 구조에 할당 가능해야 한다.
        //  - 함수의 파라미터로 전달이 가능해야 한다.
        //  - 함수의 반환값으로 전달이 가능해야 한다.
        //  - 동등성 비교가 가능해야 한다.

        // 함수에 람다 표현식을 바로 전달
        Assert.assertEquals(4, { x: Int, y: Int -> x * y }(2, 2))

        // 람다표현식 내부에서 람다표현식을 반환
        val exp = { x: Int, y: Int ->
            { z: Int -> (x + y) * z }
        }
        // exp2 --> {z: Int -> {(3 + 2) * z}}
        val exp2 = exp(3, 2)
        // result --> (3 + 2) * 4
        val result = exp2(4)
        // 결과확인
        Assert.assertEquals(20, result)
    }

    @Test
    fun testCollectionApi() {
        // 함수형 프로그래밍 스타일을 활용하면, 'Collection(컬랙션)'과 같은 데이터의 집합을 다루기 편리하다.
        // 코틀린은 컬렉션을 다룰 수 있는 여러 표준 라이브러리를 제공한다.
        // Collection 의 함수형 API

        // 컬렉션을 만든다
        val list = listOf(1, "2", 3, 4, 5.7, 1, 2)

        // filter: 컬렉션에서 특정 조건이 맞는 항목만 추출하여 새로운 컬렉션을 만든다 -> Int 타입만 추출
        println(list.filter { item -> item is Int })

        // 람다 표현식에서 파라미터가 하나인 경우 생략이 가능하다
        // 파라미터는 it 키워드로 접근가능
        println(list.filter { it is Int })

        // map: 컬렉션에서 아이템을 변환하여 새로운 컬렉션을 만든다. 아래 코드는 String 의 컬렉션이 만들어진다.
        println(list.map { "value: ${it}" })

        // filter 에서 반한된 컬렉션을 map 으로 변환
        println(list.filter { it is Int }.map { "value: ${it}" })

        // 아이템을 찾는다
        println(list.find { it is Double })

        // 컬렉션을 그룹화하여 Map<String, List<T>> 형태로 만든다. 아래 코드는 각 아이템의 클래스 별로 그룹화 한다.
        val map = list.groupBy { it.javaClass }
        println(map)

        // 컬렉션 안에 컬렉션이 있는 새로운 리스트를 만든다.
        val list2 = listOf(listOf(1, 2), listOf(3, 4))
        println(list2)

        // map 으로 항목을 변환한다.
        println(list2.map { "value: ${it}" })

        // flatmap 으로 리스트를 평평하게 만들고 변환한다.
        println(list2.flatMap { it.toList() })

    }

}