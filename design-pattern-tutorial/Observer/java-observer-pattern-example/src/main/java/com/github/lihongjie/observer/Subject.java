package com.github.lihongjie.observer;

/**
 * Subject interface
 * In this interface , we can only declare top 3 function,
 * other function we can define in an abstract class which implements
 * this interface
 */

import java.util.*;

public interface Subject {

    //添加观察者
    void attach(Observer o);

    //移除观察者
    void detach(Observer o);

    //当主题方法改变时,这个方法被调用,通知所有的观察者
    void sendNotify();

    Vector getState();

    void setState(String act, String str);
}