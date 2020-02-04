package com.ptk.kotilnsample;

import android.widget.Toast;

public class ToastUtilJava {
    // 짧은 토스트 메시지를 보여주는 함수
    public static void toastShort(String message){
        Toast.makeText(MainApplication.getAppContext(), message, Toast.LENGTH_SHORT).show();
    }

    // 긴 토스트 메시지를 보여주는 함수
    public static void toastLong(String message){
        Toast.makeText(MainApplication.getAppContext(), message, Toast.LENGTH_LONG).show();
    }

    // 파라미터에 따라 긴 토스트 메시지, 또는 짧은 토스트 메시지를 보여준다.
    public static void toast(String message, int length){
        Toast.makeText(MainApplication.getAppContext(), message, length).show();
    }

    // 파라미터의 기본값을 사용하기 위해 메소드 오버라이딩
    public static void toast(String message){
        toast(message, Toast.LENGTH_SHORT);
    }
}
