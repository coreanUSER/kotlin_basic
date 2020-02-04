package com.ptk.kotilnsample;

// '프로퍼티(Property)'는 Field 와 외부에서 접근 가능한 Getter 또는 Setter 가 있는 경우다.
// 즉, '프로퍼티(Property)'는 Field 와 접근 가능한 Getter, Setter 의 조합을 의미한다.
public class PropertyJava {
    // Field 가 선언되어 있고 Getter, Setter 가 있는 경우 Property
    private int property1 = 0;

    public int setProperty1() {
        return property1;
    }

    public void setProperty1(int property1) {
        this.property1 = property1;
    }

    // 변수의 값을 읽을 수만 있는 경우도 Property 라 할 수 있음
    private String property2 = "";

    public String getProperty2() {
        return property2;
    }

    // 단순 field 는 property 가 아니다.
    private int notProperty1 = 0;

    // 클래스 변수 역시 property 가 아니다.
    private static int notProperty2;
}
