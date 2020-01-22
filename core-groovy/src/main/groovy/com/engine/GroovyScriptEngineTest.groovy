package com.engine

import java.util.concurrent.TimeUnit

class GroovyScriptEngineTest {

    static void main(String[] args) {

        GroovyScriptEngine scriptEngine = new GroovyScriptEngine("script/groovy");
        Binding binding = new Binding();
        binding.setVariable("name", "groovy");
        while (true){
            scriptEngine.run("hello.groovy", binding)
            TimeUnit.SECONDS.sleep(1)
        }
    }
}
