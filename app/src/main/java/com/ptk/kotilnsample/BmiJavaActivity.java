package com.ptk.kotilnsample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.TestLooperManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BmiJavaActivity extends AppCompatActivity {

    // findViewById() 함수는 꽤 비용이 비싼 함수로, 즉 자원 소모가 큰 함수로서 버튼이 클릭될 때마다
    // UI 요소를 전부 findViewById()로 찾는 것은 성능면에서 매우 안 좋은 패턴입니다.
    // 따라서 성능면에서 물리한 findViewById()가 계속 호출되지 않도록,
    // onCreate() 함수에서 Activity 가 최초로 실행될 때 '변수'로 바인딩해 두고 그 이후에는
    // 해당 '변수'로만 접근하는 것이 보다 일반적이고 효율적입니다.

    // 불필요한 findViewById 함수를 피하기 위해 UI 요소를 멤버 변수로 가지고 있는다.
    EditText tallField;
    EditText weightField;
    TextView resultLabel;
    Button bmiButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // UI로 사용할 레이아웃 XML 파일을 지정한다.
        setContentView(R.layout.layout_view_binding);

        // UI 요소 멤버변수를 XML 레이아웃에서 findViewById 함수를 이용해 바인딩한다.
        tallField = findViewById(R.id.tallField);
        weightField = findViewById(R.id.weightField);
        resultLabel = findViewById(R.id.resultLabel);
        bmiButton = findViewById(R.id.bmiButton);

        // bmiButton 이 클릭된 경우의 이벤트 리스너를 등록한다.
        findViewById(R.id.bmiButton).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // tallField 의 값을 읽어온다.
                String tall = tallField.getText().toString();

                // weightField 의 값을 읽어온다.
                String weight = weightField.getText().toString();

                // Bmi 를 계산한다. 체중(kg) / 키(m) * 키(m) >> 키를 cm 로 입력받았으므로 100으로 나누어 제곱한다.
                // Math.pow() 는 넘겨받은 파라미터 값을 제곱해서 돌려준다.
                // 예를들어, Math.pow(2, 3) 은 2의 3제곱 8을 돌려준다.
                double bmi = Double.parseDouble(weight) / Math.pow(Double.parseDouble(tall) / 100.0 , 2);

                // 결과 bmi 를 resultLabel 에 보여준다.
                resultLabel.setText("키: " + tall + ", 체중: " + weight + ", BMI: " + bmi);
            }
        });
    }
}
