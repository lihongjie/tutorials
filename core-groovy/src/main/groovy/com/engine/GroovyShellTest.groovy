package com.engine

class GroovyShellTest {

    static void main(String[] args) {

        GroovyShell shell = new GroovyShell();
//可以绑定更多变量
        shell.setVariable("age",22);
//直接求值
        shell.evaluate("if(age < 18){'未成年'}else{'成年'}");
//解析为脚本，延迟执行或者缓存起来
        Script script = shell.parse("if(age < 18){'未成年'}else{'成年'}");
        println(script.run())
//可以从更多位置加载/执行脚本
//shell.evaluate(new File("script.groovy"));
//shell.evaluate(new URI("http://wwww.a.com/script.groovy"));


        GroovyShell shell2 = new GroovyShell();
        Script script2 = shell2.parse("script.groovy");

        Binding binding = new Binding();
        binding.setVariable("str1", "value1")
        binding.setVariable("str2", "value2")

        script2.setBinding(binding)
        System.out.println(script2.evaluate("customConcat(str1, str2)"))

        script2.groovy



    }

    def customConcat(def str1, def str2) {
        str1.concat(str2)
    }

}
