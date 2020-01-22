package com.template

class StreamingTemplateEngineTest {

    static void main(String[] args) {


        def text = '''\
Dear <% out.print firstname %> ${lastname},
<% for(i in 0..5) println 'A' %>
We <% if (accepted) out.print 'are pleased' else out.print 'regret' %> \
to inform you that your paper entitled
'$title' was ${ accepted ? 'accepted' : 'rejected' }.

The conference committee.'''

        def template = new groovy.text.StreamingTemplateEngine().createTemplate(text)

        def binding = [
                firstname: "Grace",
                lastname : "Hopper",
                accepted : true,
                title    : 'Groovy for COBOL programmers'
        ]

        String response = template.make(binding)

        assert response == '''Dear Grace Hopper,

We are pleased to inform you that your paper entitled
'Groovy for COBOL programmers' was accepted.

The conference committee.'''

        println(response.toString())
    }
}
