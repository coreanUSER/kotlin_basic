package com.ptk.kotilnsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.layout_variable.*
import java.text.SimpleDateFormat
import java.util.*

class VariableKatlinActivity : AppCompatActivity() {

    // var
    // 변경 가능한 참조, 변경 가능하다는 의미의 'Variable'을 나타냅니다.
    // Java 의 일반적인 변수에 해당합니다.

    // val
    // 변경 불가능한 참조를 저장하는 변수로서, 특정한 값을 의미하는 'Value'를 나타냅니다.
    // val 로 선언하면 초기화 이후 '변수의 재 대입'이 불.가능합니다.
    // Java 에서 'final' 키워드로 선언하는 것과 같습니다.

    // 반면 변수를 불변으로 선언할 경우, '메모리, 멀티쓰레드 안정성, 함수형 코드' 등 얻을 수 있는 이점이 많습니다.
    // 때문에 코틀린은 가급적 모든 변수를 'val'로 선언하여 불변으로 설정하고, 필요한 경우에만 'var'을 쓰도록 권장하고 있습니다.

    // 변수의 타입 추론
    // 코틀린에서 변수를 선언하는 방법은 변수 이름을 먼저 적고 그 뒤에 값을 적습니다.
    // var clickCount = 0
    // 코틀린에서 변수 타입을 생략하지 않고 쓰면 다음과 같습니다.
    // var clickCount:Int = 0 (JAVA 에서는 Int clickCount = 0)
    // 초기화 시점에서 정수로 초기화하였다면 해당 변수는 '정수형'일 것이기 때문에, 코틀린은 변수의 타입 추론이 가능한 경우에 굳이 타입을 명시하지 않아도 됩니다.

    // 코틀린은 컴파일 시점에 타입을 결정하는 정적 타입 언어입니다.
    // 정적 타입 언어: 컴파일 시에 타입 캐스팅 문제를 확인할 수 있고, 실행이 빠르다는 장점이 있지만,
    // 반드시 변수를 선언할 때 타입을 적어야 하므로 코드 작성 시에 타입을 신경 써야하는 불편함이 있다.

    // 동적 타입 언어: 변수의 타입에 상관없이 코딩하기 때문에 코드 작성이 쉽지만,
    // 사전에 타입을 체크하지 않기 때문에 프로그램 실행 중 타입으로 인한 에러가 발생할 수 있다는 단점이 있습니다.

    // 코틀린에서는 대부부느이 경우 타입을 지정할 피룡가 없기 때문에 얼핏 보면 '자바스크립트'나 '파이썬' 같은 동적 타입 언어라고 생각될 수 있지만,
    // 정적 타입 언어이며 변수의 타입을 '추론'한다는 차이점이 존재합니다.

    // 클릭된 횟수를 저장할 변수
    var clickCount = 0

    // Activity 가 시작된 시간
    val startTime = System.currentTimeMillis()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // UI 로 사용할 XML 파일을 지정한다.
        setContentView(R.layout.layout_variable)

        // 시작시간을 텍스트 형태로 변환
        val timeText = SimpleDateFormat("HH:mm:ss", Locale.KOREA).format(startTime)

        // 시작시간을 ㄹ텍스트뷰에 보여줌
        startTimeLabel.text = "Activity 시작시간: ${timeText}"

        // 클릭된 횟수 보여줌
        clickCountLabel.text = "버튼이 클릭된 횟수: ${clickCount}"

        // 버튼에 이벤트 리스너 설정
        button.setOnClickListener {

            // 클릭된 횟수 추가
            clickCount = clickCount + 1

            // UI 에 클릭횟수 다시 보여줌
            clickCountLabel.text = "버튼이 클릭된 횟수: ${clickCount}"
        }
    }
}
