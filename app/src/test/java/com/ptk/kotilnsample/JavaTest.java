package com.ptk.kotilnsample;

import org.junit.Assert;
import org.junit.Test;

public class JavaTest {
    @Test
    public void test1() {
        // 'assertEquals' 속성은 '예상결과'와 '실제결과'을 비교해 보여준다.
        Assert.assertEquals(4, 2+2);
    }

    @Test
    public void testGetterSetter(){

        // PersonJava 클래스의 객체를 생성하고 이름을 "Jhon" 나이를 20으로 설정
        PersonJava personJava = new PersonJava("Jhon");
        personJava.setAge(20);

        // 설정한 값이 정상적인지 테스트
        Assert.assertEquals(20, personJava.getAge());
        Assert.assertEquals("Jhon", personJava.getName());

        // 코틀린의 Person 객체를 생성하고 이름을 "Jhon" 나이를 20으로 설정
        Person person = new Person("Jhon");
        person.setAge(20);

        // 설정한 값이 정상적인지 테스트
        Assert.assertEquals(20, person.getAge());
        Assert.assertEquals("Jhon", person.getName());

        // 코틀린이 Getter, Setter 를 자동으로 생성해주는 이유는 소프퉤어를 개발하다 보면 꽤 많은 비중의 클래스가
        // 특별한 로직없이 단순히 데이터를 저장하는 용도로 사용되기 때문입니다.
    }

    @Test
    public void testSetNickname(){
        // 자바로 작성한 PoersonJava 클래서의 객체 생성
        PersonJava personJava = new PersonJava("Jhon");

        // 대문자가 포함된 문자열을 닉네임으로 설정해도 소문자로 저장한다.
        personJava.setNickname("Apple");

        // 대문자가 포함된 문자열이 소문자로 되었는지 확인
        Assert.assertEquals("apple", personJava.getNickname());

        // 코틀린으로 작성한 Person 클래스 생성
        Person person = new Person("Jhon");

        // 대문자가 포함된 문자열을 닉네임으로 설정해도 소문자로 저장한다.
        person.setNickname("Apple");

        // 대문자가 포함된 문자열이 소문자로 되었는지 확인
        Assert.assertEquals("apple", person.getNickname());
    }

    @Test
    public void testMoveObject(){
        MoveObject moveObject = new MoveObject();
        // MoveObject 의 speed 를 아직 설정하지 않았으므로 0 인 상태로 calcAccuracy 함수를 호출
        int accuracy = Calculator.calcAccuracy(moveObject, 3);

        // Calculator.calcAccuracy() 는 MoveObject 의 스피드가 0 인 경우 자동으로 스피드를 1 로 만들고 계산
        Assert.assertEquals(1, moveObject.getSpeed());

        // MoveObject 의 실제 구현체를 CantMoveObject 로 생성
        MoveObject cantMoveObject = new CantMoveObject();
        // 똑같이 speed 를 설정하지 않고 calcAccuracy 를 호출
//        accuracy = Calculator.calcAccuracy(cantMoveObject, 3);
        // 위 코드에서 이미 에러가 발생해 실행되지 않음.
        // java.lang.ArithmeticException: / by zero -> '0'으로 나눗셈을 했을 때 발생
//        Assert.assertEquals(1, cantMoveObject.getSpeed());

        // MoveObject 를 사용하는 'Calculator'입장에서는 MoveObject 가 실제로는 어느 클래스인지 상관없이 사용할 수 있어야 한다.
        // 상속으로 오버라이딩을 하면서 Calculator 는 MoveObject 가 실제로 어떤 클래스인지 알 수 없어 에러가 발생하게 된다.

        // '캡슐화의 주요 목적' 중 하나는 클래스를 사용하는 측면에서 해당 클래스의 구체적인 사항을 모르게 하는 것이다.
        // 이 예제는 구체적인 구현 클래스를 알아야만 하므로 '캡슐화가 깨졌다'고 볼 수 있게 된다.

        // 이러한 예는 '취약한 기반 클래스 문제'의 일반적인 사례 중 하나이다.
        // Java 분야에서 유명한 서적 중 하나인 'Effective Java'에서는, 상속에 대하여
        // '상속을 위한 설계와 문서를 갖추거나, 그렇지 않은 경우 상속을 금지하라'라고 조언하고 있다.
        // 여기서 말하는 '상속'은 '인터페이스 상속'이 아니라 '코드의 구현을 상속받는 경우'를 말한다.
    }


}