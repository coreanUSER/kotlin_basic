package com.ptk.kotilnsample;

// Java 에서 클래스는 모두 Object 클래스를 상속받는다.
// 'Object 클래스'는 모든 클래스의 조상과 같은 존재로서, 'toString(), equals(), hashCode()' 메소드를
// 하위 클래스에서 오버라이드 할 수 있도록 제공한다.
// 위의 3가지 메소드는 가급적 모든 클래스가 오버라이드하는 것이 좋다.
public class FruitJava {
    // 과일 이름
    String fruitName;
    // 과일 설명
    String description;

    // toString() 메소드는 객체를 문자열로 표현하는 메소드이다.
    // 클래스를 정의하고 toString() 메소드를 재정의하지 않는 경우, 인스턴스의 클래스 이름과 해시코드가 출력된다.
    @Override
    public String toString() {
        return "FruitJava(" + fruitName + ", " + description + ")";
    }

    // equals() 메소드는 객체의 동등성을 비교하는데 사용한다.
    // Java 에서 equals() 메소드의 기본 구현은 '객체의 메모리 주소가 가은 경우'에만 "두 객체가 같다"고 판단한다.
    // 객체의 특정 필드가 같은 경우에 같은 객체로 취급해야 하는 경우에는 equals() 메소드를 오버라이드해야 한다.
    @Override
    public  boolean equals(Object obj) {
        // 먼저 같은 클래스인지 확인
        if(obj instanceof FruitJava){
            // FruitJava 클래스로 캐스팅한다.
            FruitJava another = (FruitJava) obj;

            // 모든 필드가 같다면 같은객체로 취급한다.
            return fruitName.equals(another.fruitName) && description.equals(another.description);
        }

        // 클래스가 같지 않다면 서로 다른 객체
        return false;
    }

    // hashCode() 메소드는 "같은 객체인 경우에는 같은 해시코드가 반한되어야 한다."는 의미를 가진다.
    // equals() 함수만 바꿔 버리면, 같은 객체여도 서로 다른 해시코드가 만들어지게 되고,
    // 이는 'HashMap, HashSet' 등의 자료 구조에서 에러를 발생시킨다.
    // 때문에 equals() 가 오버라이드 된 경우 반드시 hashCode() 도 오버라이드 해야한다.
    @Override
    public int hashCode(){
        // 객체가 같으면 해시코드도 같아야한다.
        // 즉, fruitName, description 이 같으면 같은 해시코드를 반환해야 한다.
        int hash = 7;
        hash = 31 * hash + (fruitName == null ? 0 : fruitName.hashCode());
        hash = 31 * hash + (description == null ? 0 : description.hashCode());

        return hash;

        // 서로 다른 문자열이 같은 hash 값을 가지지 않도록 '소수(Prime Number)'를 곱해준다.
        // Java 에서 hashCode() 함수를 구현하면, 보통 소수를 각각 필드에 곱하면서 구하기 때문에 꽤나 복잡하다.
        // 'Objects.hash()' 함수를 사용하면 이러한 작업을 대신해준다.
        // Objects.hash(fruitName, description)
        // 이 함수는 JDK 8 버전에서 추가된 것으로, 안드로이드 기준 'API LEVEL 19' 이하에서는 실행되지 않는다.
        // API LEVEL 19 버전 미만에서는 구글 '구아마(Google GUABA)' 라이브러리를 사용하여 구현할 수 있다.
        // 구글의 구아바 라이브러리를 사용하는 경우, 'build.gradle'에 다음 행을 추가해주면 된다.
        // compile group: 'com.google.guava', name: 'guava', version: '11
    }
}
