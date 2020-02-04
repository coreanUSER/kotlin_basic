package com.ptk.kotilnsample

// 코틀린에서는 'var 변수'의 경우 Getter 와 Setter 가 자동 생성되므로 멤버 변수는 자동으로 Property 가 된다.
// 'val 변수' 또한 Getter 가 자동 생성되므로 역시 Property 가 된다.
class PropertyKotlin {
    // property1 은 Getter, Setter 가 존재함
    var property1 = 0

    // property2 는 Getter 만 존재함
    val property2 = 1
}