package com.template

import groovy.text.SimpleTemplateEngine

class ExampleTemplate3{

	 static void main(args) {
	    
	    def fle = new File("E:\\github\\lihongjie\\tutorials\\core-groovy\\src\\main\\resources\\simple-txt.tmpl")
		
		def binding = ["favlang": "Groovy"]
		
		def engine = new SimpleTemplateEngine()
		def template = engine.createTemplate(fle).make(binding)
		
		assert engine != null
		assert template != null
		
		println template.toString()
	}
}