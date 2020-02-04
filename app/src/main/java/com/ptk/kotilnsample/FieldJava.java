package com.ptk.kotilnsample;

// 필드('Field')는 클래스에 선언되어 있는, '클래스 변수'가 아닌 '인스턴스 변수'를 의미
// 필드는 외부에서 접근할 수 있는 Getter, Setter 메소드가 반드시 존재할 필요가 없음

// 클래스의 인스턴스 변수들을 모두 '필드(Field)'라 부른다.
public class FieldJava {
    // 인스턴스에서 사용하는 변수이므로 Field
    public int field1;

    // 접근 제어자와 상관없이 모두 Field
    private double field2;
    protected String field3;

    // Getter, Setter 가 있어도 Field
    private int field4;

    public int getField4() {
        return field4;
    }

    public void setField4(int field4) {
        this.field4 = field4;
    }

    // 클래스 변수는 Field 가 아님
    static int notField1;

    void func1() {
        // 함수 내의 변수들은 Field 가 아닌 지역변수.
        int notField2 = 0;
    }
}
