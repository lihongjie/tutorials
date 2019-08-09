package com.github.lihongjie.observer;

/**
 *  Observer interface
 */
public interface Observer {

    //当主题状态改变时,会将一个String类型字符传入该方法的参数,每个观察者都需要实现该方法
    void update(Subject s);
}