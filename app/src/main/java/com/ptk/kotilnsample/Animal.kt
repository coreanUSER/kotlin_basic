package com.ptk.kotilnsample

// 'Animal' 객체를 생성할 때 'MutableMap'을 생성자로 전달한다.
// 이 작업을 통해 'name, age' 프로퍼티의 Getter, Setter 가 'Map'으로 위임되며, 'name, age' 프로퍼티가 초기화 된다.
// 이후 name, age 프로퍼티는 값을 읽을 때에도 전달받은 Map 객체의 값을 읽게 되고, 값을 변경하면 Map 객체의 Key 에 해당하는 Value 가 바뀌게 된다.
class Animal(val map: MutableMap<String, Any?>) {
    // 프로퍼티를 map 객체로 위임한다. map 객체에서 값을 읽고,
    // 값을 변경하면 map 객채에서 값이 변경된다.
    var name: String by map
    var age: Int by map
}