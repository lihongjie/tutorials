package com.template

import com.baeldung.json.NodeTest
import groovy.text.SimpleTemplateEngine

class ScriptDemo {

    static void main(args) {

        def ll = []
        def mynode = new NodeTest(name: "aaa", title: "bbb", children: ll)

        def children = [mynode]

        def node = new NodeTest(name: "zhangsan", title: "Sam", children: children)


        def fle = new File("E:\\github\\lihongjie\\tutorials\\core-groovy\\src\\main\\resources\\demo.tmpl")

        def binding = ["n": node]

        def engine = new SimpleTemplateEngine()
        def template = engine.createTemplate(fle).make(binding)

        assert engine != null
        assert template != null

        println template.toString()
    }
}
