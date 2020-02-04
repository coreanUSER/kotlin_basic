package com.ptk.kotilnsample;

// ISword 인터페이스를 상속받는다.
public class MagicSwordDelegate implements ISword {
    // ISword 타입의 객체를 필드로 가지고 있는다.
    // 단지 Sword 클래스를 확장하려면 Sword 타입으로 해도 되지만 ISword 타입으로 하면 확장성이 더욱 커지게 된다.
    // 인터페이스를 필드로 가지고 있으면 이후 인터페이스를 상속받은 모든 클래스에 대하여 확장 기능을 사용할 수 있다.
    ISword iSword;

    // 생성자에서 ISword 타입의 객체를 생성자에서 받는다
    public MagicSwordDelegate(ISword iSword) {
        this.iSword = iSword;
    }

    // 장착시 불리는 메소드
    @Override
    public void equip() {
        // 멋진 사운드를 플레이한다.
        playWonderfulSound();

        // 기존 기능은 iSword 에 위임한다.
        iSword.equip();

        // '기존에 설계된 객체에게 책임을 전달하는 것'이 위임이다.
        // 확장 기능은 자신이 실행하고, 기존 Sword 의 기능은 그대로 기존 객체의 메소드에 전달하는 방식이다.
    }

    // 확장기능 - 멋진 사운드를 플레이하는 메소드
    public void playWonderfulSound(){
        // 멋진 사운드를 플레이 한다.
        System.out.println("짜잔");
    }
}
// 데코레이터 패턴은 이런 위임을 활용한 패턴 중 하나로, 보통 기존 기능에 추가긴으을 덧붙이는 패턴이다.
// 데코레이터 패턴을 활용하면 기존 클래스를 상속받지 않은 상태로 새로운 추가 기능을 덧붙이거나 확장할 수 있다.
// 문제는 이런 데코레이터 패턴의 경우 단순한 경우에도 코드가 상당히 길어진다는 것이다.
