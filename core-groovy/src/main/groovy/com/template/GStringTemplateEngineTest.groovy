package com.template

class GStringTemplateEngineTest {

    static void main(String[] args) {

        def binding = [
                firstname : "Grace",
                lastname  : "Hopper",
                accepted  : true,
                title     : 'Groovy for COBOL programmers'
        ]

        def f = new File('E:\\github\\lihongjie\\tutorials\\core-groovy\\src\\main\\resources\\test.template')
        def engine = new groovy.text.GStringTemplateEngine()
        def template = engine.createTemplate(f).make(binding)
        println template.toString()

    }
}
