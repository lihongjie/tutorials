package com.template

import groovy.text.SimpleTemplateEngine

class TemplateExample1 {

    static void main(args) {


        def fle = new File("E:\\github\\lihongjie\\tutorials\\core-groovy\\src\\main\\resources\\unit_test.tmpl")

        def coll = ["testBinding", "testToString", "testAdd"]

        def binding = ["test_suite": "TemplateTest", "test_cases": coll]

        def engine = new SimpleTemplateEngine()
        def template = engine.createTemplate(fle).make(binding)

        assert engine != null
        assert template != null

        println template.toString()


    }
}