package com.ptk.kotilnsample

// 코틀린은 클래스 위임을 언어 차원에서 제공하기 때문에 간결하게 표현할 수 있다.
// 아래의 경우 ArrayList 로 모두 위임한 것이기 때문에 코틀린은 한 줄로 코드를 작성할 수 있는데, 이게 가능한 이유는 코틀린의 'by'라는 키워드 때문이다.
// 'innerList'라는 ArrayList 타입의 프로퍼티가 있고 'Collection' 인터페이스를 상속받는데,
// "Collection 인터페이스의 기능을 'innerList'에 위임하겠다"는 의미이다.

// 코틀린은 '가변성(var)'과 '불변성(val)'을 타입 선언부터 구분하고 있다.
// 코틀린은 컬렉션을 다룰 때에도 똑같은 철할을 적용하는데, 코틀린에서 그냥 ArrayList, Collection 을 사용하면 '불변'을 의미한다.
// 즉, Collection 에 원소를 추가하거나 삭제할 수 없게 된다.
// Java 의 Collection 과 동일하게 사용하려면, 코틀린에서는 'MutableCollection'을 사용해야 한다.
// Java 의 ArrayList 는 코틀린의 'MutableArrayList'에 해당한다.

// 이후 특정 메소드에서 확장된 기능을 사용하고 싶다면 변경이 필요한 메소드만 오버라이드하면 된다.
class DelegatingArrayList<T>(val innerList: MutableCollection<T> = mutableListOf()) : MutableCollection<T> by innerList {

    // add 메소드는 기존의 기능에 전달받은 아이템을 로그로 출력하는 기능을 추가한다.
    override fun add(element: T): Boolean {
        // 확장 기능을 실행
        printItem(element)
        // innerList 에 기능을 위임한다.
        return innerList.add(element)
    }

    // 아이템을 프린트 하는 함수
    fun printItem(item: T){
        println(item.toString())
    }
}