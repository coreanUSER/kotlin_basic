@file:JvmName("ToastUtil")
package com.ptk.kotilnsample
// package 상단에 '@file:JvmName' 명령을 사용하면, 컴파일 후의 '클래스 이름'을 지정할 수 있습니다.

import android.widget.Toast

// 클래스 외부에 선언된 함수는 '최상위 함수'라고 부르며, 모든 코드에서 사용할 수 있습니다.
fun toastShort(message: String){
    Toast.makeText(MainApplication.getAppContext(), message, Toast.LENGTH_SHORT).show()
}

fun toastLong(message: String){
    Toast.makeText(MainApplication.getAppContext(), message, Toast.LENGTH_LONG).show()
}

// 코틀린에서는 함수의 기본값을 지정 가능하다.
// Java 컴파일러는 코틀린의 '파라미터 기본값'을 처리하지 못합니다. 때문에,
// '@JvmOverloads' 구문을 사용하여 Java 에서 파라미터 기본값을 위해 메소드 오버로딩을 처리한 것과 같은 효과를 주게 됩니다.
@JvmOverloads
fun toast(message: String, length: Int = Toast.LENGTH_SHORT){
    Toast.makeText(MainApplication.getAppContext(), message, length).show()
}