package com.ptk.kotilnsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.layout_control.*

class ControlKotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // UI 로 사용할 XML 파일을 지정합니다.
        setContentView(R.layout.layout_control)

        // 버튼이 클릭되었을때의 이벤트리스너 를 설정한다.
        button.setOnClickListener {
            // numberField 의 값을 익어 int 형으로 변환한다.
            val number = numberField.text.toString().toInt()

            // if, else if, else 문으로
//            if (number % 2 == 0) {
//                Toast.makeText(applicationContext, "${number} 는 2의 배수입니다.", Toast.LENGTH_SHORT).show()
//            } else if (number % 3 == 0) {
//                Toast.makeText(applicationContext, "${number} 는 2의 배수입니다.", Toast.LENGTH_SHORT).show()
//            } else {
//                Toast.makeText(applicationContext, "${number}", Toast.LENGTH_SHORT).show()
//            }

            // when 문은 케이스로 조건식도 사용가능
            when {
                number % 2 == 0 -> toast("${number} 는 2의 배수입니다.")
//                    Toast.makeText(applicationContext, "${number} 는 2의 배수입니다.", Toast.LENGTH_SHORT).show()
                number % 3 == 0 -> toast("${number} 는 3의 배수입니다.", Toast.LENGTH_SHORT)
//                    Toast.makeText(applicationContext, "${number} 는 3의 배수입니다.", Toast.LENGTH_SHORT).show()
                else -> toast(message = "${number}", length = Toast.LENGTH_SHORT)
                //  코틀린에서는 함수를 호출함에 있어 인자 앞에 이름을 사용할 수 있습니다.
                // '이름 붙인 인자'는 함수의 파라미터가 많을 때, 코드를 읽기 쉽게 만들어 줍니다.
//                    Toast.makeText(applicationContext, "${number}", Toast.LENGTH_SHORT).show()
            }

            // 코틀린에서는 switch 문을 대체해 when 을 사용할 수 있다.
            when (number) {
                // when 문 안에서 'in' 키워드를 사용하면 '..' 기호를 이용해 범위를 지정할 수 있다.
                // 코틀린의 when 문안에서는 ',' 연산자도 사용할 수 있다.
                in 1..4 -> button.text = "실행 - 4"
                // 코드가 2라인 이상인 경우, {}를 사용해 감싸줄 수 있다.
                9, 18 -> {
                    button.text = "실행 - 9"
                }
                // 코드가 1라인 경우, 간단히 표시할 수 있다.
                else -> button.text = "실행"
            }

        }
    }
}
