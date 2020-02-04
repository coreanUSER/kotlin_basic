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
}
