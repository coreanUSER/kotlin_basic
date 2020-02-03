package com.ptk.kotilnsample

import android.widget.Toast

// 클래스 외부에 선언된 함수는 '최상위 함수'라고 부르며, 모든 코드에서 사용할 수 있습니다.
fun toastShort(message: String){
    Toast.makeText(MainApplication.getAppContext(), message, Toast.LENGTH_SHORT).show()
}

fun toastLong(message: String){
    Toast.makeText(MainApplication.getAppContext(), message, Toast.LENGTH_LONG).show()
}