package com.template

import groovy.text.SimpleTemplateEngine

class TemplateExample2 {

    static void main(args) {

        def pers1 = new Person(age: 12, fname: "Sam", lname: "Lover")


        def fle = new File("E:\\github\\lihongjie\\tutorials\\core-groovy\\src\\main\\resources\\person_report.tmpl")

        def binding = ["p": pers1]

        def engine = new SimpleTemplateEngine()
        def template = engine.createTemplate(fle).make(binding)

        assert engine != null
        assert template != null

        println template.toString()

    }
}

class Person {
    def age
    def fname
    def lname

    String toString() {
        return "Age: " + age + " First Name: " + fname + " Last Name: " + lname
    }
}