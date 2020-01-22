package com.template

class SimpleTemplateEngineTest {

    public static void main(String[] args) {

        def text = 'Dear "$firstname $lastname",\nSo nice to meet you in <% print city %>.\nSee you in ${month},\n${signed}'

        def binding = ["firstname":"Sam", "lastname":"Pullara", "city":"San Francisco", "month":"December", "signed":"Groovy-Dev"]

        def engine = new groovy.text.SimpleTemplateEngine()
        def template = engine.createTemplate(text).make(binding)

        def result = 'Dear "Sam Pullara",\nSo nice to meet you in San Francisco.\nSee you in December,\nGroovy-Dev'
        println(template.toString())
    }
}
