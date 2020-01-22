package com.engine

class GroovyClassLoaderTest {

    static void main(String[] args) {

        GroovyClassLoader groovyClassLoader = new GroovyClassLoader();
        String scriptText = "class Hello { void hello() { println 'hello' } }"
        //将Groovy脚本解析为Class对象
        Class clazz = groovyClassLoader.parseClass(scriptText);
        //Class clazz = groovyClassLoader.parseClass(new File("test1.groovy"))

        clazz.getMethod("hello").invoke(clazz.newInstance())
    }
}
