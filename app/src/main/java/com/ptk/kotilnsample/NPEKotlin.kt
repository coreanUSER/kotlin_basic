package com.ptk.kotilnsample

// 코틀린의 타입 시스템은 타입을 정의할 때 '널 가능성'을 표기하도록 한다.
// 코틀린을 비롯한 최신 언어에서 널에 대한 접근 방식은 "최대한 오류를 컴파일 시점에 알 수 있도록" 하는 것이다 .

// 코틀린은 만약 널이 될 수 있는 프로퍼티나 변수인 경우, 타입을 선언할 때 반드시 '널 가능성'을 명시해야 한다.
// 코틀린 타입은 기본적으로는 널(NULL) 을 허용하지 않는다.
fun strLenNonNull(str: String): Int {
    // 파라미터로 받은 str 은 널이 될 수 없으므로 안전하다.
    return str.length
}

// 만일 널(NULL) 가능성이 있다면 타입에 ?를 붙여야 한다.
fun strLenNullable(str: String?): Int {
    // 널 가능성이 있는 str 메소드에 접근하면 에러가 발생한다.
    // return str.length

    // if 로 널체크를 한다.
    // 코드에서 널 체크를 하면 코틀린은 알아서 'Type?'에서 'Type'으로 '스마트 캐스팅'한다.
    // if 문 대신에 when 문을 사용해도 마찬가지로 스마트 캐스팅이 구현된다.

    if (str != null) {
        // 널체크 이후 str 은 String? 타입에서 String 타입으로 스마트 캐스팅된다.
        return str.length
    } else {
        return 0
    }
}

// 문자열에 끝 Char 를 반환한다.
fun strLastCharNullable(str: String?): Char? {
    // 엘비스 연산자
    // ?. 연산자는 str 이 NULL 이면 "".single() 이 반환된다.
    return str?.get(str.length - 1 ) ?: "".single()
}

// 코틀린은 수신 객체가 널이 아닌 경우에만 실행되는 'let 함수'를 제공한다.
// let 함수를 이용한 예제
fun strPrintLen(str: String?) {
    // let 함수는 수신객체인 str 이 널이면 실행되지 않는다.
    str?.let { print(strLenNonNull(it)) }

    // let 함수는 '수신 객체가 널이 아닌 경우'에만 람다 함수가 실행된다.
    // 이때 람다 함수 내부에서 수신 객체는 스마트 캐스팅되어 '널이 불가능한 타입'으로 변환된다.
}